package org.nickharle.ui.commons;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import org.nickharle.model.entity.Student;
import org.nickharle.service.students.AddStudentServiceImpl;
import org.nickharle.service.students.RemoveStudentServiceImpl;
import org.nickharle.ui.students.StudentLayoutFactory;
import org.nickharle.utils.Gender;

import java.util.Objects;

public class StudentForm extends FormLayout {

    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private TextField age = new TextField("Age");
    private ComboBox<Gender> gender = new ComboBox<>("Gender");
    private Binder<Student> binder = new Binder<>(Student.class);

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    private Student student;

    private StudentLayoutFactory studentLayoutFactory;
    private RemoveStudentServiceImpl removeStudentService;
    private AddStudentServiceImpl addStudentService;

    public StudentForm(StudentLayoutFactory studentLayoutFactory,
                       RemoveStudentServiceImpl removeStudentService,
                       AddStudentServiceImpl addStudentService) {

        this.studentLayoutFactory= studentLayoutFactory;
        this.removeStudentService = removeStudentService;
        this.addStudentService = addStudentService;

        // Populate the CombooBox
        gender.setItems(Gender.values());

        // Bind the similarly named member fields in this class to those in the Customer class
        binder.bind(firstName, Student::getFirstName, Student::setFirstName);
        binder.bind(lastName, Student::getLastName, Student::setLastName);
        // Use forField to handle type conversion from Textfield String to required Integer in Student object
        //binder.forField(age).withConverter(Integer::valueOf, String::valueOf, "Input value should be an integer")
        //                    .bind(Student::getAge, Student::setAge);

        // On the setBean call the first action is that the student object into the Form fields. However TextField and ComboBox cannot handle null values
        binder.forField(age).bind( student -> student.getAge() != null ? Integer.toString(student.getAge()) : "", (student, formValue) -> student.setAge(Integer.valueOf(formValue)) );

        binder.forField(gender).withConverter(gender -> gender.getString().equals("male") ? "male" : "female", gender -> gender.equals(Gender.MALE.getString()) ? Gender.MALE : Gender.FEMALE)
                               .bind(Student::getGender, Student::setGender);

        //binder.bindInstanceFields(this);      // Possible if 1) all Textfield and Student member variable match, 2) no type conversion, 3) no validation

        // Add button style and functionality
        save.getElement().setAttribute("theme","primary");
        save.addClickListener(e -> this.save());
        delete.addClickListener(e -> this.delete());

        Button addStudentButton = new Button("Add New Student");
        addStudentButton.addClickListener(e -> {
            studentLayoutFactory.getGrid().asSingleSelect().clear();
            setStudent(new Student("","","male"));
        });

        HorizontalLayout buttons = new HorizontalLayout(save, delete, addStudentButton);
        add(firstName, lastName, age, gender, buttons);
        setStudent(null);
    }

    public void setStudent(Student student) {
        this.student = student;
        // Initialise all fields in the form and will automatically update the related student object
        // PrototypeId annotation on the FormLayout member field can also be used to denote which field in the Student object
        // the form field should be bound to. e.g. @Property("lastname") applied in this class
        //binder.setBean(student);
        boolean enabled = (student != null);
        save.setEnabled(enabled);
        delete.setEnabled(enabled);
        if (enabled) {
            firstName.focus();
            binder.setBean(student);
        }
    }
    private void delete() {
        removeStudentService.removeStudent(student);
        studentLayoutFactory.updateList();
        setStudent(null);
        clearForm();
    }

    private void save() {
        addStudentService.saveStudent(student);
        studentLayoutFactory.updateList();
        setStudent(null);
        clearForm();
    }

    private void clearForm() {
        firstName.setValue("");
        lastName.setValue("");
        age.setValue("");
        gender.setValue(Gender.MALE);
    }
}
