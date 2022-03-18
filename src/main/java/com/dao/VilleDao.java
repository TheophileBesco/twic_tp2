package com.dao;

import com.beans.Ville;

import java.util.List;

public interface VilleDao {
    void addVille(Ville ville);
    List<Ville> listVilles();
    List<Ville> listVillesByCodePostal(String codePostal);
}
