package com.heroku.demo;

import com.heroku.demo.database.JournalDatabase;
import com.heroku.demo.model.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class DebugController {
    JournalDatabase database;

    @Autowired
    public DebugController(JournalDatabase database) {
        this.database = database;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Journal> getAll() throws SQLException {
        return database.selectAll();
    }
}