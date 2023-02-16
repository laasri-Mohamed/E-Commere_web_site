/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lachgar
 */
@Entity
@Table(name = "client")
public class Client extends User {

    @OneToMany
    private List<Commande> commande;

//Source : www.exelib.net
    public Client() {
    }

    public Client(String nom, String prenom, String tele, String adresse, String email, String password) {
        super(nom, prenom, tele, adresse, email, password);
    }

    public Client(List<Commande> commande, String nom, String prenom, String tele, String adresse, String email, String password) {
        super(nom, prenom, tele, adresse, email, password);
        this.commande = commande;
    }

    public Client(List<Commande> commande, int id, String nom, String prenom, String tele, String adresse, String email, String password) {
        super(id, nom, prenom, tele, adresse, email, password);
        this.commande = commande;
    }

    public List<Commande> getCommande() {
        return commande;
    }

    public void setCommande(List<Commande> commande) {
        this.commande = commande;
    }

}
