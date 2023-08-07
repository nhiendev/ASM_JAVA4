package DAO;

import java.util.List;

public abstract class entity <E, K>{
		abstract public E insert(E entity);
	    abstract public E update(E entity);
	    abstract public E delete(K key);
	    abstract public List<E> selectAll();
	    abstract public E selectById(K key);
}
