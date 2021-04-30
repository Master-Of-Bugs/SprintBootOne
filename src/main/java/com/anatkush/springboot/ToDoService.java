package com.anatkush.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    ToDoRepository toDoRepository;

    private List<ToDo> toDoList = new ArrayList<>(Arrays.asList(
            new ToDo(1l, "my first task", "05-05-2021"),
                new ToDo(2l, "my second task", "06-06-2021"),
                new ToDo(3l, "my third task", "07-07-2021"),
                new ToDo(4l, "my fourth task", "08-08-2021")
        ));

    public List<ToDo> getToDoList(){
        return toDoList;
    }

    public ToDo getToDoById(long id){
        for (ToDo item : toDoList) {
            if(item.getId() == id){
                return item;
            }
        }
        return new ToDo(0l, "not found id", "0000-00-00");
    }

    public void addToDoItem(ToDo toDo) {
        toDoList.add(toDo);
    }

    public void updateToDoItem(ToDo toDo) {
        for (ToDo item : toDoList) {
            if(item.getId() == toDo.getId()){
                item.setDueDate(toDo.getDueDate());
                item.setTitle(toDo.getTitle());
            }else{
                System.out.println("no any item was found");
            }
        }
    }

    public void deleteToDoById(int id) {
        for (ToDo item : toDoList) {
            if(item.getId() == id){
                toDoList.remove(item);
                break;
            }
        }
        System.out.println("no any item was found");
    }
}
