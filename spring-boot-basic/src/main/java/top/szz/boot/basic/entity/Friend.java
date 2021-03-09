package top.szz.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 囧态汗
 * @date 2021/3/9
 * @description Friend
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
    private String hobby;
    private String gender;
}
