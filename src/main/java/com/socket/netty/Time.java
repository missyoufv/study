package com.socket.netty;

import java.util.Date;

/**
 *
 */
public class Time {

    private  long value;

    public Time(){
        //除以1000，精确到秒
        this(System.currentTimeMillis()/1000L);
    }

    public Time(long value){
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return new Date((getValue()*1000L)).toString();
    }
}
