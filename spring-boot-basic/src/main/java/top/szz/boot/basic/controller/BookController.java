package top.szz.boot.basic.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.szz.boot.basic.controller.dto.AjaxResponse;
import top.szz.boot.basic.controller.dto.Param;
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
@Api(tags = "书管理接口")
public class BookController {

    @ApiOperation("获取全部书本")
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
    @ApiOperation("URL传参，根据id获取书本")
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
    @ApiOperation("增加书本")
    @PostMapping()
    public AjaxResponse saveBook(@RequestBody Book book){
        log.info("saveBook:" + book);
        return AjaxResponse.success(book);
    }

//    @PutMapping()
//    public AjaxResponse updateBook(@RequestParam int id,@RequestParam String title){
//        Book book = Book.builder()
//                .id(111)
//                .author("szz")
//                .title("Java")
//                .content("Java")
//                .createdTime(new Date())
//                .build();
//        log.info("book:" + book);
//
//        book.setId(id);
//        book.setTitle(title);
//
//        log.info("book:" + book);
//        return AjaxResponse.success(book);
//    }
    @ApiOperation("修改书本")
    @PutMapping()
    public AjaxResponse updateBook(@RequestBody Book book){
        Book book1 = Book.builder()
                .id(111)
                .author("szz")
                .title("Java")
                .content("Java")
                .createdTime(new Date())
                .build();
        log.info("book:" + book1);

        book1.setId(book.getId());
        book1.setTitle(book.getTitle());

        log.info("book:" + book1);
        return AjaxResponse.success(book1);
    }

//    @DeleteMapping("{id}")
//    public AjaxResponse deleteBook(@PathVariable int id){
//        log.info("id:"+id);
//        return AjaxResponse.success();
//    }


//    @DeleteMapping()
//    public AjaxResponse deleteBook(@RequestParam(value = "id",defaultValue = "111")int idd,@RequestParam("title")String ti){
//        log.info("id:" + idd);
//        log.info("title:"+ti);
//        return AjaxResponse.success();
//    }
//

//       @DeleteMapping()
//       public AjaxResponse deleteBook(int id,String title){
//          log.info("id:" + id);
//          log.info("title:"+title);
//          return AjaxResponse.success();
//    }

//        @DeleteMapping()
//        public AjaxResponse deleteBook(@RequestParam("id") int idd,@RequestParam("title") String ti){
//            log.info("id:" + idd);
//            log.info("title:"+ti);
//            return AjaxResponse.success();
//}

    @ApiOperation("删除书本")
    @DeleteMapping()
    public AjaxResponse deleteBook(@RequestBody Param param){
        log.info("id:" + param.getId());
        log.info("title:"+param.getTitle());
        return AjaxResponse.success(param);
    }

}
