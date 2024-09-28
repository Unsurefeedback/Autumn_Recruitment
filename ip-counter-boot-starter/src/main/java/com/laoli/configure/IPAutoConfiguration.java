package com.laoli.configure;

import com.laoli.service.IpCounterService;
import com.laoli.service.impl.IpCounterServiceImpl;
import org.springframework.context.annotation.Bean;

/**
 * @author WeiHanQiang
 * @date 2024/09/28 22:45
 **/
@SuppressWarnings("all")
public class IPAutoConfiguration {
    @Bean
    public IpCounterService ipCounterService(){
        return new IpCounterServiceImpl();
    }
}
