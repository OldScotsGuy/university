package org.nickharle.service.students;

import org.nickharle.model.entity.Student;
import org.nickharle.repository.students.AddStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class AddStudentServiceImpl implements AddStudentService{

    private AddStudentRepository addStudentRepository;

    public AddStudentServiceImpl(AddStudentRepository addStudentRepository) {
        this.addStudentRepository = addStudentRepository;
    }

    public void saveStudent(Student studentDAO) {

        //Student student = new Student();
        //student.setFirstName(studentDAO.getFirstName());
        //student.setLastName(studentDAO.getLastName());
        //student.setAge(studentDAO.getAge());
        //student.setGender(studentDAO.getGender());
        //student.setUniversity(studentDAO.getUniversity());

        addStudentRepository.save(studentDAO);
    }

}
