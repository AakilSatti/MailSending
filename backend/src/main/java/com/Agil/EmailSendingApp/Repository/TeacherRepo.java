package com.Agil.EmailSendingApp.Repository;

import com.Agil.EmailSendingApp.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {
    Teacher findByEmail(String email);
}
