package com.group10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller chính xử lý các request liên quan đến trang chủ.
 */
@Controller // Đánh dấu đây là một Spring MVC Controller
public class HomeController {

    /**
     * Xử lý request GET đến root URL ("/").
     * Thêm một message vào model và trả về tên view "home".
     * Spring sẽ tìm file /WEB-INF/view/home.jsp dựa trên cấu hình ViewResolver.
     * @param model Đối tượng Model để truyền dữ liệu tới view.
     * @return Tên của view (không bao gồm prefix và suffix).
     */
    @GetMapping("/") // Map request GET tới URL "/"
    public String showHomePage(Model model) {
        // Thêm một thuộc tính "message" vào model
        model.addAttribute("message", "Chào mừng đến với Spring MVC Demo!");
        // Trả về tên logic của view
        return "home"; // Spring sẽ tìm file /WEB-INF/view/home.jsp
    }
}