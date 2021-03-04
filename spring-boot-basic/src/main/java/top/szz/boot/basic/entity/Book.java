package top.szz.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author 囧态汗
 * @date 2021/3/4
 * @description Book
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    private String author;
    private String title;
    private String content;
    private Date createdTime;
    private List<BookReader> readers;
}
