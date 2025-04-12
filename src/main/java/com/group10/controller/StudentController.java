package com.group10.controller;

import com.group10.dao.StudentDAO;
import com.group10.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*; // Import các annotation cần thiết

import java.util.List;

/**
 * Controller xử lý các yêu cầu CRUD cho đối tượng Student.
 */
@Controller
@RequestMapping("/student") // Base mapping cho tất cả các request trong controller này
public class StudentController {

    // Inject StudentDAO để tương tác với dữ liệu
    @Autowired
    private StudentDAO studentDAO;

    /**
     * Hiển thị danh sách sinh viên.
     * Xử lý GET request tới "/student/list".
     * @param model Model để truyền dữ liệu tới view.
     * @return Tên view "list-students".
     */
    @GetMapping("/list")
    public String listStudents(Model model) {
        // Lấy danh sách sinh viên từ DAO
        List<Student> students = studentDAO.getAllStudents();
        // Thêm danh sách vào model
        model.addAttribute("students", students);
        // Trả về tên view
        return "list-students"; // Sẽ tìm file /WEB-INF/view/list-students.jsp
    }

    /**
     * Hiển thị form để thêm sinh viên mới.
     * Xử lý GET request tới "/student/showFormForAdd".
     * @param model Model để truyền đối tượng Student mới (rỗng) cho data binding.
     * @return Tên view "student-form".
     */
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        // Tạo một đối tượng Student mới để binding dữ liệu từ form
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-form"; // Sẽ tìm file /WEB-INF/view/student-form.jsp
    }

    /**
     * Xử lý việc lưu sinh viên (thêm mới hoặc cập nhật).
     * Xử lý POST request tới "/student/saveStudent".
     * Sử dụng @ModelAttribute để tự động binding dữ liệu từ form vào đối tượng Student.
     * @param student Đối tượng Student được binding từ form.
     * @return Redirect về trang danh sách sinh viên.
     */
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        // Kiểm tra ID của đối tượng student từ form
        // Nếu ID là 0 (giá trị mặc định khi thêm mới), gọi addStudent (DAO sẽ gán ID mới)
        // Nếu ID khác 0, coi như cập nhật
        if (student.getId() == 0) {
            studentDAO.addStudent(student);
        } else {
            studentDAO.updateStudent(student);
        }
        return "redirect:/student/list"; // Chuyển hướng về trang danh sách
    }

    /**
     * Hiển thị form để cập nhật thông tin sinh viên.
     * Xử lý GET request tới "/student/showFormForUpdate".
     * Lấy studentId từ request parameter.
     * @param studentId ID của sinh viên cần cập nhật (lấy từ URL).
     * @param model Model để truyền đối tượng Student cần cập nhật tới view.
     * @return Tên view "student-form".
     */
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int studentId, Model model) {
        // Lấy thông tin sinh viên từ DAO theo ID
        Student student = studentDAO.getStudentById(studentId);
        // Thêm sinh viên vào model để điền vào form
        model.addAttribute("student", student);
        return "student-form";
    }

     /**
     * Xử lý việc xóa sinh viên.
     * Xử lý GET request tới "/student/delete".
     * Lấy studentId từ request parameter.
     * @param studentId ID của sinh viên cần xóa (lấy từ URL).
     * @return Redirect về trang danh sách sinh viên.
     */
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") int studentId) {
        // Gọi DAO để xóa sinh viên
        studentDAO.deleteStudent(studentId);
        return "redirect:/student/list"; // Chuyển hướng về trang danh sách
    }
}