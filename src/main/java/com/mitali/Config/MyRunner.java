package com.mitali.Config;

import com.mitali.Entity.Gender;
import com.mitali.Entity.Student;
import com.mitali.Service.StudentService;
import com.mitali.Service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyRunner implements ApplicationRunner {

    @Autowired
    private StudentServiceImpl studentserviceimpl;

    private static void printStudent(Student s){
        System.out.println("Rno : " +s.getRno());
        System.out.println("Name : " + s.getName());
        System.out.println("Gender : " + s.getGender());
        System.out.println("percent : " +  s.getPercent());
        System.out.println("DOB : " +  s.getDateofBirth());
        System.out.println("--".repeat(25));

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /* Case 1 : Female student by using DOB
        //Female student whose
        List<Student> listFemale = studentserviceimpl.FindFemaleStudentByDob(Gender.FEMALE, LocalDate.of(2026,10,27));
        for(Student s : listFemale){
            MyRunner.printStudent(s);
        }
        */
        /* Case 2 - Add student

        Student s1 = new Student(104,"DD",Gender.MALE,80L,LocalDate.of(2026,10,11));
        Student s2 = new Student(105,"FF",Gender.MALE,85L,LocalDate.of(2026,10,11));

        studentserviceimpl.SaveStudents(s1);
        studentserviceimpl.SaveStudents(s2);
        System.out.println("Student saved");
        */
        /*
        //Case 3 - Percentage in between
        List<Student> students = studentserviceimpl.FindByGenderAndPerBetween(Gender.MALE,80L,90L);
        for (Student Studentlist : students){
            MyRunner.printStudent(Studentlist);
        }
        */

        /*
        //Case 4 - Update @Modifying and @Transactional needed for update and delete

        int Update =studentserviceimpl.UpdateStudentPer(105,89L);
        System.out.println("Update StudentPer"+Update);
        */

        // case 5 - Delete Student
        int del = studentserviceimpl.DeleteStudentByRno(104);
        System.out.println("Deleted  "+ del);


    }
}
