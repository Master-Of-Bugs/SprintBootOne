package com.anatkush.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public void deleteToDoById(@PathVariable Long id){
        toDoService.deleteToDoById(id);
    }

    //above is a solution when we initialize and operate with array list
    //below is a solution when we run in runtime a derby database and operate using DB

    @RequestMapping("/listDb")
    public List<ToDo> getAllToDoListDb(){
        return toDoService.getToDoListDb();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/listDb")
    public void addToDoItemDb(@RequestBody ToDo toDo){
        toDoService.addToDoItemDb(toDo);
    }

    @RequestMapping("/listDb/{id}")
    public Optional<ToDo> getToDoByIdDb(@PathVariable Long id){
        return toDoService.getToDoByIdDb(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/listDb")
    public void updateToDoItemDb(@RequestBody ToDo toDo){
        toDoService.updateToDoItemDb(toDo);
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/listDb/{id}")
    public void deleteToDoByIdDb(@PathVariable int id){
        toDoService.deleteToDoByIdDb(id);
    }

}
