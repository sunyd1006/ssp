package com.kuang.config;

import com.kuang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：ltb
 * @date ：2020/7/14
 */

@Configuration
public class KuangConfig {

    @Bean
    public User user(){
        return new User();
    }

}
