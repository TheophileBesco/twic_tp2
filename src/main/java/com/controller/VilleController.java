package com.controller;

import com.beans.Ville;
import com.forms.VilleFinder;
import com.forms.VilleEditer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
public class VilleController {

	@GetMapping(value="/ville")
	public List<Ville> get(@RequestParam(required  = false, value="codePostal") String codePostal) {
		VilleFinder finder = new VilleFinder();
		List<Ville> villes = (codePostal == null)?
				finder.listVilles():
				finder.findVilleByCodePostal(codePostal);
		return villes;
	}

	@PostMapping(value = "/villesave")
	public String post(@RequestParam(value="Code_commune_INSEE") String codeCommuneInsee,
					   @RequestParam(value="Nom_commune") String nomCommune,
					   @RequestParam(value="Code_postal") String codePostal,
					   @RequestParam(value="Libelle_acheminement") String libelle,
					   @RequestParam(value="Ligne_5") String ligne5,
					   @RequestParam(value="Latitude") String latitude,
					   @RequestParam(value="Longitude") String longitude){
		VilleFinder finder = new VilleFinder();
		Ville ville = finder.findVilleByCodeCommune(codeCommuneInsee);
		VilleEditer saver = new VilleEditer();
		if(ville == null){
			saver.saveVille(
					new Ville(Integer.parseInt(codeCommuneInsee),nomCommune,Integer.parseInt(codePostal),
							libelle,ligne5,Float.parseFloat(latitude),Float.parseFloat(longitude)));
			return "Ville créée.";
		} else{
			return "Ville déjà existante.";
		}
	}

	@PutMapping(value = "/villeput/{codeCommuneInsee}")
	public String put(@PathVariable String codeCommuneInsee,
					  @RequestBody Ville ville){
		VilleFinder finder = new VilleFinder();
		Ville currentVille = finder.findVilleByCodeCommune(codeCommuneInsee);
		VilleEditer editer = new VilleEditer();
		String message = "Ville modifiée.";
		ville.setCodeCommuneInsee(Integer.parseInt(codeCommuneInsee));
		if(currentVille == null){
			editer.saveVille(ville);
			message = "Ville créée.";
		} else{
			editer.editVille(ville);
		}
		return message;
	}

	@DeleteMapping(value = "/villedelete/{codeCommuneInsee}")
	public String delete(@PathVariable String codeCommuneInsee){
		VilleFinder finder = new VilleFinder();
		Ville ville = finder.findVilleByCodeCommune(codeCommuneInsee);
		String message = "Ville introuvable.";
		if(ville != null){
			VilleEditer editer = new VilleEditer();
			editer.deleteVille(codeCommuneInsee);
			message = "Ville supprimée.";
		}
		return message;
	}
}