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
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import service.ProduitService;

/**
 *
 * @author Mohamed Nabil
 */
@WebServlet(name = "AddProduit", urlPatterns = {"/AddProduit"})
public class AddProduit extends HttpServlet {

    String libelle;
    double prix;
    String path;
    private String UPLOAD_DIRECTORY;

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddProduit</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProduit at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        UPLOAD_DIRECTORY = getServletContext().getRealPath("/").replace("build\\", "") + "ressource" + File.separator + "images";
        //process only if its multipart content
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest((RequestContext) request);
                String img = null;
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        img = new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + img));
                        path = UPLOAD_DIRECTORY + File.separator + img;
                    } else {
                        InputStream input = item.getInputStream();
                        if (item.getFieldName().equals("designation")) {
                            byte[] str = new byte[input.available()];
                            input.read(str);
                            libelle = new String(str, "UTF8");
                        }
                        if (item.getFieldName().equals("prix")) {
                            byte[] str = new byte[input.available()];
                            input.read(str);
                            prix = Double.parseDouble(new String(str, "UTF8"));
                        }
                    }
                }
                //File uploaded successfully

                ProduitService produit = new ProduitService();
                produit.create(new Produit(libelle, prix, img));

                request.setAttribute("message", "File Uploaded Successfully le nom est :" + libelle + " le prenom est :" + prix);
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }
        } else {
            request.setAttribute("message", "Sorry this Servlet only handles file upload request");
        }
        response.sendRedirect("catalog.jsp");
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
