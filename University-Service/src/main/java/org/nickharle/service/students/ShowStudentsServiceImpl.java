package org.nickharle.service.students;

import org.nickharle.model.entity.Student;
import org.nickharle.repository.students.ShowAllStudentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowStudentsServiceImpl implements ShowStudentService {

    private ShowAllStudentsRepository showAllStudentsRepository;

    public ShowStudentsServiceImpl(ShowAllStudentsRepository showAllStudentsRepository) {
        this.showAllStudentsRepository = showAllStudentsRepository;
    }

    public List<Student> getAllStudents() {

        return showAllStudentsRepository.getAllStudents();
    }

}
