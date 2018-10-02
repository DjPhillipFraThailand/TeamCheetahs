package com.example.demo.Control;

import com.example.demo.Model.Activity;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class AdventureXPController {

    public static DatabaseController DBconn = new DatabaseController();
    // Dependence injection
    // Design pattern: Strategy pattern
    /*@Autowired
    public static ActivityInterface ActivityRepository;*/
    public static ActivityInterface ActivityRepository;
    static { try { ActivityRepository = new ActivityDbRepository(); } catch (SQLException e) { e.printStackTrace(); } }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/Gokart")
    public String gokart(Model model){
        model.addAttribute("activityList", ActivityRepository.readAll());
        return "Gokart";
    }

    @GetMapping("/Create_Activity")
    public String CreateActivity() {
        return "Create_Activity";
    }

    @PostMapping("/new_activity")
    public String New_Activity(@RequestParam("Activity_Name") String Name,
                               @RequestParam("Activity_AgeLimit") int AgeLimit,
                               @RequestParam("Activity_Slots") int Slots,
                               @RequestParam("Activity_Location") String Location,
                               @RequestParam("Activity_DateTime") String DateTime,
                               @RequestParam("Acvitiy_NumOfParticipants") int Participants
    ) throws SQLException {
        ActivityRepository.OpretAktivitet(Name, AgeLimit, Slots, Location, Participants);

        return "redirect:/";
    }

}
