package com.atguigu.mySpring;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MyTest {
    private static final Logger logger = LoggerFactory.getLogger(MyTest.class);

    @Test
    public void testUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        // 1. 根据id获取
        User user1 = (User) ac.getBean("user");
        user1.setName("张三");
        user1.setAge(10);
        System.out.println(user1); // user [name=张三, age=10]
        // 2. 根据类型获取
        User user2 = ac.getBean(User.class);
        // 3. 根据id和类型获取
        User user3 = ac.getBean("user", User.class);
        // 手动写日志
        logger.info("######### 执行了测试方法");
    }

    @Test
    public void testStudent() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        // 无参构造器
        Student student1 = ac.getBean("studentOne", Student.class);
        System.out.println(student1);
        // 有参构造器
        Student student2 = ac.getBean("studentTwo", Student.class);
        System.out.println(student2);
    }

    @Test
    public void testClassroom() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Classroom classroom1 = ac.getBean("classroomOne", Classroom.class);
        Classroom classroom2 = ac.getBean("classroomOne", Classroom.class);
        System.out.println(classroom1 == classroom2); // false，bean的scope设置为prototype，每个getBean时创建新实例
        Classroom classroom3 = ac.getBean("classroomTwo", Classroom.class);
        Classroom classroom4 = ac.getBean("classroomTwo", Classroom.class);
        System.out.println(classroom3 == classroom4); // true，默认单例，IOC容器初始化时就创建
    }

    @Test
    public void testDB() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-jdbc.xml");
        DataSource dataSource = ac.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void autoWiredTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        AutoWiredTest autoWiredTest = new AutoWiredTest();
        System.out.println(autoWiredTest.getStr()); // null
        //
        AutoWiredTest autoWiredTest1 = ac.getBean(AutoWiredTest.class);
        System.out.println(autoWiredTest1.getStr()); // null

    }
}
