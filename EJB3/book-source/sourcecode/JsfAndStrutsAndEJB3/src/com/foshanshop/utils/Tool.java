package com.foshanshop.utils;

public class Tool {
    /**
     * ��StringתΪint
     * @param number
     * @return
     */
    public static int parseInt(String number){
        try {
        	return Integer.parseInt(number);
        } catch (Exception e) {}
        return 0;
    }
}
