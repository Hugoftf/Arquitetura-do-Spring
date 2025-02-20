package com.github.Hugoftf.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository todoRepository;

    public TodoValidator(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public void validar(TodoEntity todoEntity){
        if (existeTodoComEssaDescricao()){
            throw new IllegalArgumentException("Já existe um todo com essa descricção")
        }
    }

    public boolean existeTodoComEssaDescricao(String descricao){
        return todoRepository.existsByDescricao(descricao);
    }

}
