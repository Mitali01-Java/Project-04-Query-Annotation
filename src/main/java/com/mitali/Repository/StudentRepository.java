package com.mitali.Repository;

import com.mitali.Entity.Gender;
import com.mitali.Entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Integer> {

    @Query("SELECT s FROM Student s WHERE s.gender = :gender AND s.dateofBirth = :dob")
    List<Student> FemaleBirthToday(
            @Param("gender") Gender gender,
            @Param("dob") LocalDate dob
    );

    @Query("""
    SELECT s FROM Student s WHERE 
    s.gender = :gender AND 
    s.percent BETWEEN :start AND :end
      ORDER BY s.percent DESC  
            """)
    List<Student> findByGenderAndPer(
            @Param("gender")Gender gender,
            @Param("start")Long start,
            @Param("end") Long end
    );

    @Modifying
    @Transactional
    @Query("Update Student s SET s.percent =:per WHERE s.rno =:rno")
    int UpdateByPer(
            @Param("rno") Integer rno,
            @Param("per") Long per
    );

//    @Modifying
//    @Transactional
//    @Query("DELETE FROM Student s WHERE s.rno =:rno")
//    int DeleteByRno(
//            @Param("rno") Integer rno
//    );
    //NativeSQL
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM student WHERE rno = :rno", nativeQuery = true)
    int DeleteByRno(@Param("rno") Integer rno);
}
