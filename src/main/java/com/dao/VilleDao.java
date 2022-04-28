package com.dao;

import com.beans.Ville;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface VilleDao {
    void addVille(Ville ville);
    void alterVille(Ville ville);
    void deleteVille(String codeCommuneInsee);
    Ville findVilleByCodeCommune(String codeCommuneInsee);
    List<Ville> listVilles();
    List<Ville> listVillesByCodePostal(String codePostal);
}
