package com.foshanshop.utils;

public class Tool {
    /**
     * ½«String×ªÎªint
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
