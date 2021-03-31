package nuc.ss.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nuc.ss.pojo.User;
import nuc.ss.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller //直接走视图解析
@RestController  //直接返回字符串
public class UserController {
    @RequestMapping("/j1")
    //@ResponseBody//他就不会走视图解析器，会直接返回一个 字符串
    public String json1() throws JsonProcessingException {
        //jackson,ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User(1, "秦疆一号", 12);
        //System.out.println(user);

        String str = mapper.writeValueAsString(user);
        return str;
    }

    @RequestMapping("/j2")
    //@ResponseBody//他就不会走视图解析器，会直接返回一个 字符串
    public String json2() throws JsonProcessingException {

        User user1 = new User(1, "秦疆1号", 12);
        User user2 = new User(2, "秦疆2号", 12);
        User user3 = new User(3, "秦疆3号", 12);
        User user4 = new User(4, "秦疆4号", 12);
        User user5 = new User(5, "秦疆5号", 12);

        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        return JsonUtils.getJson(list);
    }

    @RequestMapping("/j3")
    //@ResponseBody//他就不会走视图解析器，会直接返回一个 字符串
    public String json3(){

        Date date = new Date();

        return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }



    @RequestMapping("/j4")
    //@ResponseBody//他就不会走视图解析器，会直接返回一个 字符串
    public String json4(){

        User user1 = new User(1, "秦疆1号", 12);
        User user2 = new User(2, "秦疆2号", 12);
        User user3 = new User(3, "秦疆3号", 12);
        User user4 = new User(4, "秦疆4号", 12);
        User user5 = new User(5, "秦疆5号", 12);

        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        return JSON.toJSONString(list);
    }
}
