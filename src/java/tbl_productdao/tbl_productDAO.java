/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_productdao;

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
import tbl_importdao.tbl_importDTO;

/**
 *
 * @author HieuNTSE
 */
public class tbl_productDAO implements Serializable {

    List<tbl_importDTO> listsearchoutstock;

    public List<tbl_importDTO> getListsearchoutstock() {
        return listsearchoutstock;
    }

    public void searchoutstock() throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                String sql = "SELECT DISTINCT pr.productID,pr.productName,pr.quantity,pr.price,im.manufactureDate,im.expiredDate,im.id FROM tbl_product pr LEFT JOIN tbl_import im ON pr.productID = im.productid WHERE pr.quantity = 0";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productName = rs.getString("productName");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getFloat("price");
                    Date expiredDate = rs.getDate("expiredDate");
                    Date manufactureDate = rs.getDate("manufactureDate");
                    String productid = rs.getString("productID");
                    int id = rs.getInt("id");
                    tbl_importDTO dto = new tbl_importDTO(productName, quantity, price, manufactureDate, expiredDate, productid, id);

                    if (listsearchoutstock == null) {
                        listsearchoutstock = new ArrayList<>();
                    }
                        listsearchoutstock.add(dto);

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

    public boolean updatePro(String productid, int quantity) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                String sql = "Update tbl_product set quantity = quantity - ? Where productID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setString(2, productid);
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

    Tbl_producid dto = null;

    public Tbl_producid getproqua(int id)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                String sql = "Select productid,quantity From tbl_import where id = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productid = rs.getString("productid");
                    int quantity = rs.getInt("quantity");
                    dto = new Tbl_producid(productid, quantity);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return dto;
    }

    public boolean updateProim(String productid, int quantity) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                String sql = "Update tbl_product set quantity = quantity + ? Where productID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setString(2, productid);
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
