package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.Setter;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.services.ICategorieProduitService;
import tn.esprit.rh.achat.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Set;

import javax.persistence.OneToMany;

@RestController
@Api(tags = "Gestion des categories Produit")
@RequestMapping("/categorieProduit")
public class CategorieProduitController {

	@Autowired
	ICategorieProduitService categorieProduitService;
	
	// http://localhost:8089/SpringMVC/categorieProduit/retrieve-all-categorieProduit
	@GetMapping("/retrieve-all-categorieProduit")
	@ResponseBody
	public List<CategorieProduit> getCategorieProduit() {
		List<CategorieProduit> list = categorieProduitService.retrieveAllCategorieProduits();
		return list;
	}

	// http://localhost:8089/SpringMVC/categorieProduit/retrieve-categorieProduit/8
	@GetMapping("/retrieve-categorieProduit/{categorieProduit-id}")
	@ResponseBody
	public CategorieProduit retrieveCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
		return categorieProduitService.retrieveCategorieProduit(categorieProduitId);
	}

	// http://localhost:8089/SpringMVC/categorieProduit/add-categorieProduit
	@PostMapping("/add-categorieProduit")
	@ResponseBody
	public CategorieProduit addCategorieProduit(@RequestBody CategorieRequestModel  categorieRequestModel ) {
		CategorieProduit cat = new CategorieProduit();
		cat.setCodeCategorie(categorieRequestModel.getCodeCategorie());
		cat.setLibelleCategorie(categorieRequestModel.getLibelleCategorie());
		categorieProduitService.addCategorieProduit(cat);
		CategorieProduit categorieProduit = categorieProduitService.addCategorieProduit(cat);
		return categorieProduit;
	}

	// http://localhost:8089/SpringMVC/categorieProduit/remove-categorieProduit/{categorieProduit-id}
	@DeleteMapping("/remove-categorieProduit/{categorieProduit-id}")
	@ResponseBody
	public void removeCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
		categorieProduitService.deleteCategorieProduit(categorieProduitId);
	}

	// http://localhost:8089/SpringMVC/categorieProduit/modify-categorieProduit
	@PutMapping("/modify-categorieProduit")
	@ResponseBody
	public CategorieProduit modifyCategorieProduit(@RequestBody CategorieRequestModel  categorieRequestModel) {
		return categorieProduitService.updateCategorieProduit(new CategorieProduit(categorieRequestModel.getIdCategorieProduit(),
				categorieRequestModel.getCodeCategorie(), categorieRequestModel.getLibelleCategorie(), categorieRequestModel.getProduits()));
	}

	
}

@Getter
@Setter
class CategorieRequestModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idCategorieProduit;
	private String codeCategorie;
	private String libelleCategorie;
	@OneToMany(mappedBy = "categorieProduit")
	@JsonIgnore
	private Set<Produit> produits;
}
