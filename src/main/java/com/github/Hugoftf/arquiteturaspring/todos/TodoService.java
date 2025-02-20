package com.github.Hugoftf.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository todoRepository;
    private TodoValidator todoValidator;
    private MailSender mailSender;

    public TodoService(TodoRepository todoRepository, TodoValidator todoValidator, MailSender mailSender) {
        this.todoRepository = todoRepository;
        this.todoValidator = todoValidator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity todoEntity){
       todoValidator.validar(todoEntity);

        return todoRepository.save(todoEntity);
    }

    public TodoEntity autalizar(TodoEntity todoEntity){
        String status = todoEntity.getConcluido() == Boolean.TRUE ? "Concluido":"Não concluido";

        mailSender.enviar("Todo " + todoEntity.getDescricao() + " foi " +  status);
        return todoRepository.save(todoEntity);
    }

    public TodoEntity buscarPorId(Integer id){
        return todoRepository.findById(id).orElse(null);
    }
}
