/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import java.util.Scanner;

/**
 *
 * @author HieuNTSE
 */
public class checkdate {

    public static boolean checkDay(String date) {
        String s[] = date.split("-");
        if (s.length != 3) {
            return false;
        }
        Scanner sc = new Scanner(System.in);
        int day = 0;
        int month = 0;
        int year = 0;
        try {
            day = Integer.parseInt(s[0]);
            month = Integer.parseInt(s[1]);
            year = Integer.parseInt(s[2]);
        } catch (NumberFormatException e) {
            return false;
        }
        if (checkInvalidDate(day, month, year)) {
            return true;
        }
        return false;
    }

     public static boolean checkInvalidDate(int day, int month, int year) {
        int maxDay = 0;
        if (day < 1) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (year < 1997 || year > 21118) {
            return false;
        }
        if (month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12) {
            maxDay = 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDay = 30;
        }
        if (month == 2) {
            if (year % 400 == 0) {
                maxDay = 29;
            } else if (year % 4 == 0 && year % 100 != 0) {
                maxDay = 29;
            } else {
                maxDay = 28;
            }
        }
        if (day <= maxDay) {
            return true;
        }
        return false;
    }
    public String swtichdate(String date) {
        String s[] = date.split("-");
        int day = 0;
        int month = 0;
        int year = 0;
        day = Integer.parseInt(s[0]);
        month = Integer.parseInt(s[1]);
        year = Integer.parseInt(s[2]);
        String yearMonthDay = s[2] + "-" + s[1] + "-" +s[0];
        
        return yearMonthDay;

    }
    public boolean checkForm(String date){
        String patern = "\\d{1,2}-\\d{1,2}-\\d{4}";
         if (date.matches(patern)) {
            return true;
        }
        return false;        
    }
    public boolean checkToFrom(String fromdate, String todate){
        String s1[] = fromdate.split("-");
        String s2[] = todate.split("-");
        int day1 = Integer.parseInt(s1[0]);
        int month1 = Integer.parseInt(s1[1]);
        int year1 = Integer.parseInt(s1[2]);
         int day2 = Integer.parseInt(s2[0]);
        int month2 = Integer.parseInt(s2[1]);
        int year2 = Integer.parseInt(s2[2]);
        if(year2 > year1){
            return true;
        }
        if (year2 == year1) {
            if (month2 > month1) {
                return true;
            }
        }
        if (year2 == year1) {
            if (month2 == month1) {
                if (day2 > day1) {
                    return true;
                }
            }
        }
        return false;
    }
}
