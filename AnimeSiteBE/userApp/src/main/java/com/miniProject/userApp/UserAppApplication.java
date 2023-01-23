package com.miniProject.userApp;

import com.miniProject.userApp.filter.CFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableEurekaClient
public class UserAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAppApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<?> filterUrl(){
		System.out.println("inside filterurl");
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new CFilter());
		filterRegistrationBean.addUrlPatterns("/userApp/addAnime");
		filterRegistrationBean.addUrlPatterns("/userApp/deleteAnime");
		filterRegistrationBean.addUrlPatterns("/userApp/userDetails");
		return filterRegistrationBean;
	}
	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		System.out.println("inside USERAPPAPPLICATION FILTERREGISTRATION BEAN");
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:4200");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}
