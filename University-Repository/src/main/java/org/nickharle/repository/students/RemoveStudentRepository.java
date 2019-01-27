package org.nickharle.repository.students;

import org.nickharle.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemoveStudentRepository extends JpaRepository<Student, Integer> {
}
