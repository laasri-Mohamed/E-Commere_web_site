/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 *
 * @author MOHAMED
 */
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedNativeQueries({
    @NamedNativeQuery(name = "findProfils", query = "select distinct(DType) from User"),
    @NamedNativeQuery(name = "findRoleByEmail", query = "select DType from User u where u.email like :email"),
    @NamedNativeQuery(name = "findByPassword", query = "select u from User u where u.password like :password")
})

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom, prenom, tele, adresse;
    private String email, password , code;
    private int etat;

    public User() {
    }
    
    
    
    public User(int id, String nom, String prenom, String email, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }
    
    public User(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public User(String nom, String prenom, String tele, String adresse, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.tele = tele;
        this.adresse = adresse;
        this.email = email;
        this.password = password;
    }

    public User(int id, String nom, String prenom, String tele, String adresse, String email, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tele = tele;
        this.adresse = adresse;
        this.email = email;
        this.password = password;
    }

   
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.nom; //To change body of generated methods, choose Tools | Templates.
    }

    
}
