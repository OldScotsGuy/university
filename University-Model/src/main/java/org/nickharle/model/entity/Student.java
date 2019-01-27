package org.nickharle.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
//@Entity(name = "student")
//@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    //@NotNull(message="Please specify a first name")
    @Column(name = "first_name")
    private String firstName;

    //@NotNull(message="Please specify a first name")
    @Column(name = "last_name")
    private String lastName;

    //@NotNull(message="Please specify an age")
    //@Min(value=0, message="Minimum value is 0")
    //@Max(value=100, message="Maximum value is 100")
    @Column(name = "age")
    private Integer age;

    //@NotNull(message="Please set gender")
    @Column(name = "gender")
    private String gender;

    // Will be used by JPA
    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Student(String firstName, String lastName, Integer age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return firstName + "-" + lastName + "-" + age;
    }
}
