package com.example.demo.Control;

import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.java2d.pipe.SpanShapeRenderer;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Integer.parseInt;

@Controller
public class AdventureXPController {

    public static DatabaseController DBconn = new DatabaseController();
    // Dependence injection
    // Design pattern: Strategy pattern
    @Autowired
    public static ReservationInterface ReservationRepository;
    static { try { ReservationRepository = new ReservationDbRepository(); } catch (SQLException e) { e.printStackTrace(); } }
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
        model.addAttribute("Reservations", ReservationRepository.getReservations(ActivityID));
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

    @GetMapping("/New_Reservation")
    public String CreateReservation(@RequestParam("ActivityID") int ActivityID, Model model) {
        model.addAttribute("ActivityID", ActivityID);
        return "New_Reservation";
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

    @PostMapping("/new_reservation")
    public String New_Reservation(@RequestParam("Reservation_Name") String Name,
                                  @RequestParam("Reservation_Phone") String Phone,
                                  @RequestParam("Reservation_Amount") int Amount,
                                  @RequestParam("Reservation_Date") String Date,
                                  @RequestParam("Reservation_Time") String Time,
                                  @RequestParam("Activity_ID") String ActivityID
    ) throws SQLException, ParseException {
        Date Datestamp = new SimpleDateFormat("yyyy-MM-dd").parse(Date);
        ReservationRepository.OpretReservation(Name, Phone, Datestamp, Time, Amount, parseInt(ActivityID));
        return "redirect:/Read_Activity?ActivityID="+ActivityID;
    }

   @PostMapping("/edit_activity")
   public String Edit_Activity(@RequestParam("act_id") int ActivityID,
                                @RequestParam("Activity_Name") String name,
                               @RequestParam("Activity_AgeLimit") int AgeLimit,
                               @RequestParam("Activity_Slots") int Slots,
                               @RequestParam("Activity_Location") String Location
   ) throws SQLException {
        ActivityRepository.RedigerAktivitet(ActivityID, name, AgeLimit, Slots, Location);
       return "redirect:/Read_Activity?ActivityID="+ActivityID;
   }

}
