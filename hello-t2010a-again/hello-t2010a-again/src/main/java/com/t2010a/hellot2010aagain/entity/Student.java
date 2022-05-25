package com.t2010a.hellot2010aagain.entity;

import com.t2010a.hellot2010aagain.util.DateTimeHelper;
import com.t2010a.hellot2010aagain.util.ValidationUtil;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Student {

    private String rollNumber;
    private String fullName;
    private String email;
    private String phone;
    private LocalDateTime dob;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int status;
    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid(){
        checkValidate();
        return errors.size() == 0;
    }

    private void checkValidate() {
        if (rollNumber == null || rollNumber.length() == 0) {
            errors.put("rollNumber", "Please enter rollnumber");
        }
        if (fullName == null || fullName.length() == 0) {
            errors.put("fullName", "Please enter fullname");
        }
        if (email == null || email.length() == 0) {
            errors.put("email", "Please enter email");
        } else if (!ValidationUtil.checkEmail(email)) {
            errors.put("email", "Invalid email, please enter real email. For example: admin@gmail.com");
        }
        if (phone == null || phone.length() == 0) {
            errors.put("phone", "Please enter phone");
        }
    }

    public Student(String rollNumber, String fullName, String email, String phone, LocalDateTime dob, LocalDateTime createdAt, LocalDateTime updatedAt, int status) {
        this.rollNumber = rollNumber;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Student(String rollNumber, String fullName, String email, String phone, LocalDateTime dob) {
        this.rollNumber = rollNumber;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }

    public Student() {
        this.rollNumber = "";
        this.fullName = "";
        this.email = "";
        this.phone = "";
    }

    public Student(String rollNumber, String fullName, String email, String phone) {
        this.rollNumber = rollNumber;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber='" + rollNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                '}';
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getJoinedAt() {
        if(this.createdAt != null){
            return DateTimeHelper.convertLocalDateTimeToString(this.createdAt);
        }
        return "";
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDemoString(){
        return "Yay,";
    }

    public String getDobString() {
        if(this.dob != null){
            return DateTimeHelper.convertLocalDateTimeToString(this.dob);
        }
        return "";
    }
}
