package com.example.demo.Control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

@Controller
public class AdventureXPController {

    public static DatabaseController DBconn = new DatabaseController();

    // NEDENSTÅENDE SLETTES SENERE
    public static void test() throws SQLException {
        String testSqlString = "SELECT * FROM " + DBconn.DBprefix + "Activities";
        ResultSet resultSet = DBconn.dbQuery(testSqlString);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("Activity_Name"));
        }
    }


}
