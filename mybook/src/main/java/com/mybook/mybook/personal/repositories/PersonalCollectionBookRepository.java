package com.mybook.mybook.personal.repositories;

import com.mybook.mybook.personal.domain.PersonalCollectionBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PersonalCollectionBookRepository extends CommonRepository<PersonalCollectionBook> {

    /**
     * 根据用户id查询相应的书籍
     * @param userId
     * @return
     */
    List<PersonalCollectionBook> findAllByUserId(String userId);



}
