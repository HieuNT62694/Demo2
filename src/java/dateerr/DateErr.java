/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateerr;

import java.io.Serializable;

/**
 *
 * @author HieuNTSE
 */
public class DateErr implements Serializable {

    private String fromdateInvalid;
    private String todateInvalid;
    private String todatefromdate;
    private String wrongformtodate;
    private String wrongformfromdate;

    public String getWrongformtodate() {
        return wrongformtodate;
    }

    public void setWrongformtodate(String wrongformtodate) {
        this.wrongformtodate = wrongformtodate;
    }

    public String getWrongformfromdate() {
        return wrongformfromdate;
    }

    public void setWrongformfromdate(String wrongformfromdate) {
        this.wrongformfromdate = wrongformfromdate;
    }

    public DateErr() {
    }



    public String getFromdateInvalid() {
        return fromdateInvalid;
    }

    public void setFromdateInvalid(String fromdateInvalid) {
        this.fromdateInvalid = fromdateInvalid;
    }

    public String getTodateInvalid() {
        return todateInvalid;
    }

    public void setTodateInvalid(String todateInvalid) {
        this.todateInvalid = todateInvalid;
    }

    public String getTodatefromdate() {
        return todatefromdate;
    }

    public void setTodatefromdate(String todatefromdate) {
        this.todatefromdate = todatefromdate;
    }

}
