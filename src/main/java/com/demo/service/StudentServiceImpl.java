package com.demo.service;

import com.demo.dto.StudentDTO;
import com.demo.entity.Student;
import com.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{


    StudentRepository repository;

    @Autowired
    public void setRepository(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentDTO saveStudent(Student student){
        Student response=repository.save(student);
        StudentDTO dto = EntityToDto(response);

        return dto;
    }

    @Override
    public StudentDTO getStudent(Integer roll) {
        Student student= repository.findById(roll).get();
        StudentDTO dto = EntityToDto(student);
        return dto;
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student updateStudent(Student student, Integer roll) {
        Student student1 = repository.findById(roll).get();
        if(student1.getRoll() != student.getRoll()) throw new RuntimeException("Student Not Fount");

        return repository.save(student);
    }

    @Override
    public String deleteStudent(Integer roll) {
        repository.deleteById(roll);
        return "Student Deleted";
    }

    private StudentDTO EntityToDto(Student student){
        StudentDTO dto = new StudentDTO();
        dto.setRoll(student.getRoll());
        dto.setName(student.getName());
        dto.setAddress(student.getAddress());
        dto.setGender(student.getGender());
        return dto;
    }

}
