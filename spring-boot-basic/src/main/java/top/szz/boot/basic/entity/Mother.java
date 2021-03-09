package top.szz.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 囧态汗
 * @date 2021/3/9
 * @description Mother
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "family.mother")
@Component
public class Mother {
   // @Value("#{'${family.mother.alias:}'.split(',')}")
    //private String[] alias;
    private String name;
    private List<String> alias;
}
