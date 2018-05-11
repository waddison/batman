package com.example.batman.repository;

import com.example.batman.model.Character;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository("characterRepository")
public class CharacterRepositoryImpl implements CharacterRepository {


    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Character> getCharacter(String name) {

        String hql = "FROM Character WHERE name = ?";
        List<Character> character =  em.createQuery(hql).setParameter(1, name).getResultList();
        //Query query = em.createQuery("Select c from Character c where ");

        return character;
    }

    @Override
    public void save(Character character) {
        em.persist(character);
        em.flush();
    }
}
