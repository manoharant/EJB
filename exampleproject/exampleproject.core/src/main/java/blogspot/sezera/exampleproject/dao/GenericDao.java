package blogspot.sezera.exampleproject.dao;

import java.io.Serializable;

public interface GenericDao<T extends Serializable,ID extends Serializable>{
	T makePersistent(T entity);
}