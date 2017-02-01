package com.heroku.demo.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="data", nullable = false)
    private String data;

    public Journal(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
