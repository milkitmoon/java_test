package com.milkit;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {
  @Test
  public void shouldAnswerWithTrue() {
    System.out.println("\n\ntest!!\n\n");
    Assert.assertTrue(true);
  }

  @Test
  public void StringTest() {
//    String s = new String("abc");
//    String s1 = new String("abc");  //false, true
    String s = "abc";  
    String s1 = "abc";    //true, true

    if(s == s1) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }

    if(s.equals(s1)) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }

  }

}

