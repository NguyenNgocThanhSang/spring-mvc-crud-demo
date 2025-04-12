package com.group10.model;

/**
 * Lớp Model đại diện cho thông tin Sinh viên.
 */
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    // ID sẽ được quản lý và gán bởi lớp DAO khi thêm mới

    // Constructor mặc định (cần thiết cho Spring MVC data binding)
    public Student() {
        // Để trống hoặc khởi tạo giá trị mặc định khác nếu cần, ID sẽ do DAO xử lý
    }

    // Constructor với tham số
    // Constructor với tham số (không gán ID ở đây)
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Constructor đầy đủ (dùng khi cần set ID cụ thể, ví dụ khi cập nhật)
    public Student(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }
}