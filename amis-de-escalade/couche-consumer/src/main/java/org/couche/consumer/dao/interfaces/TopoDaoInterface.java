package org.couche.consumer.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface TopoDaoInterface<T, Id extends Serializable> {
	
	public void create(T entity);
    
    public void update(T entity);
     
    public T findById(Id id);
     
    public void delete(T entity);
     
    public List<T> findAll();
     
    public void deleteAll();
	
}
