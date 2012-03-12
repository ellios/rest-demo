package me.ellios.spring.controller;

import me.ellios.core.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ellios
 * Date: 12-3-5
 */
@Controller
public class DemoController {

    @Autowired
    private CountService countService;


    @RequestMapping( value = "/{app}/{id}/",method = RequestMethod.GET)
    @ResponseBody
    public Map get(@PathVariable( "app" ) final String app,
                   @PathVariable( "id" ) final String id){
        return countService.get(app, id);
    }

    @RequestMapping( value = "/{app}/{id}/",method = RequestMethod.POST )
    @ResponseBody
    public Map inc(@PathVariable( "app" ) final String app,
                   @PathVariable( "id" ) final String id){
        return countService.inc(app, id, 1);
    }

    @RequestMapping( value = "/{app}/{id}/",method = RequestMethod.DELETE )
    @ResponseBody
    public boolean delete(@PathVariable( "app" ) final String app,
                   @PathVariable( "id" ) final String id){
        Long count = countService.delete(app, id);
        if(count == null)
            return false;
        return true;
    }
}
