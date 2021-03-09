package top.szz.boot.basic.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.szz.boot.basic.controller.dto.AjaxResponse;
import top.szz.boot.basic.controller.dto.Param;
import top.szz.boot.basic.entity.Book;
import top.szz.boot.basic.entity.BookReader;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;


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
    public AjaxResponse selectBooks() {
        BookReader[] readers = {
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
        Book[] books = {book1, book2};
        List<Book> bookList = Arrays.asList(books);
        return AjaxResponse.success(bookList);
    }

    @ApiOperation("URL传参，根据id获取书本")
    @GetMapping("{id}")
    public AjaxResponse getBook(@PathVariable int id) {
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
    @PostMapping("post")
    public AjaxResponse saveBook(@RequestBody Book book) {
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
    @PutMapping("put")
    public AjaxResponse updateBook(@RequestBody Book book) {
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

    @ApiOperation("删除书本")
    @DeleteMapping()
    public AjaxResponse deleteBook(@RequestParam(value = "id",defaultValue = "111")int idd,@RequestParam("title")String ti){
        log.info("id:" + idd);
        log.info("title:"+ti);
        return AjaxResponse.success();
    }


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

//    @ApiOperation("删除书本")
//    @DeleteMapping("delete")
//    public AjaxResponse deleteBook(@RequestBody Param param) {
//        log.info("id:" + param.getId());
//        log.info("title:" + param.getTitle());
//        return AjaxResponse.success(param);
//    }

    @PostMapping("upload")
    public AjaxResponse handleUpload(MultipartFile file, HttpServletRequest request) {
        //创建文件在服务器的存放路径
        String path = request.getServletContext().getRealPath("/upload");
        log.info(path);
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            boolean flag = fileDir.mkdirs();
            //log.info(String.valueOf(flag));
            log.info("flag:" + flag);
        }
        //生成文件在服务器的名称的前缀
        String prefixName = UUID.randomUUID().toString();
        //取得源文件的敏子
        String originalFilename = file.getOriginalFilename();
        //从源文件名中分离出扩展名（后缀） 111.jpg-->.jpg
        assert originalFilename != null;
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //拼接新的文件名
        String fileName = prefixName + suffixName;
        log.info(fileName);
        //创建上传的文件对象
        File saveFile = new File(path + "/" + fileName);
        //上传
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
            log.info(e.getMessage());
            AjaxResponse.failure("文件上传失败");
        }
        return AjaxResponse.success(fileName);

    }

    @PostMapping(value = "Files")
    public AjaxResponse sourceUpload(MultipartFile[] Files, HttpServletRequest request) {
        List fileNames = new ArrayList();
        YearMonth yearMonth = YearMonth.now();
        Calendar now = Calendar.getInstance();
        for(MultipartFile file :Files) {
            if(file.isEmpty()) {
                System.out.println("文件为空");
            }

            //文件重命名
            String prefixName = UUID.randomUUID().toString();
            //获取文件后缀名
            String originalFilename = file.getOriginalFilename();
            //
            assert originalFilename != null;
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
            //拼接新的文件名
            String newFileName = prefixName + suffixName;
            log.info(newFileName);
            //上传文件
            String ym = yearMonth.format(DateTimeFormatter.ofPattern("yyyy-MM"));
            int day = now.get(Calendar.DAY_OF_MONTH);
            String path = request.getServletContext().getRealPath("img/"+ym+"/"+ day + "/" + suffixName);
            log.info(path);
            File fileDir = new File(path);
            if (!fileDir.exists()){
                boolean flag = fileDir.mkdirs();
                log.info("flag:"+flag);
            }
            //创建上传文件对象
            File saveFile = new File(path + "/" + newFileName);
            try {
                file.transferTo(saveFile);
            } catch (IOException e) {
                e.printStackTrace();
                log.info(e.getMessage());
                AjaxResponse.failure("文件上传失败");
            }
            fileNames.add(newFileName);
            log.info(fileNames.toString());
        }
        return AjaxResponse.success("上传成功");
    }
}



