package com.Agil.EmailSendingApp.Repository;

import com.Agil.EmailSendingApp.Model.Period;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeriodRepo extends JpaRepository<Period,Integer> {
//    List<Period> findAllOrderByIdAsc();
}
