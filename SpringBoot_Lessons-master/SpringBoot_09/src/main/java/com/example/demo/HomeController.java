package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    // Creates an instance of JobRepository
    @Autowired
    JobRepository jobRepository;

    @RequestMapping("/") //parent of @GetMapping and @PostMapping
    public String listJobs(Model model) {
        // jobRepository.findAll() finds all "jobs" objects and returns it as a list
        model.addAttribute("jobs", jobRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    // Can be rewritten as: @RequestMapping(value={"/add", "/addform","/newform"}, method={RequestMethod.GET,
    // RequestMethod.POST})
    // In this /add page, look for the reference "job" in the jobform.html page and create a new Job object
    // This reference will tell the controller what data it should be associated with
    public String jobForm(Model model) {
        model.addAttribute("job", new Job());
        return "jobform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Job job, BindingResult result) {
        if(result.hasErrors()) {
            return "jobform";
        }
        jobRepository.save(job);
        // Redirects to the homepage "/" path which pulls up all jobs added
        return "redirect:/";
    }
}
