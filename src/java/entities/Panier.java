/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author LAASRI MOHAMED
 */
public class Panier extends Produit {
    private Produit produit;
    private int qte;

    public Panier() {
    }

    public Panier(Produit produit, int qte) {
        this.produit = produit;
        this.qte = qte;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}