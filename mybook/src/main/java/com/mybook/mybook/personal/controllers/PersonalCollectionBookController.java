package com.mybook.mybook.personal.controllers;

import com.mybook.mybook.personal.domain.PersonalCollectionBook;
import com.mybook.mybook.personal.model.PersonalCollectionBookDto;
import com.mybook.mybook.personal.services.PersonalCollectionBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/myBooks")
public class PersonalCollectionBookController extends AbstractBookController {

    private final PersonalCollectionBookService personalCollectionBookService;

    public PersonalCollectionBookController(PersonalCollectionBookService personalCollectionBookService) {
        this.personalCollectionBookService = personalCollectionBookService;
    }


    /**
     * 根据用户id查询书本信息
     */
    @ResponseBody
    @GetMapping("/getMybook")
    public List<PersonalCollectionBookDto> getCollectionBookList(String userId){
        return personalCollectionBookService.findAllByUserId(userId).stream()
                .map(this::toBookDto).collect(Collectors.toList());

    }

    private PersonalCollectionBookDto toBookDto(PersonalCollectionBook personalCollectionBook){
        PersonalCollectionBookDto bookDto = new PersonalCollectionBookDto();
        bookDto.setBookName(personalCollectionBook.getBookName());
        bookDto.setAuthor(personalCollectionBook.getAuthor());
        bookDto.setBookDescription(personalCollectionBook.getBookDescription());
        return bookDto;
    }

    /**
     * 根据作者名查询已收藏的书籍
     */
    public List<PersonalCollectionBookDto> getBookByAuthor(){
        return null;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return null;
    }
}
