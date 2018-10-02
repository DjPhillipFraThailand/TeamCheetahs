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

    // NEDENSTÅENDE SLETTES SENERE
    public static void test() throws SQLException {
        // POSTMAPPING {}
        int ageLimit = 18;
        int slots = 10;
        int participants = 9;
        ActivityRepository.OpretAktivitet("lorem ipsum", ageLimit, slots, "big bowl hillerød", participants);
        System.out.println(ActivityRepository.getActivityListSize());
    }


}
