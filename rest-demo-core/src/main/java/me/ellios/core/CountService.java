package me.ellios.core;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.
 * User: ellios
 * Date: 12-3-5
 */

public class CountService {
    private static final ConcurrentHashMap<String, Long> counts = new ConcurrentHashMap<String, Long>();

    public Map<String, Long> get(String app, String id){
        String key = app + '_' + id;
        Map<String, Long> result = new HashMap<String, Long>();
        Long count = counts.get(key);
        if(count == null){
            count = 0L;
        }
        result.put("data", count);
        return result;
    }

    public Map<String, Long> inc(String app, String id, int step){
        String key = app + '_' + id;
        Long count = counts.get(key);
        if(count == null){
            count = 0L;
        }
        count = count + step;
        if(count < 0){
            count = 0L;
        }
        counts.put(key, count);
        Map<String, Long> result = new HashMap<String, Long>();
        result.put("count", counts.get(key));
        return result;
    }
    
    public Long delete(String app, String id){
        String key = app + '_' + id;

        Long count = null;
        try {
            count = counts.remove(key);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return count;
    }
    
}
