package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Categorie;

@Stateless
public class CategorieDao {
         
	@PersistenceContext
	EntityManager em;
	
	public List<Categorie> getAll() {
		TypedQuery<Categorie> qry=em.createQuery("select c from Categorie c", Categorie.class);
		return qry.getResultList();
	}
	public Categorie getById(int id) {
		return em.find(Categorie.class, id);
	}
	public void save_cat(Categorie cat) {
		em.persist(cat);
	}
}
