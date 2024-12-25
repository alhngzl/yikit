package org.alhngzl.yikit.util;

import com.google.gson.Gson;

public class Util {
    private Util() {throw new IllegalStateException(Util.class.getName());}
    
    public static boolean isNull(Object item){
        return item == null;
    }

    public static String objectToJson(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}
