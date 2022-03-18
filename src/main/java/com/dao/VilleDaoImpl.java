package com.dao;

import com.beans.Ville;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VilleDaoImpl implements VilleDao {

    private final DaoFactory daoFactory;

    public VilleDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void addVille(Ville ville) {
        Connection connexion;
        PreparedStatement preparedStatement;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO ville_france VALUE(?,?,?,?,?,?,?);");
            preparedStatement.setString(1, String.valueOf(ville.getCodeCommuneInsee()));
            preparedStatement.setString(2, ville.getNomCommune());
            preparedStatement.setString(3, String.valueOf(ville.getCodePostal()));
            preparedStatement.setString(4, String.valueOf(ville.getLibelleAcheminement()));
            preparedStatement.setString(5, ville.getLigne5());
            preparedStatement.setString(6, String.valueOf(ville.getLatitude()));
            preparedStatement.setString(7, String.valueOf(ville.getLongitude()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ville> listVilles() {
        List<Ville> villes = new ArrayList<>();
        Connection connexion;
        Statement statement;
        ResultSet resultat;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM ville_france;");

            while (resultat.next()) {
                int codeCommuneInsee = Integer.parseInt(resultat.getString("Code_commune_INSEE"));
                String nomCommune = resultat.getString("Nom_commune");
                int codePostal = Integer.parseInt(resultat.getString("Code_postal"));
                String libelleAcheminement = resultat.getString("Libelle_acheminement");
                String ligne5 = resultat.getString("Ligne_5");
                float latitude = Float.parseFloat(resultat.getString("Latitude"));
                float longitude = Float.parseFloat(resultat.getString("Longitude"));

                Ville ville = new Ville(codeCommuneInsee,nomCommune,codePostal,libelleAcheminement,ligne5,latitude,longitude);

                villes.add(ville);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return villes;
    }

    @Override
    public List<Ville> listVillesByCodePostal(String codePostal) {
        List<Ville> villes = new ArrayList<>();
        Connection connexion;
        Statement statement;
        ResultSet resultat;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM ville_france WHERE Code_postal="+codePostal+";");

            while (resultat.next()) {
                int codeCommuneInsee = Integer.parseInt(resultat.getString("Code_commune_INSEE"));
                String nomCommune = resultat.getString("Nom_commune");
                String libelleAcheminement = resultat.getString("Libelle_acheminement");
                String ligne5 = resultat.getString("Ligne_5");
                float latitude = Float.parseFloat(resultat.getString("Latitude"));
                float longitude = Float.parseFloat(resultat.getString("Longitude"));

                Ville ville = new Ville(codeCommuneInsee,nomCommune,Integer.parseInt(codePostal),libelleAcheminement,ligne5,latitude,longitude);

                villes.add(ville);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return villes;
    }
}
