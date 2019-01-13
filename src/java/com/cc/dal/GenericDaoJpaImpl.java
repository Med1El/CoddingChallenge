/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.dal;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author medEl
 * @param <T>
 */
public class GenericDaoJpaImpl<T> implements IGenericDao<T> {

    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final EntityTransaction et;

    public GenericDaoJpaImpl() {
        emf = Persistence.createEntityManagerFactory("CCPU");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    @Override
    public void add(T o) {
        et.begin();
        em.persist(o);
        et.commit();
    }

    @Override
    public T findById(Class c, int id) {
        Object o = (T) em.find(c, id);
        return (T) o;
    }

    @Override
    public List<T> findByParam(Class c, String param, String value) {
        return em.createQuery("select o from " + c.getName() + " as o where o." + param + " = '" + value + "' ").getResultList();
    }

    @Override
    public List<T> findBy2Params(Class c, String param1, String value1, String param2, String value2) {
        return em.createQuery("select o from " + c.getName() + " as o where o." + param1 + " = '" + value1 + "' and " + param2 + " = '" + value2 + "' ").getResultList();
    }

    @Override
    public void update(T o) {
        et.begin();
        em.merge(o);
        et.commit();
    }

    @Override
    public void update(T o, int id) {
        et.begin();
        em.merge(o);
        et.commit();
    }

    @Override
    public void delete(T o) {
        et.begin();
        em.remove(em.contains(o) ? o : em.merge(o));
        et.commit();
    }

    @Override
    public void delete(T o, int id) {
        et.begin();
        Object f = em.find(o.getClass(), id);
        em.remove(f);
        et.commit();
    }

    @Override
    public List<T> getAll(Class c) {
        return em.createQuery("select o from " + c.getName() + " as o").getResultList();
    }

}
