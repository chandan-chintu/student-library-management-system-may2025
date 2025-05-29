package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converter.StudentConverter;
import com.example.student_library_management_system.enums.CardStatus;
import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.repository.StudentRepository;
import com.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    private Student student;

    public String saveStudent(StudentRequestDto studentRequestDto){

        // first convert the studentrequestdto into student model class object
         Student student = StudentConverter.convertStudentRequestDtoIntoStudent(studentRequestDto);

         //whenever student is created even card has to be automatically created for that student
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setExpiryDate(LocalDate.now().plusYears(4).toString());
        card.setStudent(student);

        student.setCard(card);

       // save the student
        studentRepository.save(student);
        return "Student saved successfully!";

    }
}
