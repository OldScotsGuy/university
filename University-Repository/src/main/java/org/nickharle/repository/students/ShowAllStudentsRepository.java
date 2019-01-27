package org.nickharle.repository.students;

import org.nickharle.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowAllStudentsRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s")
    List<Student> getAllStudents();
}
