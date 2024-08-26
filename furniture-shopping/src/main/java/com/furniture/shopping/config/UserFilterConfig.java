package com.furniture.shopping.config;

import com.furniture.shopping.filter.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用户过滤器配置
 */
@Configuration
public class UserFilterConfig {

    @Bean
    public UserFilter userFilter(){
        return new UserFilter();
    }

    @Bean(name = "UserFilterConf")
    public FilterRegistrationBean userFilterConfig(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(userFilter());
        filterRegistrationBean.addUrlPatterns("/api/user/insert/*");
        filterRegistrationBean.addUrlPatterns("/api/user/delete/*");
        filterRegistrationBean.addUrlPatterns("/api/user/update/*");
        filterRegistrationBean.addUrlPatterns("/api/pro/*");
        filterRegistrationBean.addUrlPatterns("/api/order/*");
        filterRegistrationBean.addUrlPatterns("/api/del/*");
        filterRegistrationBean.addUrlPatterns("/api/msg/*");
        filterRegistrationBean.addUrlPatterns("/api/desi/*");
        filterRegistrationBean.setName("userFilterConf");
        return filterRegistrationBean;
    }
}
