package org.example;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
//      This line will create the spring container and the configuration to that container is also mentioned "spring.xml"
//      so now spring got to know what all type of classes and objects spring need to create and also
//      give the container where the objects are stored.

        // When does the spring will create the object in spring container?
        // During this line it tells spring to create the object for the classes that are mentioned with the bean tag.
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // getBean will return the object from container.
        Dev obj = (Dev) context.getBean("dev");
        obj.build();
        System.out.println(obj.getVal());

//        scope for Bean: 1) Singleton: creates only one object in whole application, and creates on when container is created.
//                        2) Prototype : creates when getBean is called. and also everytime new object is created.
//                        3) Request
//                        4) Session

//        Setter Injection: This is used to assign the value to the Primitive variables using the setter method using value attribute.
//                <property name="val" value="21"></property>
//                -> This is used to assign the value to the Reference variables using the setter method using ref attribute.
//                <property name="laptop" ref="laptop"></property>

//        Constructor Injection:
                // useful only when both the parameters are of different types, and sequence not important
//              <constructor-arg type="org.example.Laptop" ref="laptop" />
//              <constructor-arg type="int" value="21" />
//                                                OR
                // useful only when parameters are of same types, and sequence not important
//              <constructor-arg index="0" ref="laptop" />
//              <constructor-arg index="1" value="21" />
//                                                    OR
                // sequence matters but when @ConstructorProperties({"val" , "laptop"}) is used above constructor then it
                // will run if not in sequence.
//              <constructor-arg name="laptop" ref="laptop" />
//              <constructor-arg name="age" value="21" />

//        Autowire :
//              <bean id="dev" class="org.example.Dev" autowire="byName">
//                this will create

    }
}
