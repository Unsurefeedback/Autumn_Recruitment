package com.example;

/**
 * @author WeiHanQiang
 * @date 2024/09/25 16:01
 **/
import com.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        // 测试方法
        System.out.println(userService.getUserById(1L));
        System.out.println(userService.getUserById(2L));
    }
}

