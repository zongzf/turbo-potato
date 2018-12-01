package com.mybook.mybook.personal.services;

import com.mybook.mybook.personal.domain.PersonalCollectionBook;
import com.mybook.mybook.personal.repositories.PersonalCollectionBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class PersonalCollectionBookServiceImpl implements PersonalCollectionBookService{

    private final PersonalCollectionBookRepository bookRepository;

    public PersonalCollectionBookServiceImpl(PersonalCollectionBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<PersonalCollectionBook> findAllByUserId(String userId) {
        List<PersonalCollectionBook> list = bookRepository.findAllByUserId(userId) ;
        return list;
    }
}
