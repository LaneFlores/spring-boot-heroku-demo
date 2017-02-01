package com.heroku.demo;

import javax.validation.Valid;
import java.util.List;

import com.heroku.demo.model.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    private JournalRepository repository;

    @Autowired
    public HomeController(JournalRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) {
        List<Journal> journalEntries = repository.findAll();
        model.addAttribute("journalEntries", journalEntries);
        model.addAttribute("insertRecord", new Journal(1234, "testJournal"));
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insertData(ModelMap model, 
                             @ModelAttribute("insertRecord") @Valid Journal journal,
                             BindingResult result) {
        if (!result.hasErrors()) {
            repository.save(journal);
        }
        return home(model);
    }
}
