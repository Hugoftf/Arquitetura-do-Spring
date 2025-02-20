package com.github.Hugoftf.arquiteturaspring;

import com.github.Hugoftf.arquiteturaspring.todos.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.swing.text.html.parser.Entity;
import java.sql.Connection;
import java.sql.SQLException;
public class ExemploInjecaoDependencia {
    public static void main(String[] args) throws SQLException  {
        // Criando o Banco de dados para o repositorio
        DriverManagerDataSource dataSource =  new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("username");
        dataSource.setPassword("password");

        // Conectando ao banco de dados, isso pode lança uma SQL Exception, necessita propagar
        Connection connection = dataSource.getConnection();

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager =  null;

        // Veja para eu instanciar a camada de repositorio precisaria disso tudo...
        TodoRepository todoRepository =  null; //new SimpleJpaRepository<TodoEntity, Integer>();

        //Duas clases gerenciada com @Component separadas do MVC
        TodoValidator todoValidator =  new TodoValidator(todoRepository);
        MailSender sender =  new MailSender();

        // Camada @Service, necessita de tudo acima para funcionar
        TodoService todoService =  new TodoService(todoRepository, todoValidator, sender);

         // E por fim a camada Controller, precisaria de tudo acima para instanciar
        TodoController todoController = new TodoController(todoService);



    }
}
