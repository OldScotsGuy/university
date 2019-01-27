package org.nickharle.service.students;

import org.nickharle.model.entity.Student;
import org.nickharle.repository.students.RemoveStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoveStudentServiceImpl implements RemoveStudentService {

    private RemoveStudentRepository removeStudentRepository;

    public RemoveStudentServiceImpl(RemoveStudentRepository removeStudentRepository) {
        this.removeStudentRepository = removeStudentRepository;
    }

    public void removeStudent(Student student) {
        removeStudentRepository.delete(student);
    }
}
