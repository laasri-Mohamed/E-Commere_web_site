/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Admin;
import entities.Categorie;
import entities.Client;
import entities.Marque;
import entities.Produit;
import service.AdminService;
import service.CategorieService;
import service.ClientService;
import service.MarqueService;
import service.PassService;
import service.ProduitService;
import service.UserService;
import util.HibernateUtil;

/**
 *
 * @author MOHAMED
 */
public class Test {
    public static void main(String[] args) {
         HibernateUtil.getSessionFactory().openSession();
//        MarqueService ms = new MarqueService();
//        //CategorieService cs = new CategorieService();
//        ProduitService ps = new ProduitService();
//        //ProduitService ps = new ProduitService();
//        //cs.create(new Categorie("aiazhz"));
//        //ms.create(new Marque("frfj"));
//        //ps.create(new Produit("yugyj", "yuyuyu", 130, "image.jpg", 2, "hoi", ms.findById(1), cs.findById(1)));
//              //  ps.create(new Produit("Table", "fsdfsd", 12, "tableee", 1221, "sjcbsjkbccjqcjkcbjkcs", null, null));
//
//        for(Marque p : ms.findAll()){
//            System.out.println(p);
//        
        //MarqueService ms = new MarqueService();
        //ms.create(new Marque("Test"));
        //ms.create(new Marque("test"));
        //ms.create(new Marque("Re"));
         
         UserService as = new UserService();
         as.create(new Admin("Ouchlif", "Nabil", "nabilouchlif@gmail.com", PassService.Encrypt("admin")));
         System.out.println(as.findRoleByEmail("laasrimohamed@gmail.com"));
          as.create(new Client("test", "test", "test", "test", "test@gmail.com", PassService.Encrypt("test")));
          System.out.println(as.findByEmail("test@gmail.com"));
            ClientService cs = new ClientService();
            System.out.println(cs.findByEmail("hihipa6252@covbase.com"));
    }
}
