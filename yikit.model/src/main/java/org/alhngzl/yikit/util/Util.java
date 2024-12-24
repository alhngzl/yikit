package org.alhngzl.yikit.util;

public class Util {
    private Util() {throw new IllegalStateException(Util.class.getName());}
    
    public static boolean isNull(Object item){
        return item == null;
    }
}
