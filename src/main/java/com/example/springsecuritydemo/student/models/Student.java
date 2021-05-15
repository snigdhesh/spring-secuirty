package com.example.springsecuritydemo.student.models;

public class Student {
  private int sudentId;
  private String studentName;

  public Student(){
  }

  public Student(int sudentId, String studentName) {
    this.sudentId = sudentId;
    this.studentName = studentName;
  }

  public int getSudentId() {
    return sudentId;
  }

  public String getStudentName() {
    return studentName;
  }
}
