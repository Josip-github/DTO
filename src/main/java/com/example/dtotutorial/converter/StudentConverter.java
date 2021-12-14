package com.example.dtotutorial.converter;

import com.example.dtotutorial.dto.StudentDTO;
import com.example.dtotutorial.entity.Student;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {

    public StudentDTO entityToDto(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        studentDTO.setUsername(student.getUsername());
        return studentDTO;
    }

    public Student dtoToEntity(StudentDTO studentDTO){

        ModelMapper modelMapper = new ModelMapper();
        Student student = modelMapper.map(studentDTO, Student.class);
        return student;
    }

    public List<StudentDTO> entityToDto(List<Student> student) {

        return	student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public List<Student> dtoToEntity(List<StudentDTO> dto) {

        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
