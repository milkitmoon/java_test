package com.milkit;

import org.junit.Assert;
import org.junit.Test;

public class LambdaTest {

    @Test
    public void lambdaTest() {
        Person rin = new Person();

        rin.hi((a,b) -> {
            System.out.println("This is Coding-Factory!");
            System.out.println("Tank you Lamda");
            System.out.println("parameter number is "+a+","+b);

            return 7;
        });
    }

    @Test
    public void noLambdaTest() {
        Person rin = new Person();

        rin.hi(new Say() {
            public int someting(int a, int b) {
              System.out.println("My Name is Coding-Factory");
              System.out.println("Nice to meet you");
              System.out.println("parameter number is "+a+","+b);
              
              return 7;
            }
        });
    } 
}

@FunctionalInterface    //Functional Interface란 함수가 하나만 존재하는 Interface를 의미
interface Say {
    int someting(int a,int b);
}

class Person {
    public void hi(Say say) {
        int number = say.someting(3,4);
        System.out.println("Number is "+number);
    }
}