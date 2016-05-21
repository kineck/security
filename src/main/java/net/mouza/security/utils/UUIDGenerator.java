package net.mouza.security.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.UUID;

public class UUIDGenerator {
    private static final Log logger = LogFactory.getLog(UUIDGenerator.class);
    private UUIDGenerator() {
    } 
    /** 
     * 获得一个UUID 
     * @return String UUID 
     */ 
    public static String getUUID(){
      return UUID.randomUUID().toString().replaceAll("-", "").trim();
    } 
    /** 
     * 获得指定数目的UUID 
     * @param number int 需要获得的UUID数量 
     * @return String[] UUID数UUID.randomUUID().toString()组
     */ 
    public static String[] getUUID(int number){ 
        if(number < 1){ 
            return null; 
        } 
        String[] ss = new String[number]; 
        for(int i=0;i<number;i++){ 
            ss[i] = getUUID(); 
        } 
        return ss; 
    } 
    public static void main(String[] args){ 
        String[] ss = getUUID(10);
        for (String s : ss) {
            System.out.println(s);
        }
    } 
}   