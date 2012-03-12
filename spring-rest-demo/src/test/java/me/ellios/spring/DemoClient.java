package me.ellios.spring;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ellios
 * Date: 12-3-5
 */
public class DemoClient {

    public static RestTemplate restTemplate = new RestTemplate();
    
    public static void main(String... args){
        System.out.println("get : " + get());
        System.out.println("inc : " + inc());
        System.out.println("get : " + get());
        delete();
        System.out.println("get : " + get());
        delete();
    }
    
    public static String get(){
        Map<String, String> params = new HashMap<String, String>();
        params.put("app", "pp");
        params.put("id", "123");
        String result = restTemplate.getForObject("http://127.0.0.1:8102/api/{app}/{id}/", String.class, params);
        return result;
    }

    public static String inc(){
        Map<String, String> params = new HashMap<String, String>();
        params.put("app", "pp");
        params.put("id", "123");
        String result = restTemplate.postForObject("http://127.0.0.1:8102/api/{app}/{id}/", null, String.class, params);
        return result;
    }

    public static void delete(){
        Map<String, String> params = new HashMap<String, String>();
        params.put("app", "pp");
        params.put("id", "123");
        restTemplate.delete("http://127.0.0.1:8102/api/{app}/{id}/", params);
    }
}
