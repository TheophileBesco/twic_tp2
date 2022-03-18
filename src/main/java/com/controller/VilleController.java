package com.controller;

import com.beans.Ville;
import com.dao.DaoFactory;
import com.dao.VilleDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
public class VilleController {

	private VilleDao villeDao;

	@RequestMapping(value="/ville", method=RequestMethod.GET)
	public String get(@RequestParam(required  = false, value="codePostal") String codePostal) {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.villeDao = daoFactory.getVilleDao();
		List<Ville> villes = (codePostal == null)?
				this.villeDao.listVilles():
				this.villeDao.listVillesByCodePostal(codePostal);
		String villesString = "";
		if(villes.isEmpty()){
			villesString = "Aucune ville ne correspond à ce code postal.";
		} else{
			for(Ville ville:villes){
				villesString += ville.getNomCommune().toLowerCase(Locale.ROOT)+", ";
			}
			villesString = villesString.substring(0,villesString.length()-2);
		}
		return villesString;
	}

	@RequestMapping(value="/ville", method=RequestMethod.POST)
	public String post(){
		return "plopost";
	}
}
