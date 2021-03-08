package top.szz.boot.basic.entity;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

//@JsonPropertyOrder(value = {"content","title"})
@ApiModel("书本基本信息")
public class Book {
 //   @JsonIgnore
    @ApiModelProperty("id")
    private Integer id;

   // @JsonProperty("name")
    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("创建时间")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;

    @ApiModelProperty("读者列表")
    private List<BookReader> readers;
}
