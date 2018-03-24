/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author HieuNTSE
 */
public class DBConnect implements Serializable {

    public static Connection makeConnection() throws NamingException, SQLException {
        Context ctx = new InitialContext();
        Context tomcatctx = (Context) ctx.lookup("java:comp/env");
        DataSource ds = (DataSource) tomcatctx.lookup("DBSource");
        Connection con = ds.getConnection();
        return con;
    }
}
