package com.demo.controller;

import com.demo.dto.StudentDTO;
import com.demo.entity.Student;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private StudentService service;


    @GetMapping("/get/{roll}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Integer roll){
        StudentDTO dto = service.getStudent(roll);
        return ResponseEntity.status(200).body(dto);
    }

    @GetMapping("/allStudents")
    public List<Student> getAllStudent(){

        return service.getAllStudents();
    }

    @PostMapping("/save")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody Student student){
        //return ;
        return ResponseEntity
                .status(201)
                .body(service.saveStudent(student));
    }
    @PutMapping("/update/{roll}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Integer roll){
        return service.updateStudent(student,roll);
    }

    @DeleteMapping("/delete/{roll}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer roll){
        return ResponseEntity.status(204).body(service.deleteStudent(roll));
    }
}
