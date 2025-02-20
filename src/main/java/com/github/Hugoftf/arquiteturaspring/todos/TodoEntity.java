package com.github.Hugoftf.arquiteturaspring.todos;

import jakarta.persistence.*;

@Entity
@Table(name = "/tb_todo")
public class TodoEntity {




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tb_descricao")
    private String descricao;

    @Column(name = "tb_concluido")
    private Boolean concluido;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
