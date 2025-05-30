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
import java.util.List;
import java.util.Optional;

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

    public Student getStudentById(int id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }else{
            return null;
        }
    }

    public List<Student> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public String updateStudent(int id, StudentRequestDto newStudentRequestDto){
        // check whether id is present or not

       Student existingStudent = getStudentById(id);
       if(existingStudent!=null){
           existingStudent.setName(newStudentRequestDto.getName());
           existingStudent.setMobile(newStudentRequestDto.getMobile());
           existingStudent.setSem(newStudentRequestDto.getSem());
           existingStudent.setDob(newStudentRequestDto.getDob());
           existingStudent.setDept(newStudentRequestDto.getDept());
           existingStudent.setGender(newStudentRequestDto.getGender());
           existingStudent.setEmail(newStudentRequestDto.getEmail());
           existingStudent.setAddress(newStudentRequestDto.getAddress());

           studentRepository.save(existingStudent);
           return "Student updated successfully!";
       }else{
           return "student not found, hence cannot update";
       }
    }

    public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return "Student with id "+id+" deleted successfully";
    }
}
