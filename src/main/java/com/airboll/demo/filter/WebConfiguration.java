package com.airboll.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
  // 此为老方法，新方法见https://www.jianshu.com/p/05c8be17c80a

  @Bean
  // 增加代理服务器IP过滤器
  public RemoteIpFilter remoteIpFilter() {
    return new RemoteIpFilter();
  }

  @Bean
  // 增加自定义过滤器
  public FilterRegistrationBean testFilterRegistration() {

    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new MyFilter());
    registration.addUrlPatterns("/*");
    registration.addInitParameter("paramName", "paramValue");
    registration.setName("MyFilter");
    registration.setOrder(1);
    return registration;
  }

  public class MyFilter implements Filter {
    @Override
    public void destroy() {
      // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse,
        FilterChain filterChain) throws IOException, ServletException {
      // TODO Auto-generated method stub
      HttpServletRequest request = (HttpServletRequest) srequest;
      System.out.println("this is MyFilter,urls :" + request.getRequestURI());
      filterChain.doFilter(srequest, sresponse);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
      // TODO Auto-generated method stub
    }
  }
}
