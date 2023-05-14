package com.tpe.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_student")
@Getter// add getter method
@Setter//add setter method
@AllArgsConstructor// add cons with parma.
@NoArgsConstructor//it is like default constructor
//@RequiredArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)//this field cannot set .
    private Long id;

//    @Getter
//    @Setter // this will only generate for this filed
    @NotNull(message = "name can not be null")
    @NotBlank(message = "name can not be white space ..")//
    @Size(min = 3,max = 25 , message = "First name '${validateValue}' must be between {min} and {max}")
    @Column(nullable = false ,length = 25)
    private /*final */ String name;

    @Column(nullable = false, length = 25)
    private /*final */ String lastName;

    private /*final */ Integer grade;

    @Column(nullable = false,length = 50,unique = true)
    @Email(message = "Please provided valid email")// it will check "@" and "."////fathi1234@.com
    private /*final */ String email;

    private /*final */ String phoneNumber;

    @Setter(AccessLevel.NONE)
    private  LocalDateTime createDate= LocalDateTime.now();
    @OneToMany(mappedBy = "student")
    private List<Book> books = new ArrayList<>();



}
