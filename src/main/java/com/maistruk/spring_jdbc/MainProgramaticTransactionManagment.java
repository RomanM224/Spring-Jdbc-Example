package com.maistruk.spring_jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maistruk.spring_jdbc.programatic_transaction_managment.StudentJDBCTemplate;
import com.maistruk.spring_jdbc.programatic_transaction_managment.StudentMarks;

public class MainProgramaticTransactionManagment {
    
//  CREATE TABLE Student(
//  ID   SERIAL NOT NULL,
//  NAME VARCHAR(20) NOT NULL,
//  AGE  INT NOT NULL,
//  PRIMARY KEY (ID)
//);

//CREATE TABLE Marks(
//  SID SERIAL NOT NULL,
//  MARKS  INT NOT NULL,
//  YEAR   INT NOT NULL
//);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansProgramaticTransactionManagment.xml");
        StudentJDBCTemplate studentJDBCTemplate = 
           (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
        
        System.out.println("------Records creation--------" );
        studentJDBCTemplate.create("Zara", 11, 99, 2010);
        studentJDBCTemplate.create("Nuha", 20, 97, 2010);
        studentJDBCTemplate.create("Ayan", 25, 100, 2011);

        System.out.println("------Listing all the records--------" );
        List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
        
        for (StudentMarks record : studentMarks) {
           System.out.print("ID : " + record.getId() );
           System.out.print(", Name : " + record.getName() );
           System.out.print(", Marks : " + record.getMarks());
           System.out.print(", Year : " + record.getYear());
           System.out.println(", Age : " + record.getAge());
        }
    }

}
