package com.group10.dao;

import com.group10.model.Student;
import java.util.List;

/**
 * Interface định nghĩa các thao tác truy cập dữ liệu cho Student.
 */
public interface StudentDAO {

    /**
     * Lấy danh sách tất cả sinh viên.
     * @return Danh sách Student.
     */
    List<Student> getAllStudents();

    /**
     * Lấy thông tin sinh viên theo ID.
     * @param id ID của sinh viên.
     * @return Đối tượng Student hoặc null nếu không tìm thấy.
     */
    Student getStudentById(int id);

    /**
     * Thêm một sinh viên mới.
     * @param student Đối tượng Student cần thêm.
     */
    void addStudent(Student student);

    /**
     * Cập nhật thông tin sinh viên.
     * @param student Đối tượng Student với thông tin đã cập nhật.
     */
    void updateStudent(Student student);

    /**
     * Xóa sinh viên theo ID.
     * @param id ID của sinh viên cần xóa.
     */
    void deleteStudent(int id);
}