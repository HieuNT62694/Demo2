/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_productdao;

import java.io.Serializable;

/**
 *
 * @author HieuNTSE
 */
public class Tbl_producid implements Serializable {

    private String productid;
    private int quantity;

    public Tbl_producid() {
    }

    public Tbl_producid(String productid, int quantity) {
        this.productid = productid;
        this.quantity = quantity;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
