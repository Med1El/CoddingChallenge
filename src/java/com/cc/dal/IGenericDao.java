/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.dal;

import java.util.List;

/**
 *
 * @author medEl
 * @param <T>
 */
public interface IGenericDao<T> {

    public void add(T o); //create

    public T findById(Class c, int id); //read

    public List<T> findByParam(Class c, String param, String value);

    public List<T> findBy2Params(Class c, String param1, String value1, String param2, String value2);

    /* to-do
    public List<T> findByParams(Class c, List<String> params, List<String> values);
    */
    
    public void update(T o);

    public void update(T o, int id);

    public void delete(T o);

    public void delete(T o, int id);

    public List<T> getAll(Class c);

}
