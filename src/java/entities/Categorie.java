/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author MOHAMED
 */
@Entity
@Table(name = "categorie")

@NamedQueries({
    
    @NamedQuery(name = "findByNomo" , query = "select c from Categorie c where c.nom like :cc")
})
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @OneToMany
    private List<Produit> produits;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "categorieMere", cascade = CascadeType.ALL)
    private Set<Categorie> categories;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Categorie categorieMere;

    public Categorie() {
    }

    public Categorie(String nom) {
        this.nom = nom;
    }

    public Categorie(int id, String nom) {
        this.id = id;
        this.nom = nom;
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
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.nom;
    }
    
}