/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MOHAMED
 */
@Entity
@Table(name = "facture")
public class Facture {

    @Id
    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private double montant;
    @OneToMany
    private List<Commande> commande;

    public Facture() {
    }

    public Facture(Date date, double montant, Commande commande) {
        this.date = date;
        this.montant = montant;
        this.commande = (List<Commande>) commande;
    }

    public Facture(int id, Date date, double montant, Commande commande) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.commande = (List<Commande>) commande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Commande getCommande() {
        return (Commande) commande;
    }

    public void setCommande(Commande commande) {
        this.commande = (List<Commande>) commande;
    }

}
