package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import request.CreateStudentRequest;
import response.StudentResponse;
import service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public StudentResponse create(@RequestBody CreateStudentRequest request){
        return studentService.createStudent(request);
    }

    @GetMapping("/getById/{id}")
    public StudentResponse getById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
}
