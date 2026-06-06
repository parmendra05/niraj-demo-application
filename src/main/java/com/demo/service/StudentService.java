package com.demo.service;

import com.demo.dto.StudentDTO;
import com.demo.entity.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentService {

    public StudentDTO saveStudent(Student student);

    StudentDTO getStudent(Integer roll);

    List<Student> getAllStudents();

    Student updateStudent(Student student, Integer roll);

    String deleteStudent(Integer roll);
}
