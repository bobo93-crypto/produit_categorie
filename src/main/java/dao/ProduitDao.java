package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Produit;

@Stateless
public class ProduitDao {
	
	
    @PersistenceContext
	EntityManager em;
    
    public void save(Produit p) {
    	em.persist(p);
    }
    public void update(Produit p) {
    	em.merge(p);
    }
	
}
