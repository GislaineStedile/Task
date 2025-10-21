package com.app.controller;

import com.app.model.Task;
import com.app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Task task){
        try{
            String mensagem = this.service.save(task);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<String>("Algo deu ERRADO!",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id){
        try{
            Task mensagem = this.service.findById(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Task>> findAll(){
        try{
            List<Task> menssegen = this.service.findAll();
            return new ResponseEntity<List<Task>>(menssegen, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id){
        try{
            String mensagem = this.service.update(id);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<String>("Algo deu ERRADO!",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try{
            String mensagem = this.service.delete(id);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<String>("Algo deu ERRADO!",HttpStatus.BAD_REQUEST);
        }
    }
}
