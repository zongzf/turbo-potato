package com.mybook.mybook.personal.services;

import com.mybook.mybook.personal.domain.PersonalCollectionBook;
import com.mybook.mybook.personal.model.PersonalCollectionBookDto;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface PersonalCollectionBookService {

    /**
     * 根据用户id查询该用户所收藏的所有书籍信息
     */
    List<PersonalCollectionBook> findAllByUserId(String userId);

}
