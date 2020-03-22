package web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.CategorieDao;
import dao.ProduitDao;
import entities.Categorie;
import entities.Produit;

@Named
//@RequestScoped
@ConversationScoped
public class ProduitBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Conversation conversation;

	private Produit produit = new Produit();

	@EJB
	private ProduitDao produitDao;

	private Integer selectedCategorie;

	private Categorie categorie = new Categorie();

	@EJB
	private CategorieDao categorieDao;

	public ProduitBean() {

	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public void save() {
		produit.setCategorie(categorieDao.getById(selectedCategorie));
		produitDao.save(produit);
		

	}

	public String save_cat() {
		categorieDao.save_cat(categorie);
		conversation.end();
		return "page1";
	}

	public String categoriepage() {
		conversation.begin();
		return "page2";
	}

	public List<Categorie> getCategories() {
		return categorieDao.getAll();
	}

	public Integer getSelectedCategorie() {
		return selectedCategorie;
	}

	public void setSelectedCategorie(Integer selectedCategorie) {
		this.selectedCategorie = selectedCategorie;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

}
