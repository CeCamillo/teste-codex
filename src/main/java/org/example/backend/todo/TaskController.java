package org.example.backend.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @PostMapping
    public void createTask(@RequestBody Task task) {
        repository.save(task);
    }

    @ResponseBody
    @GetMapping
    public List<Task> getAll() {
        List<Task> taskList = repository.findAll();
        return taskList;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTask(@PathVariable long id) {
        repository.deleteById(id);
    }

}
