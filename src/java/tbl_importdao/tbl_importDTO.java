/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_importdao;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author HieuNTSE
 */
public class tbl_importDTO implements Serializable {

    private String productName;
    private int quantity;
    private float price;
    private Date manufactureDate;
    private Date expiredDate;
    private String productID;
    private int id;

    public tbl_importDTO() {
    }

    public tbl_importDTO(String productName, int quantity, float price, Date manufactureDate, Date expiredDate, String productID, int id) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.expiredDate = expiredDate;
        this.productID = productID;
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

}
