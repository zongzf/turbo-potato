package com.mybook.mybook.personal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude
public class PersonalCollectionBookDto {

    private String bookName;

    private String author;

    private String bookDescription;

}
