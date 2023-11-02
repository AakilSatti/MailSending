package com.Agil.EmailSendingApp.Controller;

import com.Agil.EmailSendingApp.DTO.DisplayDTO;
import com.Agil.EmailSendingApp.DTO.PeriodDTO;
import com.Agil.EmailSendingApp.DTO.UpdateDTO;
import com.Agil.EmailSendingApp.Model.Period;
import com.Agil.EmailSendingApp.Model.Teacher;
import com.Agil.EmailSendingApp.Repository.PeriodRepo;
import com.Agil.EmailSendingApp.Repository.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {
    @Autowired
    private JavaMailSender mailSender;
    private final TeacherRepo teacherRepo;
    private final PeriodRepo periodRepo;

    @PostMapping("/get/{email}")
    public String send(@PathVariable String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("Class starting within 5 minutes");
        simpleMailMessage.setText("Your next class is CSE 3rd year");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("kit.24.20bcs006@gmail.com");
        mailSender.send(simpleMailMessage);
        System.out.println("Sent");
        return "Done";
    }
    @PostMapping("/save/teacher")
    public String add(@RequestBody Teacher teacher) {
        teacherRepo.save(teacher);
        return "success";
    }



    @GetMapping("/getValue")
    public List<Teacher> getValue() {
        return teacherRepo.findAll();
    }

    @PostMapping("/timetable_colum")
    public String gettable(@RequestBody PeriodDTO periodDTO) {
        Teacher teacher = teacherRepo.findByEmail(periodDTO.getEmail());
        if(teacher==null) return "Teacher Not Found";
        Period period = new Period();
        period.setId(periodDTO.getId());
        System.out.println(periodDTO.getId());
        period.setName(periodDTO.getName());
        period.setTeacher(teacher);
        periodRepo.save(period);
        return "successfully added";
    }

        @GetMapping("/getValue2")
        public List<DisplayDTO> getValue2() {
            List<Period> li= periodRepo.findAll();
            List<DisplayDTO> finalResult = new ArrayList<>();
        for(Period i : li){
            DisplayDTO displayDTO = new DisplayDTO();
            displayDTO.setId(i.getId());
            displayDTO.setName(i.getName());
            displayDTO.setStaffEmail(i.getTeacher().getEmail());
            displayDTO.setStaffName(i.getTeacher().getName());
            displayDTO.setSubject(i.getTeacher().getSubject());
            finalResult.add(displayDTO);
        }
            Collections.sort(finalResult, Comparator.comparing(DisplayDTO::getId));

            return finalResult;
    }
    @PutMapping("/update")
    private String update_data(@RequestBody UpdateDTO updateDTO){
        PeriodDTO periodDTO = new PeriodDTO();
        Teacher teacher = teacherRepo.findByEmail(updateDTO.getEmail());
        Period period = periodRepo.findById(updateDTO.getId()).get();
        period.setTeacher(teacher);
        period.setName(teacher.getName());
        System.out.println(teacher.getName());
        periodRepo.save(period);
        return "changed";
    }
}
