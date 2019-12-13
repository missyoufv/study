package com.distributedLock;

/**
 * @author: duw
 * @Date: 2019/12/12 17:05
 * @Description: 常量类
 */
public class LockConstants {

    /**
     *  not exist
     */
    public static final String NO_EXIST = "NX";

    /**
     * exist
     */
    public static final String EXIST = "XX";

    /**
     * time unit, sencode
     */
    public static final String SECONDS = "EX";

    /**
     * time unit ,milliseconds
     */
    public static final String MILLISECONDS = "PX";


    public static final String OK = "OK";

    /**
     * private class,dont allow create class object
     */
    private LockConstants(){}
}


