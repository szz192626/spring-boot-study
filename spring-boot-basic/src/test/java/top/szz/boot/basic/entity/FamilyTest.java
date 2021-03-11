package top.szz.boot.basic.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        log.info("father:" + family.getFather());
        log.info("mother:" + family.getMother());
        log.info("child" + family.getChild());

        Father father = Father.builder().name("tom").age(30).build();
        String[] alias = new String[]{"lovely","alice"};
        Mother mother = Mother.builder().name("Sam").alias(Arrays.asList(alias)).build();
        Friend[] friends = {Friend.builder().hobby("football").gender("male").build(),Friend.builder().hobby("sing").gender("female").build()};
        List<Friend> friendList = Arrays.asList(friends);
//        Child child = Child.builder().name("jack").age(6).friends(friendList).build();
        Child child = Child.builder().name("jack").age(5).friends(friendList).build();
        Family expectedFamily = Family.builder().familyName("happy").father(father).mother(mother).child(child).build();



        //测试family对象，断言，判断object对象是否相等
        assertEquals(expectedFamily,family);



     }
    }

//    @Test
//    void getFamilyName() {
//        //log.info(String.valueOf(family));
////断言
//    String familyName = family.getFamilyName();
//    log.info(familyName);
//    assertEquals("happy family",familyName);
//    }
//
//    @Test
//    void  getFather(){
//       // log.info(String.valueOf(family));
//        String fatherName = family.getFather().getName();
//        log.info(fatherName);
//        assertEquals("tom",fatherName);
//
//    }
//    @Test
//    void getMother(){
//
//        List<String> mother1 = family.getMother().getAlias();
//        log.info(String.valueOf(mother1));
//       // assertEquals([ lovely,alice],mother1);
//    }
//
//    @Test
//    void getChild(){
//
//        String childName = family.getChild().getName();
//        log.info(childName);
//        assertEquals("jack",childName);
//
//    }
//    @Test
//    void getFriend(){
//        List<Map<String, Object>> friend1 = family.getChild().getFriends();
//
//    }

