package com.group10.dao;

import com.group10.model.Student;
import org.springframework.stereotype.Repository; // Đánh dấu là một bean quản lý dữ liệu

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList; // An toàn cho môi trường đa luồng đơn giản

/**
 * Lớp triển khai StudentDAO sử dụng danh sách trong bộ nhớ (ArrayList).
 * Sử dụng @Repository để Spring quản lý bean này.
 */
@Repository // Đánh dấu đây là một Data Access Component (Bean)
public class StudentDAOImpl implements StudentDAO {

    // Sử dụng CopyOnWriteArrayList để tránh ConcurrentModificationException trong môi trường web đơn giản
    private final List<Student> students = new CopyOnWriteArrayList<>();
    // Biến đếm để tạo ID duy nhất cho sinh viên mới
    private int nextId = 1;

    // Khởi tạo một vài dữ liệu mẫu
    public StudentDAOImpl() {
        students.add(new Student(1, "Nguyen Van A", "01/01/2000", "a.nguyen@example.com"));
        students.add(new Student(2, "Tran Thi B", "15/05/2001", "b.tran@example.com"));
        students.add(new Student(3, "Le Van C", "20/11/1999", "c.le@example.com"));
        // Tìm ID lớn nhất trong dữ liệu mẫu để khởi tạo nextId
        int maxId = students.stream()
                            .mapToInt(Student::getId)
                            .max()
                            .orElse(0); // Nếu không có dữ liệu mẫu, bắt đầu từ 0
        nextId = maxId + 1; // ID tiếp theo sẽ lớn hơn ID lớn nhất hiện có
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students); // Trả về bản sao để tránh sửa đổi trực tiếp danh sách gốc
    }

    @Override
    public Student getStudentById(int id) {
        Optional<Student> studentOptional = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        return studentOptional.orElse(null);
    }

    @Override
    public void addStudent(Student student) {
        // Gán ID mới duy nhất cho sinh viên và tăng biến đếm
        student.setId(nextId++);
        students.add(student);
    }

    @Override
    public void updateStudent(Student student) {
        Optional<Student> existingStudentOpt = students.stream()
                .filter(s -> s.getId() == student.getId())
                .findFirst();

        existingStudentOpt.ifPresent(existingStudent -> {
            int index = students.indexOf(existingStudent);
            if (index != -1) {
                students.set(index, student); // Thay thế đối tượng cũ bằng đối tượng mới
            }
        });
    }

    @Override
    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }
}