package com.example.batman.repository;

import com.example.batman.model.Character;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Transactional
@Repository("characterRepository")
public class CharacterRepositoryImpl implements CharacterRepository {


    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Character> getCharacter(String name) {
        List<Character> character;
        String hql = "FROM Character as c WHERE c.name = :name";
         character = (List<Character>) em.createQuery(hql).setParameter("name", name).getResultList();
        if (character.isEmpty() || character == null) {
            character = Collections.emptyList();
        }

        return character;
    }

    @Override
    public void save(Character character) {
        em.persist(character);
        em.flush();

    }
}
