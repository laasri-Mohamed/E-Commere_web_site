/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Admin;
import entities.Client;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.NamedNativeQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.AdminService;
import service.ClientService;
import service.PassService;
import service.UserService;

/**
 *
 * @author MOHAMED
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    UserService us = new UserService();
    ClientService cs = new ClientService();
    AdminService as = new AdminService();
    private static final String ALGORITHM = "md5";
    private static final String DIGEST_STRING = "HG58YZ3CR9";
    private static final String CHARSET_UTF_8 = "utf-8";
    private static final String SECRET_KEY_ALGORITHM = "DESede";
    private static final String TRANSFORMATION_PADDING = "DESede/CBC/PKCS5Padding";

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
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * //Source : www.exelib.net }
     *
     * //
     * <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     * /**
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
        response.setContentType("text/html;charset=UTF-8");
        User u = null;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        u = us.findByEmail(email);
        String role = us.findRoleByEmail(email);
        String pass = u.getPassword();

        if (role != null) {
            if (role.equals("Client")) {
                if (pass.equals(PassService.Encrypt(password))) {
                    HttpSession session = request.getSession();
                    session.setAttribute("email", u);
                    u.setEtat(1);
                    us.update(u);
                    request.getRequestDispatcher("index1.jsp").include(request, response);
                } else {
                    response.sendRedirect("login.jsp?msg=mot de passe incorrect");
                }
            }
            if (role.equals("Admin")) {
                if (pass.equals(PassService.Encrypt(password))) {
                    HttpSession session = request.getSession();
                    session.setAttribute("email", u);
                    u.setEtat(1);
                    us.update(u);
                    request.getRequestDispatcher("admin.jsp").include(request, response);
                } else {
                    response.sendRedirect("login.jsp?msg=mot de passe incorrect");
                }
            }
        }
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
