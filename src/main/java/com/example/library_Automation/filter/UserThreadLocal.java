package com.example.library_Automation.filter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserThreadLocal {
    private static final ThreadLocal<String> threadLocalValue = new ThreadLocal<>();

    public static String getUserData(){return threadLocalValue.get();}

    public static void setUserData(String libraryUser){threadLocalValue.set(libraryUser);}

    public  static void cleanUp(){threadLocalValue.remove();}
}
