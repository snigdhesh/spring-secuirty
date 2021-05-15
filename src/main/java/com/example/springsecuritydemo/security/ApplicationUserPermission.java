package com.example.springsecuritydemo.security;

public enum ApplicationUserPermission {
  STUDENT_READ("student:read"), //This is like we are assigning a value to a constant.
  STUDENT_WRITE("student:write"),
  COURSE_READ("course:read"),
  COURSE_WRITE("course:write");

  private final String permission;

  ApplicationUserPermission(String permission) {
    this.permission = permission;
  }
}
