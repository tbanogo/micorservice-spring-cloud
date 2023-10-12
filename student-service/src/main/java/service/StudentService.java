package service;

import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepository;
import request.CreateStudentRequest;
import response.StudentResponse;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CommonService commonService;

    public StudentResponse createStudent(CreateStudentRequest request){
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setAddressId(request.getAddressId());
        student = studentRepository.save(student);

        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setAddress(commonService.getById(student.getAddressId()));

        return studentResponse;
    }

    public StudentResponse getStudentById(Long id){
        Student student = studentRepository.findById(id).get();
        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setAddress(commonService.getById(student.getAddressId()));

        return studentResponse;
    }
}
