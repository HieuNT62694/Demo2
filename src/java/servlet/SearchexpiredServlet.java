/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dateerr.DateErr;
import function.checkdate;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tbl_productdao.tbl_productDTO;
import tbl_importdao.tbl_importDAO;

/**
 *
 * @author HieuNTSE
 */
@WebServlet(name = "SearchexpiredServlet", urlPatterns = {"/SearchexpiredServlet"})
public class SearchexpiredServlet extends HttpServlet {

    private final String searchPage = "search.jsp";
    private final String searchProductPage = "searchproduct.jsp";

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
        String url = searchPage;
        boolean flag = false;
        DateErr err = new DateErr();
        try {
            String fromdate = request.getParameter("txtFromdate");
            String todate = request.getParameter("txtTodate");
            checkdate check = new checkdate();

            if (!check.checkDay(fromdate)) {
                flag = true;
                err.setFromdateInvalid("From Date invalid Year > 1997 Anh Year < 2118!!");
            }
            if (!check.checkForm(fromdate)) {
                flag = true;
                err.setWrongformfromdate("Wrong Form from date. Please in put dd-mm-yyyy !!");
            }
            if (!check.checkDay(todate)) {
                flag = true;
                err.setTodateInvalid("To Date invalid Year > 1997 Anh Year < 2118!!");
            }
            if (!check.checkForm(todate)) {
                flag = true;
                err.setWrongformtodate("Wrong Form to date. Please in put dd-mm-yyyy !!");
            }

            if (flag) {
                request.setAttribute("SEARCHDAYERR", err);
            } else {
                if (!check.checkToFrom(fromdate, todate)) {
                    err.setTodatefromdate("To Date must bigger than From Date !!");
                    request.setAttribute("SEARCHDAYERR", err);
                } else {
                    Date fromValue = Date.valueOf(check.swtichdate(fromdate));
                    Date toValue = Date.valueOf(check.swtichdate(todate));
                    tbl_importDAO dao = new tbl_importDAO();
                    dao.searchDate(fromValue, toValue);
                    List<tbl_productDTO> result = dao.getListsearchproducts();
                    request.setAttribute("SEARCHPRODUCT", result);
                    url = searchPage;
                }
            }
        } catch (NamingException ex) {
            log("SearchexpiredServlet NamingException :" + ex.getMessage());
        } catch (SQLException ex) {
            log("SQLException NamingException :" + ex.getMessage());
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
