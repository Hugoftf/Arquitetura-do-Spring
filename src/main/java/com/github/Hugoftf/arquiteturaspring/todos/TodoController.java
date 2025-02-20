package com.github.Hugoftf.arquiteturaspring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todoEntity) {
        try{

        }catch (IllegalArgumentException e){
            var error = e.getMessage();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return this.todoService.salvar(todoEntity);
    }

    @PutMapping("{id}")
    public void atualizarStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todoEntity) {
        todoEntity.setId(id);
        todoService.salvar(todoEntity);
    }

    @GetMapping("{id}")
    public TodoEntity buscarPorID(@PathVariable("id") Integer id){
        return todoService.buscarPorId(id);
    }

}
