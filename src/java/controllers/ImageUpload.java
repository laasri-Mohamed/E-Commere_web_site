/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.Produit;
import java.io.PrintWriter;
import javax.servlet.annotation.MultipartConfig;
import service.ProduitService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.CategorieService;
import service.MarqueService;

/**
 *
 * @author Mohamed Nabil
 */
@WebServlet(name = "ImageUpload", urlPatterns = {"/ImageUpload"})
public class ImageUpload extends HttpServlet {

    String nom, designation, description, id1, id2;
    double prix;
    int unite;
    String path;
    private String UPLOAD_DIRECTORY = "/web/ressource/image/";
    ProduitService ps = new ProduitService();
    MarqueService ms = new MarqueService();
    CategorieService cs = new CategorieService();
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
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Servlet FileUpload at " + request.getContextPath() + "</h1>");
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
        UPLOAD_DIRECTORY = getServletContext().getRealPath("/").replace("build\\", "") + "/ressource" + File.separator + "images";
        //process only if its multipart 
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                String name = null;
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        name = new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
                        path = UPLOAD_DIRECTORY + File.separator + name;
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

                
                ps.create(new Produit(nom, designation, prix, name, unite, description, ms.findByNom(id1), cs.findByNom(id2)));

                request.setAttribute("message", "File Uploaded Successfully le nom est :" + nom + " et le prix est :" + prix);
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }
        } else {
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
        }

        request.getRequestDispatcher("/res.jsp").forward(request, response);
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
