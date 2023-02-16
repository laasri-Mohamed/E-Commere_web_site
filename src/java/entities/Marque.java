/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import service.MarqueService;

/**
 *
 * @author MOHAMED
 */
@Entity
@Table(name = "marque")
@NamedQueries({
    @NamedQuery(name = "findByNoms" , query = "select n from Marque n where n.nom like :nom")
})
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @OneToMany
    private List<Produit> produits;

    public Marque() {
    }

    public Marque(String nom) {
        setNom(nom);
        this.produits = produits;
    }

    public Marque(int id, String nom) {
        this.id = id;
        setNom(nom);
        this.produits = produits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        MarqueService ms = new MarqueService();
        if ((ms.findByNom(nom)) != null) {
            
                this.nom = null;
            }
        
        else {
                this.nom = nom;
                 }    
        }
        
    

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public String toString() {
        return this.nom;
    }
    

}