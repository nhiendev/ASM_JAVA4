package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.User;
import Entity.Video;

public class VideoDAO extends entity<Video, String>{
	private EntityManager em = JpaUtils.JPA_Utils.getEntityManager();
	@Override
	protected void finalize() throws Throwable {
		em.close(); // đóng EntityManager khi bị DAO giải phóng
		super.finalize();
	}
	@Override
	public Video insert(Video entity) {
		try {
			System.out.println(entity.toString());
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
	public Video update(Video entity) {
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
	public Video delete(String key) {
		try {
			System.out.println(key);
			Video entity = this.selectById(key);
			em.getTransaction().begin();			
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		}catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Video> selectAll() {
		String jqpl = "SELECT c FROM Video c";
		TypedQuery<Video> query = em.createQuery(jqpl, Video.class);
		List<Video> list = query.getResultList();
		return list;
	}

	@Override
	public Video selectById(String key) {
		Video video = em.find(Video.class, key);	
		return video;
	}
	public List<Video> selecByKeyword(String key) {
		String jpql = "SELECT  o FROM video o "
				+ " WHERE o.title LIKE :keyword";
				TypedQuery<Video> query = em.createQuery(jpql, Video.class);
				query.setParameter("keyword", "%"+key+"%");
				List<Video> list = query.getResultList();
				
		return list;
		
	}
	public List<Video> LikeVideo(String id) {
		String jpql = "SELECT video.title, video.poster,f.likeDate FROM Favorites f \r\n"
				+ "				where f.user.video.Id:=key";
				TypedQuery<Video> query = em.createQuery(jpql, Video.class);
				query.setParameter("key", id);
				List<Video> list = query.getResultList();
				
		return list;
		
		
	}
}
