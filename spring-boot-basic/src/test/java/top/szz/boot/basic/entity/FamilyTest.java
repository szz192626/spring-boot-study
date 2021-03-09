package top.szz.boot.basic.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class FamilyTest {
    @Resource
    private Family family;

    @Test
    void testFamily(){
        log.info("family: " + family);
    }

//    @Test
//    void getFamilyName() {
//        log.info(String.valueOf(family));
////断言
//    String familyName = family.getFamilyName();
//    assertEquals("happy family",familyName);
//    }

//    @Test
//    void  getFather(){
//        log.info(String.valueOf(father));
//        String fatherName = father.getName();
//        assertEquals("tom",fatherName);

//    }
//    @Test
//    void getMother(){
//        log.info(String.valueOf(mother));
//        String[] mother1 = mother.getAlias().toArray(new String[0]);
//        assertEquals({},mother1);
//    }
//    @Test
//    void getChild(){
//        log.info(String.valueOf(child));
//        String childName = child.getName();
//
//    }

}