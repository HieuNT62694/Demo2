/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_account;

import dbconnect.DBConnect;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author HieuNTSE
 */
public class tbl_accountDAO implements Serializable {
    
//    public boolean checkLogin(String username, String password) throws SQLException, NamingException {
//        Connection con = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        try {
//            con = DBConnect.makeConnection();
//            if (con != null) {
//                String sql = "Select * from tbl_account Where employeeName = ? And password = ? And isAdmin = 1";
//                stm = con.prepareStatement(sql);
//                stm.setString(1, username);
//                stm.setString(2, password);
//                rs = stm.executeQuery();
//                if (rs.next()) {
//                    return true;
//                }
//                
//                
//            }
//        } finally {
//            if (con != null) {
//                con.close();
//            }
//            if (stm != null) {
//                stm.close();
//            }
//            if (rs != null) {
//                rs.close();
//            }
//        }
//        
//        return false;
//    }
    
    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;
    private tbl_accountDTO dto = null;

    public tbl_accountDTO checkLogin(String user, String pass)
            throws SQLException, NamingException {
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                String sql = "Select * from tbl_account Where accountID = ? And password = ? And isAdmin = 1";
                stm = con.prepareStatement(sql);
                stm.setString(1, user);
                stm.setString(2, pass);
                rs = stm.executeQuery();
                if (rs.next()) {
                   String accountID = rs.getString("accountID");
                   String employeeName = rs.getString("employeeName");
                   String password = rs.getString("password");
                   boolean role = rs.getBoolean("isAdmin");
                   dto = new tbl_accountDTO(accountID, employeeName, password, role);
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
}
