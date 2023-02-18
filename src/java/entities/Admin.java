/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 *
 * @author MOHAMED
 */
@Entity
@Table(name = "admin")
@NamedNativeQuery(name = "findByEmailo", query = "select u from User u where u.email like :email")
public class Admin extends User {

    public Admin() {

    }

    public Admin(String nom, String prenom, String email, String password) {
        super(nom, prenom, email, password);
    }

    public Admin(String nom, String prenom, String tele, String adresse, String email, String password) {
        super(nom, prenom, tele, adresse, email, password);
    }

    public Admin(int id, String nom, String prenom, String email, String password) {
        super(id, nom, prenom, email, password);
    }

}
