package top.szz.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 囧态汗
 * @date 2021/3/11
 * @description Student
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
     private Integer id;
     private String name;
}
