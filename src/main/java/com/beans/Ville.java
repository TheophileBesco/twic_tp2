package com.beans;

public class Ville {
    private int codeCommuneInsee;
    private String nomCommune;
    private int codePostal;
    private String libelleAcheminement;
    private String ligne5;
    private float latitude;
    private float longitude;

    public Ville(int codeCommuneInsee, String nomCommune, int codePostal, String libelleAcheminement, String ligne5, float latitude, float longitude) {
        this.codeCommuneInsee = codeCommuneInsee;
        this.nomCommune = nomCommune;
        this.codePostal = codePostal;
        this.libelleAcheminement = libelleAcheminement;
        this.ligne5 = ligne5;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getCodeCommuneInsee() {
        return codeCommuneInsee;
    }

    public void setCodeCommuneInsee(int codeCommuneInsee) {
        this.codeCommuneInsee = codeCommuneInsee;
    }

    public String getNomCommune() {
        return nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getLibelleAcheminement() {
        return libelleAcheminement;
    }

    public void setLibelleAcheminement(String libelleAcheminement) {
        this.libelleAcheminement = libelleAcheminement;
    }

    public String getLigne5() {
        return ligne5;
    }

    public void setLigne5(String ligne5) {
        this.ligne5 = ligne5;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
