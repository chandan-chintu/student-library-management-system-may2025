package com.example.student_library_management_system.repository;

import com.example.student_library_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    // user defined customized queries

    @Query(nativeQuery = true, value = "select * from student where email = :email1")
    public Student getStudentByEmail(String email1);

    @Query(nativeQuery = true, value = "select * from student where dept = :dept1")
    public List<Student> getStudentByDept(String dept1);
}
