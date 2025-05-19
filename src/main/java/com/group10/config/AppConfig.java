package com.group10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Lớp cấu hình chính cho Spring MVC.
 */
@Configuration // Đánh dấu đây là lớp cấu hình
@EnableWebMvc // Kích hoạt các tính năng của Spring MVC
@ComponentScan(basePackages = "com.group10") // Quét các component trong package com.group10 (ví dụ: Controller)
public class AppConfig implements WebMvcConfigurer {

    /**
     * Cấu hình ViewResolver để Spring biết cách tìm các file JSP.
     * Các view sẽ được tìm trong thư mục /WEB-INF/view/ và có đuôi .jsp.
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class); // Hỗ trợ JSTL tags
        viewResolver.setPrefix("/WEB-INF/view/"); // Tiền tố đường dẫn đến view
        viewResolver.setSuffix(".jsp"); // Hậu tố tên file view
        return viewResolver;
    }

    /**
     * Cấu hình xử lý các tài nguyên tĩnh (CSS, JS, Images).
     * Các request tới /resources/** sẽ được phục vụ từ thư mục /src/main/webapp/resources/.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**") // URL pattern
                .addResourceLocations("/resources/"); // Thư mục chứa tài nguyên tĩnh
    }
}