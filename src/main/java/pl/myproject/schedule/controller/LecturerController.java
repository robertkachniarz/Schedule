package pl.myproject.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.myproject.schedule.model.Lecturer;
import pl.myproject.schedule.service.LecturerService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RestController
public class LecturerController {
    @Autowired
    LecturerService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public  ModelAndView homepage(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/formlecturer", method = RequestMethod.POST)
    public ModelAndView formLecturer(ModelAndView modelAndView, Lecturer lecturer){
        modelAndView.addObject("lecturer", lecturer);
        modelAndView.setViewName("addlecturer");
        return modelAndView;
    }

    @RequestMapping(value = "/listlecturers", method = RequestMethod.POST)
    public ModelAndView listlecturers(ModelAndView modelAndView){
        modelAndView.setViewName("list");
        modelAndView.addObject("lecturerList", service.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/addlecturer", method = RequestMethod.POST)
    public ModelAndView addLecturer(ModelAndView modelAndView, @Valid Lecturer lecturer, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        service.saveLecturer(lecturer);
        modelAndView.addObject("lecturerList", service.findAll());
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ModelAndView deleteLecturer(ModelAndView modelAndView, @PathVariable("id") Long id){
        service.deleteLecturerById(id);
        modelAndView.addObject("lecturerList", service.findAll());
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView updateLecturer(ModelAndView modelAndView, @PathVariable("id") Long id){
        modelAndView.addObject("lecturer", service.findLecturerById(id));
        modelAndView.setViewName("updatelecturer");
        return modelAndView;
    }

    @RequestMapping(value = "/updatelecturer/{id}", method = RequestMethod.POST)
    public ModelAndView update(ModelAndView modelAndView, @PathVariable("id") Long id, @Valid Lecturer lecturer){
        service.deleteLecturerById(id);
        service.saveLecturer(lecturer);
        modelAndView.addObject("lecturerList", service.findAll());
        modelAndView.setViewName("list");
        return modelAndView;
    }

}
