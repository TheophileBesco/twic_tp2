package com.forms;

import com.beans.Ville;
import com.dao.DaoFactory;
import com.dao.VilleDao;
import org.springframework.web.bind.annotation.RequestParam;

public class VilleEditer {
    private final VilleDao villeDao;

    public VilleEditer(){
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.villeDao = daoFactory.getVilleDao();
    }

    public void saveVille(Ville ville){
        this.villeDao.addVille(ville);
    }

    public void editVille(Ville ville){
        this.villeDao.alterVille(ville);
    }

    public void deleteVille(String codeCommuneInsee){
        this.villeDao.deleteVille(codeCommuneInsee);
    }
}