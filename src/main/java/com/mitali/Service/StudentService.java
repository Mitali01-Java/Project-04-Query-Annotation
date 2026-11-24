package com.mitali.Service;

import com.mitali.Entity.Gender;
import com.mitali.Entity.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {

    public List<Student> FindFemaleStudentByDob(Gender gender, LocalDate dob);

    public Student SaveStudents(Student student);

    public List<Student> FindByGenderAndPerBetween(Gender gender, Long start, Long end);

    public int UpdateStudentPer(Integer rno,Long per);

    public int DeleteStudentByRno(Integer rno);
}
