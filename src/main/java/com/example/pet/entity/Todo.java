package com.example.pet.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtodo")
    private Long idTodo;
    @Column(name = "title")
    private String title;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "iduser",nullable = false)
    private User user;
    @Column(name = "checked")
    private Boolean checked;

    public Todo() {
    }

    public Todo(String title, User user, Boolean checked) {
        this.title = title;
        this.user = user;
        this.checked = checked;
    }

    public Long getIdTodo() {
        return idTodo;
    }

    public void setIdTodo(Long idTodo) {
        this.idTodo = idTodo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "iduser")

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
