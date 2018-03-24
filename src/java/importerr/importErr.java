/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importerr;

import java.io.Serializable;

/**
 *
 * @author HieuNTSE
 */
public class importErr implements Serializable {

    private String quantityint;
    private String quantitybigthan0;
    private String pricefloat;
    private String pricebigthan0;

    public importErr() {
    }

    public String getQuantityint() {
        return quantityint;
    }

    public void setQuantityint(String quantityint) {
        this.quantityint = quantityint;
    }

    public String getQuantitybigthan0() {
        return quantitybigthan0;
    }

    public void setQuantitybigthan0(String quantitybigthan0) {
        this.quantitybigthan0 = quantitybigthan0;
    }

    public String getPricefloat() {
        return pricefloat;
    }

    public void setPricefloat(String pricefloat) {
        this.pricefloat = pricefloat;
    }

    public String getPricebigthan0() {
        return pricebigthan0;
    }

    public void setPricebigthan0(String pricebigthan0) {
        this.pricebigthan0 = pricebigthan0;
    }

}
