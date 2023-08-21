package kempaiah.microservices.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kempaiah.microservices.springbootrestapi.dto.Student;

@RestController
public class StudentController {


  @GetMapping("student")
  public ResponseEntity<Student> getStudent() {
    Student student = new Student(1,"Sri","Rama");
    return ResponseEntity.ok().header("Sri","Ganesha").body(student);
  }

  @PostMapping("student")
  @ResponseStatus(HttpStatus.CREATED)
  public Student createStudent(@RequestBody Student student) {

    System.out.println(student.getId());
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());
    return student;
  }

  @PutMapping("student/{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public Student updateStudent(@RequestBody Student student,  @PathVariable long id) {

    System.out.println(id);
    System.out.println(student.getId());
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());
    return student;
  }

  @DeleteMapping("student/{id}")
  @ResponseStatus(HttpStatus.OK)
  public String deleteStudent( @PathVariable long id) {

    return "Student deleted successfully.";
  }

  @GetMapping("student/{id}/{first-name}/{last-name}")
  public Student getStudentById(@PathVariable long id,
      @PathVariable("first-name") String firstName,
      @PathVariable("last-name") String lastName) {

    return new Student(id, firstName, lastName);
  }

  @GetMapping("student/query")
  public Student getStudentByRequestParameter(@RequestParam long id,
      @RequestParam("firstName") String firstName,
      @RequestParam("lastName") String lastName) {

    return new Student(id, firstName, lastName);
  }

  @GetMapping("students")
  public List<Student> getStudents() {

    List<Student> students = new ArrayList<>();

    students.add(new Student(1,"Sri","Rama"));
    students.add(new Student(2,"Sri","Krishna"));
    students.add(new Student(3,"Sri","Shiva"));
    students.add(new Student(4,"Sri","Ganesha"));
    students.add(new Student(5,"Sri","Karthikeya"));

    return students;
  }
}
