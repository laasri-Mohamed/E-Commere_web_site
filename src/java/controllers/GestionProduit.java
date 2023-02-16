/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Produit;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.persistence.Transient;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import service.CategorieService;
import service.MarqueService;
import service.ProduitService;

/**
 *
 * @author MOHAMED
 */
@MultipartConfig(maxFileSize = 169999999)
@WebServlet(name = "GestionProduit", urlPatterns = {"/GestionProduit"})
public class GestionProduit extends HttpServlet {

    ProduitService ps = new ProduitService();
    MarqueService ms = new MarqueService();
    CategorieService cs = new CategorieService();

    String nom, description, designation, id1, id2;
    double prix;
    int unite;
    private String path;
    private String UPLOAD_DIRECTORY = "/web/ressource/image/";

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
        response.sendRedirect("listeProduits.jsp");

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
    @Transient

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        UPLOAD_DIRECTORY = getServletContext().getRealPath("/").replace("build\\", "") + "/ressource" + File.separator + "images";
        if (ServletFileUpload.isMultipartContent(request)) {
                try {
                    List<FileItem> multiparts = new org.apache.commons.fileupload.servlet.ServletFileUpload(
                            new DiskFileItemFactory()).parseRequest(request);
                    String image = null;
                    for (FileItem item : multiparts) {
                        if (!item.isFormField()) {
                            image = new File(item.getName()).getName();
                            item.write(new File(UPLOAD_DIRECTORY + File.separator + image));
                            path = UPLOAD_DIRECTORY + File.separator + image;
                        } else {
                            InputStream input = item.getInputStream();
                            if (item.getFieldName().equals("nom")) {
                                byte[] str = new byte[input.available()];
                                input.read(str);
                                nom = new String(str, "UTF8");
                            }
                            if (item.getFieldName().equals("prix")) {
                                byte[] str = new byte[input.available()];
                                input.read(str);
                                prix = Double.parseDouble(new String(str, "UTF8"));
                            }
                            if (item.getFieldName().equals("designation")) {
                                byte[] str = new byte[input.available()];
                                input.read(str);
                                designation = new String(str, "UTF8");
                            }
                            if (item.getFieldName().equals("description")) {
                                byte[] str = new byte[input.available()];
                                input.read(str);
                                description = new String(str, "UTF8");
                            }
                            if (item.getFieldName().equals("unite")) {
                                byte[] str = new byte[input.available()];
                                input.read(str);
                                unite = Integer.parseInt(new String(str, "UTF8"));
                            }
                            if (item.getFieldName().equals("marque")) {
                                byte[] str = new byte[input.available()];
                                input.read(str);
                                id1 = new String(str, "UTF8");
                            }
                            if (item.getFieldName().equals("categorie")) {
                                byte[] str = new byte[input.available()];
                                input.read(str);
                                id2 = new String(str, "UTF8");
                            }
                        }
                    }
                    //File uploaded successfully

                    ps.create(new Produit(nom, designation, prix, image, unite, description, ms.findByNom(id1), cs.findByNom(id2)));
                } catch (Exception ex) {
                    request.setAttribute("message", "File Upload Failed due to " + ex);
                }
            }
//        File file = new File(request.getParameter("image"));
//        FileInputStream input = new FileInputStream(file);
//        byte[] bFile = new byte[(int) file.length()];
//        
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
