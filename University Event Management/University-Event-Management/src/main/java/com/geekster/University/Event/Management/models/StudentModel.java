package com.geekster.University.Event.Management.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class StudentModel {
    @Column(name = "student_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    //  @Column(name = "student_first_name" , unique = true)
    //  @Pattern(regexp = "[A-Za-z]")
    private String firstName;
    @Column(name = "student_last_name")
    private String lastName;

    @Column(name = "student_age")
    @Min(value = 18 , message = "Age value should be Minimum 18 and Maximum 24")
    @Max(value = 25 , message = "Age value should be Minimum 18 and Maximum 24")
    private Integer age;
    @Column(name = "student_department")
    @Enumerated(EnumType.STRING)
    private EnumDepartment department;
}
