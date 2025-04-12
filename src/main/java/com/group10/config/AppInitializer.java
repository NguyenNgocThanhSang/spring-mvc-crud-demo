package com.group10.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Lớp này thay thế web.xml để cấu hình DispatcherServlet.
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Không có cấu hình root trong ví dụ đơn giản này
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Chỉ định lớp cấu hình Spring MVC
        return new Class<?>[] { AppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        // Map DispatcherServlet với URL pattern "/"
        return new String[] { "/" };
    }
}