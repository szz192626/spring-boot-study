package top.szz.boot.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.szz.boot.basic.controller.dto.AjaxResponse;
import top.szz.boot.basic.entity.Book;
import top.szz.boot.basic.entity.BookReader;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * @author 囧态汗
 * @date 2021/3/4
 * @description BookController
 */
@RestController
@RequestMapping(value = "/api/v1/books")
@Slf4j
public class BookController {

    @GetMapping("all")
    public AjaxResponse selectBooks(){
        BookReader[] readers ={
                BookReader.builder()
                .name("aaa")
                .age(20)
                .build(),
                BookReader.builder()
                .name("bbb")
                .age(19)
                .build(),

        };
        List<BookReader> readerList = Arrays.asList(readers);
        Book book1 = Book.builder()
                .id(123)
                .author("szz")
                .title("SpringBoot")
                .content("SpringBoot从入门到精通")
                .createdTime(new Date())
                .readers(readerList)
                .build();

        Book book2 = Book.builder()
                .id(456)
                .author("szz")
                .title("Vue.js")
                .content("Vue.js从入门到精通")
                .createdTime(new Date())
                .readers(readerList)
                .build();
        Book[] books = {book1,book2};
        List<Book> bookList =Arrays.asList(books);
        return AjaxResponse.success(bookList);
    }

    @GetMapping("{id}")
    public AjaxResponse getBook(@PathVariable int id){
        Book book = Book.builder()
                .id(id)
                .author("szz")
                .title("Java")
                .content("Java")
                .createdTime(new Date())
                .build();
        return AjaxResponse.success(book);
    }
}
