package com.laoli.service.impl;

import com.laoli.service.IpCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WeiHanQiang
 * @date 2024/09/28 22:46
 **/
@Service
public class IpCounterServiceImpl implements IpCounterService {
    @Autowired
    private HttpServletRequest request;

    private Map<String, Integer> map = new HashMap<>();

    @Override
    public void record() {
        String ip = request.getRemoteAddr();
        map.put(ip,map.getOrDefault(ip,0)+1);
        map.forEach((key,value)->{
            System.out.println("ip: " + key + " value: " + value);
        });
    }
}
