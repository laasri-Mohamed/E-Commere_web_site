/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Panier;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LAASRI MOHAMED
 */
@WebServlet(name = "GererPanier", urlPatterns = {"/GererPanier"})
public class GererPanier extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()) {
            ArrayList<Panier> listePaniers = new ArrayList<>();
            int id = Integer.parseInt(request.getParameter("id"));
            Panier pn = new Panier();
            pn.setId(id);
            pn.setQte(1);
            
            HttpSession session = request.getSession();
            ArrayList<Panier> liste_paniers = (ArrayList<Panier>) session.getAttribute("liste-paniers");
            
            if(liste_paniers == null) {
                listePaniers.add(pn);
                session.setAttribute("liste-paniers", liste_paniers);
                out.println("session created and list added");
            } else {
                listePaniers = liste_paniers;
                boolean isExisting = false;
                for(Panier p : liste_paniers){
                    if(p.getId() == id) {
                        isExisting = true;
                        out.println("The product is in the cart!");
                    }
                    if(!isExisting) {
                        listePaniers.add(pn);
                        out.println("Producct added!");
                    }
                }
            }
            for (Panier p : liste_paniers) {
                out.println();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
