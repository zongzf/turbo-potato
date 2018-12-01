package com.mybook.mybook.personal.domain;


import lombok.Data;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Data
public class PersonalCollectionBook extends CommonEntity {


    @Column(nullable = false)
    private String bookId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)
    private String author;

    private String bookDescription;



}
