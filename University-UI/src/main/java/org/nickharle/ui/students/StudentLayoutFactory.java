package org.nickharle.ui.students;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.nickharle.model.entity.Student;
import org.nickharle.service.students.AddStudentServiceImpl;
import org.nickharle.service.students.RemoveStudentServiceImpl;
import org.nickharle.service.students.ShowStudentsServiceImpl;
import org.nickharle.ui.commons.StudentForm;
import org.nickharle.ui.commons.UILayout;

@Route(value = StudentLayoutFactory.NAME, layout = UILayout.class)
@PageTitle("U n i v e r s i t y - Students")
public class StudentLayoutFactory extends HorizontalLayout {

    public static final String NAME = "students";
    private Grid<Student> grid = new Grid<Student>();

    private ShowStudentsServiceImpl studentsService;

    StudentLayoutFactory(ShowStudentsServiceImpl studentsService,
                         RemoveStudentServiceImpl removeStudentService,
                         AddStudentServiceImpl addStudentService) {

        // Assign Beans
        this.studentsService = studentsService;

        setMargin(true);
        add(new Label("Current Students"));

        StudentForm studentForm = new StudentForm(this, removeStudentService, addStudentService);

        // Grid to Display Student Objects
        // ===============================
        grid.setSizeFull();
        grid.addColumn(Student::getFirstName).setHeader("First name");
        grid.addColumn(Student::getLastName).setHeader("Last name");
        grid.addColumn(Student::getAge).setHeader("Age");
        grid.addColumn(Student::getGender).setHeader("M/F");
        grid.asSingleSelect().addValueChangeListener(event -> studentForm.setStudent(event.getValue()));

        setAlignItems(Alignment.START);
        add(grid);
        add(studentForm);
        updateList();
    }

    public Grid<Student> getGrid() {
        return grid;
    }

    public void updateList(){
        grid.setItems(studentsService.getAllStudents());
    }
}