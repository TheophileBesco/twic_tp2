package com.forms;

import com.beans.Ville;
import com.dao.DaoFactory;
import com.dao.VilleDao;

import java.util.List;

public class VilleFinder {
    private final VilleDao villeDao;

    public VilleFinder(){
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.villeDao = daoFactory.getVilleDao();
    }

    public List<Ville> listVilles(){
        return this.villeDao.listVilles();
    }
    public List<Ville> findVilleByCodePostal(String codePostal){
        return this.villeDao.listVillesByCodePostal(codePostal);
    }
    public Ville findVilleByCodeCommune(String codeCommuneInsee){
        return this.villeDao.findVilleByCodeCommune(codeCommuneInsee);
    }
}