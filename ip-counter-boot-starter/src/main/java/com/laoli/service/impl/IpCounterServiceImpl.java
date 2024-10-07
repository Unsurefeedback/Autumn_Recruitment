package com.laoli.service.impl;

import com.laoli.properties.IpCounterProperties;
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
    @Autowired
    private IpCounterProperties properties;

    private Map<String, Integer> map = new HashMap<>();


    @Override
    public void record() {
        String ip = request.getRemoteAddr();
        map.put(ip,map.getOrDefault(ip,0)+1);
        map.forEach((key,value)->{
            if(properties.getDisplay().equals(IpCounterProperties.DisplayMode.DETAIL.getValue())){
                System.out.println("\t\t\tip访问监控");
                System.out.println("+----------ip----------+----count----+");
                System.out.println("\t\t" + key + "\t\t\t" + value);
                System.out.println("+----------------------+------------+");
            }else{
                System.out.println("ip: " + key + " value: " + value);
            }
        });
    }
}
