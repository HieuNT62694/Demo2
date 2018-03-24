/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import importerr.importErr;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tbl_importdao.tbl_importDAO;
import tbl_productdao.tbl_productDAO;

/**
 *
 * @author HieuNTSE
 */
@WebServlet(name = "ImportServlet", urlPatterns = {"/ImportServlet"})
public class ImportServlet extends HttpServlet {

    private final String updateerrPage = "SearchoutstockServlet";

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
        PrintWriter out = response.getWriter();
        String url = updateerrPage;
        boolean flag = false;
        importErr err = new importErr();
        try {
            String quantity = request.getParameter("txtQuantity");
            String price = request.getParameter("txtPrice");
            String productid = request.getParameter("txtProductid");
            String id = request.getParameter("txtId");

            int idvalue = Integer.parseInt(id);
            int quantityvalue = 0;
            float pricevalue = 0;
            try {
                quantityvalue = Integer.parseInt(quantity);
            } catch (NumberFormatException ex) {
                flag = true;
                err.setQuantityint("Please input quantity interger");
            }
            try {
                pricevalue = Float.parseFloat(price);
            } catch (NumberFormatException ex) {
                flag = true;
                err.setPricefloat("Please input price float");
            }
            if (quantityvalue < 0) {
                flag = true;
                err.setQuantitybigthan0("Please input quantity > 0");
            }
            if (pricevalue < 0) {
                flag = true;
                err.setPricebigthan0("Please input price > 0");
            }
            if (flag) {
                request.setAttribute("IMPORTERR", err);
            } else {
                String manufactureDate = request.getParameter("txtmanufactureDate");
                String expiredDate = request.getParameter("txtexpiredDate");
                tbl_productDAO dao1 = new tbl_productDAO();
                tbl_importDAO dao2 = new tbl_importDAO();
                boolean result1;
                boolean result2;
                if (manufactureDate.trim().length() == 0 && expiredDate.trim().length() == 0) {
                    result1 = dao1.updateProim(productid, quantityvalue);
                    result2 = dao2.updateIm2(quantityvalue, pricevalue, productid);
                } else {
                    Date manufactureDatevalue = Date.valueOf(manufactureDate);
                    Date expiredDatevalue = Date.valueOf(expiredDate);
                    result1 = dao1.updateProim(productid, quantityvalue);
                    result2 = dao2.updateIm(quantityvalue, pricevalue, productid, manufactureDatevalue, expiredDatevalue);
                }

                if (result1) {
                    if (result2) {
                        url = "SearchoutstockServlet";
                    }
                }
            }

        } catch (NamingException ex) {
            log("UpdateServlet NamingException :" + ex.getMessage());
        } catch (SQLException ex) {
            log("UpdateServlet NamingException :" + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
