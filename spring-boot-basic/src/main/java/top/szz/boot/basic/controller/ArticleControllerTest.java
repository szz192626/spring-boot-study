package top.szz.boot.basic.controller;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import top.szz.boot.basic.controller.dto.AjaxResponse;
import top.szz.boot.basic.entity.Article;

import java.util.Date;

/**
 * @author 囧态汗
 * @date 2021/3/6
 * @description ArticleControllerTest
 */
@RestController
@RequestMapping(value = "/api/v1/Articles")
@Slf4j
public class ArticleControllerTest {
   @PostMapping("body")
    public AjaxResponse saveArticle(@RequestBody Article article){
       log.info("saveArticle:" + article);
       return AjaxResponse.success(article);
   }

   @PostMapping("param")
    public AjaxResponse saveArticle(
           @RequestParam(value = "id",defaultValue =
            "111",required = false) int id,
           @RequestParam(value = "author",defaultValue =
            "szz",required = false) String author,
           @RequestParam String title,
           @RequestParam String content,
           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
           @RequestParam(value = "createTime",
                   defaultValue = "2021-03-06 12:12:12",required = false) Date
           createTime) {
                Article article =Article.builder()
                        .id(id)
                        .title(title)
                        .content(content)
                        .author(author)
                        .createdTime(createTime)
                        .build();
                log.info("saveArticle:"+article);
                return AjaxResponse.success(article);
       }


    @PostMapping("form")
    public AjaxResponse saveArticByFormData(@RequestParam("formData")String
        formData){
      //表单传递的数据为字符串
        log.info("formData:" + formData);
        //用Jackson的反序列化将字符串转为Java对象
        ObjectMapper objectMapper = new ObjectMapper();
        Article article =null;
        try {
            article = objectMapper.readValue(formData,Article.class);
            log.info("article:" + article);
            } catch (
                    JsonProcessingException e) {
                e.printStackTrace();
            }
            return AjaxResponse.success(article);
        }

    }




