package com.example.batman.repository;

import com.example.batman.model.Comic;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class ComicRepositoryImpl implements ComicRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comic> getComic(int id) {

        List<Comic> comic;
        String hql = "FROM Comic as c WHERE c.id = :id";
        comic = (List<Comic>) em.createQuery(hql).setParameter("id", id).getResultList();
        if (comic.isEmpty() || comic == null) {
            comic = Collections.emptyList();
        }

        return comic;
    }

    @Override
    public void save(Comic comic) {
        em.persist(comic);
        em.flush();
    }
}
