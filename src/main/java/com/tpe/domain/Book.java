package com.tpe.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("bookName") //this name is used for json data
    //@Column(name= "book_name") //this is for column name in table
    private String name;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore()  //to ignore infinite calling
    private Student student;

    //getter


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Student getStudent() {
        return student;
    }
}
