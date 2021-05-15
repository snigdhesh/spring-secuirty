package com.example.springsecuritydemo.student.controllers;

import com.example.springsecuritydemo.student.models.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
  private static final List<Student> STUDENT_LIST = Arrays.asList(
    new Student(1, "James Bond"),
    new Student(2, "Maria Jones"),
    new Student(3, "Anna Smith")
  );


  @GetMapping
  public List<Student> getAllStudents(){
    return STUDENT_LIST;
  }

  @PostMapping
  public void registerNewStudent(@RequestBody Student student){
    System.out.println(student);
  }

  @PutMapping(path="{studentId}")
  public void updateStudent(@PathVariable("studentId") Integer studentId,@RequestBody Student student){
    System.out.println(String.format("studentId=%s,student=%s",studentId,student));
  }

  @DeleteMapping(path="{studentId}")
  public void deleteStudent(Integer studentId){
    System.out.println("studentId="+studentId);
  }
}
