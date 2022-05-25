package com.t2010a.hellot2010aagain.model;


import com.t2010a.hellot2010aagain.entity.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentModel implements StudentModel {

    private static List<Student> students;

    public InMemoryStudentModel() {
        students = new ArrayList<>();
        students.add(
                new Student(
                        "A001",
                        "Ngoc Linh",
                        "ngoclinh@gmail.com",
                        "0956897456",
                        LocalDateTime.of(2002, 01, 07, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        students.add(
                new Student(
                        "A002",
                        "Ngoc Son",
                        "ngocson@gmail.com",
                        "0987523456",
                        LocalDateTime.of(2003, 02, 07, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        students.add(
                new Student(
                        "A003",
                        "Ngoc Long",
                        "ngoclong@gmail.com",
                        "0983369741",
                        LocalDateTime.of(2004, 03, 10, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        students.add(
                new Student(
                        "A004",
                        "Ngoc Lien",
                        "ngoclien@gmail.com",
                        "0981482973",
                        LocalDateTime.of(2005, 10, 10, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
    }

    @Override
    public Student save(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Student findById(String rollNumber) {
        Student foundStudent = null;
        for (Student student :
                students) {
            if (student.getRollNumber().equals(rollNumber)) {
                foundStudent = student;
                break;
            }
        }
        return foundStudent;
    }

    @Override
    public Student update(String rollNumber, Student updateStudent) {
        Student existingStudent = findById(rollNumber);
        if(existingStudent == null){
            return null;
        }
        existingStudent.setFullName(updateStudent.getFullName());
        existingStudent.setEmail(updateStudent.getEmail());
        existingStudent.setPhone(updateStudent.getPhone());
        existingStudent.setDob(updateStudent.getDob());
        existingStudent.setUpdatedAt(LocalDateTime.now());
        existingStudent.setStatus(updateStudent.getStatus());
        return existingStudent;
    }

    @Override
    public boolean delete(String rollNumber) {
        int foundIndex = -1;
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getRollNumber().equals(rollNumber)){
                foundIndex = i;
            }
        }
        if(foundIndex != -1){
            students.remove(foundIndex);
            return true;
        }
        return false;
    }
}
