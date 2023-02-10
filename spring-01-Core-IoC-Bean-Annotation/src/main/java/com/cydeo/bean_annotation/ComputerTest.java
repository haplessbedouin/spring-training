package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.ConfigExample2;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {

    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, ConfigExample2.class);

        Monitor theMonitor = container.getBean(Monitor.class);
        Case theCase = container.getBean(Case.class);
        Motherboard theMotherboard = container.getBean(Motherboard.class);

        PC myPc = new PC(theCase, theMonitor, theMotherboard);

        myPc.powerUp();

        System.out.println("Retrieving the beans");
        Monitor theMonitor0 = container.getBean(Monitor.class);
        Case theCase0 = container.getBean(Case.class);
        Motherboard theMotherboard0 = container.getBean(Motherboard.class);

        System.out.println("Multiple objects in the config class");

        Monitor theMonitor2 = container.getBean("monitorSony", Monitor.class); // Default bean name
        Monitor theMonitor3 = container.getBean("sony", Monitor.class); // Custom bean name
        Monitor theMonitor4 = container.getBean(Monitor.class); // @Primary annotation


    }

}
