package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.User;
import Entity.Video;

public class UserDAO extends entity<User, String>{
	private EntityManager em = JpaUtils.JPA_Utils.getEntityManager();
	@Override
	protected void finalize() throws Throwable {
		em.close(); // đóng EntityManager khi bị DAO giải phóng
		super.finalize();
	}
	@Override
	public User insert(User entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity); // insert
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			 throw new RuntimeException(e);
		}
	
	}
	@Override
	public User update(User entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity); // update
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			 throw new RuntimeException(e);
		}
	}
	@Override
	public User delete(String id) {
		try {
			User entity = this.selectById(id);
			em.getTransaction().begin();			
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		}catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	@Override
	public List<User> selectAll() {
		String jqpl = "SELECT c FROM User c";
		TypedQuery<User> query = em.createQuery(jqpl, User.class);
		List<User> list = query.getResultList();
		return list;
		
	}
	@Override
	public User selectById(String key) {
		User user = em.find(User.class, key);	
		return user;
		
	}
	

}
