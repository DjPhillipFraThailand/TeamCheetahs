package com.example.demo.Control;

import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.text.ParseException;

@Controller
public class AdventureXPController {

    public static DatabaseController DBconn = new DatabaseController();
    // Dependence injection
    // Design pattern: Strategy pattern
    @Autowired
    public static ActivityInterface ActivityRepository;
    static { try { ActivityRepository = new ActivityDbRepository(); } catch (SQLException e) { e.printStackTrace(); } }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("activityList", ActivityRepository.readAll());
        return "index";
    }

    @GetMapping("/Read_Activity")
    public String Read_Activity(@RequestParam("ActivityID") int ActivityID, Model model) {
        model.addAttribute("Activity", ActivityRepository.LæsAktivitet(ActivityID-1));
        return "Read_Activity";
    }

    @GetMapping("/Edit_Activity")
    public String Edit_Activity(@RequestParam("ActivityID") int ActivityID, Model model) {
        model.addAttribute("Activity", ActivityRepository.LæsAktivitet(ActivityID-1));
        return "Edit_Activity";
    }

    @GetMapping("/Create_Activity")
    public String CreateActivity() {
        return "Create_Activity";
    }

    //Date datestamp = new SimpleDateFormat("yyyy-mm-dd").parse(DateTime);
    //Date datestamp = new java.sql.Date(new Date().getTime());
    @PostMapping("/new_activity")
    public String New_Activity(@RequestParam("Activity_Name") String Name,
                               @RequestParam("Activity_AgeLimit") int AgeLimit,
                               @RequestParam("Activity_Slots") int Slots,
                               @RequestParam("Activity_Location") String Location
    ) throws SQLException, ParseException {
        ActivityRepository.OpretAktivitet(Name, AgeLimit, Slots, Location);

        return "redirect:/";
    }

   @PostMapping("/edit_activity")
   public String Edit_Activity(@RequestParam("act_id") int ActivityID,
                                @RequestParam("Activity_Name") String name,
                               @RequestParam("Activity_AgeLimit") int AgeLimit,
                               @RequestParam("Activity_Slots") int Slots,
                               @RequestParam("Activity_Location") String Location
   ) throws SQLException {
        ActivityRepository.RedigerAktivitet(ActivityID, name, AgeLimit, Slots, Location);
       return "Read_Activity?ActivityID="+ActivityID;
   }

}
