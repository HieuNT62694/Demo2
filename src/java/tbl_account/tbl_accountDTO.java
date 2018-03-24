/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_account;

import java.io.Serializable;

/**
 *
 * @author HieuNTSE
 */
public class tbl_accountDTO implements Serializable{
    private String accountID;
    private String employeeName;
    private String password;
    private boolean role;

    public tbl_accountDTO(String accountID, String employeeName, String password, boolean role) {
        this.accountID = accountID;
        this.employeeName = employeeName;
        this.password = password;
        this.role = role;
    }

    public tbl_accountDTO() {
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
    
}
