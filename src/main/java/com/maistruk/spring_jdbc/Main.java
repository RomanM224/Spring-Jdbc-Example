package com.maistruk.spring_jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maistruk.spring_jdbc.jdbc.Student;
import com.maistruk.spring_jdbc.jdbc.StudentJDBCTemplate;
import com.maistruk.spring_jdbc.programatic_transaction_managment.StudentMarks;

public class Main {
    
//    CREATE TABLE Student(
//            ID   SERIAL NOT NULL,
//            NAME VARCHAR(20) NOT NULL,
//            AGE  INT NOT NULL,
//            PRIMARY KEY (ID)
//         );

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansJdbc.xml");

        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
        studentJDBCTemplate.deleteAllStudents();

        System.out.println("------Records Creation--------");
        studentJDBCTemplate.create("Zara", 11);
        studentJDBCTemplate.create("Nuha", 2);
        studentJDBCTemplate.create("Ayan", 15);

        System.out.println("------Listing Multiple Records--------");
        List<Student> students = studentJDBCTemplate.listStudents();

        int id = 0;
        for (Student record : students) {
            id = record.getId();
            System.out.print("ID : " + record.getId());
            System.out.print(", Name : " + record.getName());
            System.out.println(", Age : " + record.getAge());
        }

        System.out.println("----Updating Record with ID = 2 -----");
        studentJDBCTemplate.update(id, 20);

        System.out.println("----Listing Record with ID = 2 -----");
        Student student = studentJDBCTemplate.getStudent(id);
        System.out.print("ID : " + student.getId());
        System.out.print(", Name : " + student.getName());
        System.out.println(", Age : " + student.getAge());
        System.out.println("max(id) : " + studentJDBCTemplate.getMaxId());
    }
}
