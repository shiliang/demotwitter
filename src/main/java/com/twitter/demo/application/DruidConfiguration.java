package com.twitter.demo.application;/*
 * @program:com.twitter.demo.application
 * @description:数据库连接池监控配置
 * @author:shiliang
 * @create:2018-06-01 14:38
 * */

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfiguration {
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //IP白名单
        servletRegistrationBean.addInitParameter("allow","118.25.133.243,127.0.0.1");
        //IP黑名单
        servletRegistrationBean.addInitParameter("deny","192.168.1.100");
        //控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername","druid");
        servletRegistrationBean.addInitParameter("loginPassword","123456");
        //是否能重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;

    }

    @Bean
    public FilterRegistrationBean statFilter() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //增加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的格式
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png," +
                "*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }


}
