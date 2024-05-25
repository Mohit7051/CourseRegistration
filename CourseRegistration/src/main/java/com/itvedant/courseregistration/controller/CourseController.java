package com.itvedant.courseregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itvedant.courseregistration.entity.Course;
import com.itvedant.courseregistration.service.CourseService;


@Controller
public class CourseController {
    
     @Autowired
        private CourseService service;

        @GetMapping("/")
        public String viewHomePage(Model model) {
            List<Course> liststudent = service.listAll();
            model.addAttribute("liststudent", liststudent);
            System.out.print("Get / ");    
            return "index";
        }

        @GetMapping("/new")
        public String add(Model model) {
            model.addAttribute("student", new Course());
            return "new";
        }

        @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String saveStudent(@ModelAttribute("student") Course std) {
            service.save(std);
            return "redirect:/";
        }

        @RequestMapping("/edit/{id}")
        public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
            ModelAndView mav = new ModelAndView("new");
            Course std = service.get(id);
            mav.addObject("student", std);
            return mav;
            
        }
        @RequestMapping("/delete/{id}")
        public String deletestudent(@PathVariable(name = "id") int id) {
            service.delete(id);
            return "redirect:/";
        }
}

