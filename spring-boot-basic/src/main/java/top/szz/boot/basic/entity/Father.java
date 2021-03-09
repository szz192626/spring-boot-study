package top.szz.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 囧态汗
 * @date 2021/3/9
 * @description Father
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Father {
    @Value("${family.father.name}")
    private String name;
    @Value("${family.father.age}")
    private Integer age;
}
