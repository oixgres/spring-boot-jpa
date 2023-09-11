package com.example.springbootjpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class JPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Course select(Long id){
        return entityManager.find(Course.class, id);
    }

    public void insert(Course course){
        entityManager.merge(course);
    }

    public void delete(Long id){
        entityManager.remove(select(id));
    }


}
