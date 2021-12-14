package com.example.dtotutorial.controller;

import com.example.dtotutorial.converter.StudentConverter;
import com.example.dtotutorial.dto.StudentDTO;
import com.example.dtotutorial.entity.Student;
import com.example.dtotutorial.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentConverter studentConverter;

    @GetMapping("/getAll")
    public List<StudentDTO> getAllStudentDTOs(){
        List<Student> listOfStudents = studentRepository.findAll();
        return studentConverter.entityToDto(listOfStudents);
    }

    @GetMapping("/students")
    public List<Student> getList(){
        return studentRepository.findAll();
    }

    @GetMapping("/find/{ID}")
    public StudentDTO findById(@PathVariable(value = "ID") Long id){
        Student st = studentRepository.findById(id).get();
        return studentConverter.entityToDto(st);
    }

    @PostMapping("/save")
    public StudentDTO save(@RequestBody StudentDTO studentDTO){

        Student student = studentConverter.dtoToEntity(studentDTO);
        student = studentRepository.save(student);
        return studentConverter.entityToDto(student);
    }
}
