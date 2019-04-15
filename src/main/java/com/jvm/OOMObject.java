package com.jvm;

import java.util.ArrayList;
import java.util.List;

public class OOMObject {

    public byte [] placeholder = new byte [64 *1024];

    public static void fillHead(int num)throws Exception{
        List<OOMObject> list = new ArrayList<OOMObject>();
        for(int i =0 ;i < num;i++)
        {
            //稍作延迟，零监视曲线更加的明显
            Thread.sleep(100);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception{
        fillHead(1000);
    }
}
