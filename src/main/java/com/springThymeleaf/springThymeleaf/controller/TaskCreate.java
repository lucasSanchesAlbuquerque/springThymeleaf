package com.springThymeleaf.springThymeleaf.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Task;

@Controller
public class TaskCreate {
	
	List<Task> taskList = new ArrayList<>();
	
    @GetMapping("/create")
    public ModelAndView home(){
    	ModelAndView mv = new ModelAndView("create");
    	mv.addObject("task", new Task());
    	return mv;
    }
    
    @PostMapping("/create")
    public String create(Task task) {
    	if(task.getId() != null) {
    		Task taskFind =  taskList.stream().filter(taskItem -> task.getId().equals(taskItem.getId())).findFirst().get();
    		taskList.set(taskList.indexOf(taskFind), task);
    	}else {
    		Long id = taskList.size() + 1L;
        	taskList.add(new Task(id, task.getNome(), task.getDataTask()));
        	System.out.println(taskList.toString());
    	}
    	
    	return "redirect:/list";
    }
    
    @GetMapping("/list")
    public ModelAndView list() {
    	//ModelAndViewmanda para o front
    	ModelAndView mv = new ModelAndView("list");
    	mv.addObject("task", taskList);
    	return mv;
    }
    
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
    	ModelAndView mv = new ModelAndView("create");
    	Task taskFind =  taskList.stream().filter(task -> id.equals(task.getId())).findFirst().get();
    	mv.addObject("task", taskFind);
    	return mv;
    }

    
}
