package top.szz.boot.basic.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class StudentTest {
    //    注入上下文
    @Resource
    private ConfigurableApplicationContext ioc;

    @Test
    public void testLoadStudent() {

        boolean flag = ioc.containsBean("student");
        assertTrue(flag);
        Student expectedStudent = Student.builder().id(123).name("tom").build();
        Student student =(Student) ioc.getBean("student");
        assertEquals(expectedStudent,student);
    }

}
