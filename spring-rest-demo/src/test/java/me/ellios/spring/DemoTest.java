package me.ellios.spring;

import me.ellios.DemoConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ellios
 * Date: 12-3-5
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { DemoConfig.class},loader = AnnotationConfigContextLoader.class )
public final class DemoTest{

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testDemoClient(){
        Map<String, String> params = new HashMap<String, String>();
        params.put("app", "pp");
        params.put("id", "123");
        String url = "http://127.0.0.1:8102/api/{app}/{id}/";
        Assert.assertEquals(restTemplate.getForObject(url, String.class, params), "0");
        Assert.assertEquals(restTemplate.postForObject(url, null, String.class, params), "1");
        restTemplate.delete(url, params);
    }

}
