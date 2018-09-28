package com.example.demo.Control;

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

@Controller
public class AdventureXPController {

    public static DatabaseController DBconn = new DatabaseController();
    // Dependence injection
    // Design pattern: Strategy pattern
    @Autowired
    private static ActivityInterface ActivityRepository;

    // NEDENSTÅENDE SLETTES SENERE
    public static void test() throws SQLException {
        String testSqlString = "SELECT * FROM " + DBconn.DBprefix + "Activities";
        ResultSet resultSet = DBconn.dbQuery(testSqlString);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("Activity_Name"));
        }

        // POSTMAPPING {}
        //boolean created = ActivityRepository.OpretAktivitet("lorem ipsum", 18, 10, "big bowl hillerød", LocalDateTime.now(), 9);
    }


}
