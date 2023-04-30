package com.geekster.University.Event.Management.controller;

import com.geekster.University.Event.Management.models.EnumDepartment;
import com.geekster.University.Event.Management.models.StudentModel;
import com.geekster.University.Event.Management.service.StudentService;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping(value = "/addStudent")
    public String addStudent(@Valid @RequestBody ArrayList<StudentModel> studentList){
        return studentService.saveStudent(studentList);
    }
    @PutMapping("/updateStudentDepartment/{id}/{department}")
    public void updateStudentdetails(@PathVariable Integer id , @PathVariable EnumDepartment department ){
         studentService.udateDetails(id , department);
    }


    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id){
        studentService.deleteStudentDetails(id);
    }
    @GetMapping("/GetStudents")
    public Iterable<StudentModel> GetStudents(){
        return studentService.GetAllStudents();
    }
    @GetMapping("/getStudentById/{id}")
    public Optional<StudentModel> getStudentById(@PathVariable Integer id){
        return studentService.findStudentById(id);
    }
}
