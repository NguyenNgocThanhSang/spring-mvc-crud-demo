package com.group10.model;

/**
 * Lớp Model đại diện cho thông tin Sinh viên.
 */
public class Student {
    private int id;
    private String fullName;
    private String dateOfBirth; // Định dạng dd/mm/yyyy
    private String email;

    // ID sẽ được quản lý và gán bởi lớp DAO khi thêm mới

    // Constructor mặc định (cần thiết cho Spring MVC data binding)
    public Student() {
        // Để trống hoặc khởi tạo giá trị mặc định khác nếu cần, ID sẽ do DAO xử lý
    }

    // Constructor với tham số
    // Constructor với tham số (không gán ID ở đây)
    public Student(String fullName, String dateOfBirth, String email) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    // Constructor đầy đủ (dùng khi cần set ID cụ thể, ví dụ khi cập nhật)
    public Student(int id, String fullName, String dateOfBirth, String email) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        // Không cần xử lý idCounter ở đây
    }


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        // Không cần xử lý idCounter ở đây
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Không cần phương thức reset counter nữa

    @Override
    public String toString() {
        return "Student [id=" + id + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", email=" + email + "]";
    }
}