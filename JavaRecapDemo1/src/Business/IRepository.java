package Business;

import Entities.IEntity;

public interface IRepository<T extends IEntity> {
	void add(T entity);
	void update(T entity);
	void delete(T entity);
	void getDetail(T entity);
	void list(T[] entities);
}
