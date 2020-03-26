package com.nmhung.utils;

import javax.servlet.http.HttpServletRequest;

public class FormUtil {
    public static int getInt(HttpServletRequest request, String key) {
        int rs = 0;
        try {
            String str = request.getParameter(key);
            rs = Integer.parseInt(str);
        }catch (Exception e) {
            // TODO: handle exception
        }
        return rs;
    }

    public static String getString(HttpServletRequest request,String key) {

        try {
            String str = request.getParameter(key);
            return str;
        }catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
}
