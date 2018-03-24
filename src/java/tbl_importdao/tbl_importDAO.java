/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_importdao;

import dbconnect.DBConnect;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import tbl_productdao.tbl_productDTO;

/**
 *
 * @author HieuNTSE
 */
public class tbl_importDAO implements Serializable {

    public boolean deleteim(int id) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                String sql = "Delete From tbl_import Where id = ?";
                stm = con.prepareCall(sql);
                stm.setInt(1, id);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (stm != null) {
                stm.close();
            }
        }

        return false;
    }

    private List<tbl_productDTO> listsearchproducts;

    public List<tbl_productDTO> getListsearchproducts() {
        return listsearchproducts;
    }

    public void searchDate(Date fromdate, Date todate) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                String sql = "SELECT pr.productName,im.quantity,im.expiredDate,im.id,pr.productID FROM tbl_import im,tbl_product pr where pr.productID = im.productid And im.expiredDate BETWEEN  ? And ? ";
                stm = con.prepareStatement(sql);
                stm.setDate(1, fromdate);
                stm.setDate(2, todate);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String productName = rs.getString("productName");
                    int quantity = rs.getInt("quantity");
                    Date expiredDate = rs.getDate("expiredDate");
                    String productID = rs.getString("productID");
                    tbl_productDTO dto = new tbl_productDTO(productName, quantity, expiredDate, productID, id);
                    if (listsearchproducts == null) {
                        listsearchproducts = new ArrayList<>();
                    }
                    listsearchproducts.add(dto);
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

    }

    public boolean updateIm(int quantity, float price, String productid,Date manufactureDate,Date expiredDate) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                String sql = "Insert into tbl_import (quantity, price, importedDate, productid,manufactureDate,expiredDate) Values(?, ?, GETDATE(), ?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setFloat(2, price);
                stm.setString(3, productid);
                stm.setDate(4, manufactureDate);
                stm.setDate(5, expiredDate);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (stm != null) {
                stm.close();
            }
        }

        return false;
    }
     public boolean updateIm2(int quantity, float price, String productid) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                String sql = "Insert into tbl_import (quantity, price, importedDate, productid,manufactureDate,expiredDate) Values(?, ?, GETDATE(), ?,null,null)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setFloat(2, price);
                stm.setString(3, productid);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (stm != null) {
                stm.close();
            }
        }

        return false;
    }
}
