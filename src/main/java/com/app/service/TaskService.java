package com.app.service;

import com.app.model.Task;
import com.app.reporsitory.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public String save(Task task){
        this.repository.save(task);
        return "Salvo!";
    }
    public Task findById(Long id){
        Optional<Task> task = Optional.ofNullable(this.repository.findById(id).orElse(null));
        return task.get();
    }
    public List<Task> findAll(){
        return this.repository.findAll();
    }

    public String update(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if(optionalTask.isPresent()){
            Task task = optionalTask.get();
            task.setCompleted(true);
            this.repository.save(task);
        }
        return "Atualizado!";
    }
    public String delete(Long id){
        this.repository.deleteById(id);
        return "Deletado!";
    }
}
