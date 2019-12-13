package com.serialize;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.*;

/**
 * @author: duw
 * @Date: 2019/11/1 16:44
 * @Description: json 序列化框架 jackson
 */
public class JacksonDemo {

    public static void main(String[] args) throws Exception{
//        new JacksonDemo().writeValAsStr();
//        new JacksonDemo().fastJsonWriteValAsStr();
//        new JacksonDemo().parseWriteValAsStr();
        new JacksonDemo().ignoreWriteValAsStr();

        String picUrl = "http://osstest.launcher.tcloudfamily.com/templates/962153e0a9b546369e61141e8ba8040e.jpg?md5=3356a8cb5168a272abde5a649ef9374c";
        if(picUrl.contains("md5")){
            String md5 = picUrl.substring(picUrl.indexOf("md5")+4);
            System.out.println(md5);
        }
        System.out.println(picUrl);
        String name = "【主】甄嬛传";
        if(name.contains("【主】")){
            System.out.println("包含");
        }

        String newTitle = name.substring(name.indexOf("【主】")+3);
        System.out.println(newTitle);
    }

    public void writeValAsStr() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        // 序列化所有的字段
//        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        // 序列化日期指定格式
//        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        // 取消默认转换成Timestamp 的形式
        //忽略空bean转化json的错误
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH,1);
        Date birthDay = calendar.getTime();
        Student s = new Student(1, 24, "张三", birthDay);
        Map<String,String> s_info = new HashMap<>();
        s_info.put("address","china");
        s_info.put("phoneNum","15767541175");
        s.setInfo(s_info);
        Student s1 = new Student(1, 24, "张三", birthDay);
        List list = new ArrayList<>(2);
        list.add(s);
        list.add(s1);
        String jsonStr = mapper.writeValueAsString(list);
        System.out.println(jsonStr);
    }

    public void fastJsonWriteValAsStr() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Student s = new Student(1, 24, "张三", null);
        String jsonStr = new JSONObject().toJSONString(s);
        Student s1 = new Student(12, 44, "张", new Date());
        String s1_jsonStr = mapper.writeValueAsString(s1);
        System.out.println(s1_jsonStr);
       String s2 =  "{\"id\":12,\"age\":44,\"name\":\"张\",\"birthDay\":1572856975530,\"info\":null,\"son\":\"{\"age\":24,\"id\":1,\"name\":\"张三\"}\"}";
       Student newStu = mapper.readValue(s2,Student.class);
        System.out.println(newStu.getSon());
    }

    public void parseWriteValAsStr() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Student s = new Student(1, 24, "张三", null);
        Student s1 = new Student(12, 44, "张", new Date());
        String s1_str = mapper.writeValueAsString(s1);
        s.setSon(s1_str);
        String s_str = mapper.writeValueAsString(s);
        Student s2 = new Student(3, 34, "李四", new Date());
        s.setS(s2);
        String s2_str = mapper.writeValueAsString(s);
        System.out.println(s2_str);


    }

    public void ignoreWriteValAsStr()throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Student s = new Student(12, 44, "张", new Date());
        s.setSon("abc");
        String s_str = mapper.writeValueAsString(s);
        System.out.println(s_str);

    }

    @Data
    class Student {
        private int id;
        private int age;
        private String name;
        private Date birthDay;
        @JsonIgnore
        private Map<String,String> info;
        @JsonIgnore
        String son;
        @JsonIgnore
        Student s;
        public Student(int id, int age, String name, Date birthDay) {
            this.id = id;
            this.age = age;
            this.name = name;
            this.birthDay = birthDay;
        }
    }
}

