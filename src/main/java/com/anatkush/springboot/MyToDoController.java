package com.anatkush.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class MyToDoController {

    @Autowired
    private ToDoService toDoService;

    @RequestMapping("/list")
    public List<ToDo> getAllToDoList(){
        return toDoService.getToDoList();
    }

    @RequestMapping("/list/{id}")
    public ToDo getToDoById(@PathVariable int id){
        return toDoService.getToDoById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/list")
    public void addToDoItem(@RequestBody ToDo toDo){
        toDoService.addToDoItem(toDo);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/list")
    public void updateToDoItem(@RequestBody ToDo toDo){
        toDoService.updateToDoItem(toDo);
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/list/{id}")
    public void deleteToDoById(@PathVariable int id){
        toDoService.deleteToDoById(id);
    }
}
