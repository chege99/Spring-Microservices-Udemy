package com.school.student.service;

import com.school.student.entity.Student;
import com.school.student.repository.StudentRepository;
import com.school.student.request.CreateStudentRequest;
import com.school.student.response.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {
    Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    StudentRepository studentRepository;

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest){
        Student student = new Student();
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());
        student.setAddressId(createStudentRequest.getAddressId());

        studentRepository.save(student);

        return new StudentResponse(student);
    }

    public StudentResponse getById(long Id){
        logger.info("Inside getById : "+Id);

            Student student = studentRepository.findById(Id).get();

            return new StudentResponse(student);
    }

}
