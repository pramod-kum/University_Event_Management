package com.geekster.University.Event.Management.repository;

import com.geekster.University.Event.Management.models.StudentModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentDao extends CrudRepository <StudentModel , Integer> {
    @Modifying
    @Query(value = "update STUDENT_MODEL set STUDENT_DEPARTMENT = :stringDepartment where STUDENT_ID = :id" , nativeQuery = true)
    public void UpdateStudentDepartment(Integer id , String stringDepartment);

}
