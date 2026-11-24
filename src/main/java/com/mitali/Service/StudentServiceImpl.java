package com.mitali.Service;

import com.mitali.Entity.Gender;
import com.mitali.Entity.Student;
import com.mitali.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> FindFemaleStudentByDob(Gender gender, LocalDate dob){

        return studentRepository.FemaleBirthToday(gender,dob);
    }

    @Override
    public Student SaveStudents(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> FindByGenderAndPerBetween(Gender gender, Long start,Long end){
        return studentRepository.findByGenderAndPer(gender,start,end);
    }

    @Override
    public int UpdateStudentPer(Integer rno, Long per) {
        return studentRepository.UpdateByPer(rno,per);
    }

    @Override
    public int DeleteStudentByRno(Integer rno) {
        return studentRepository.DeleteByRno(rno);
    }


}
