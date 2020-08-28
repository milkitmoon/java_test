package com.milkit.programmers.hash;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.*;

import org.junit.Test;

public class Phonebook {


    @Test
    public void phonebook() {

        String[] phone_book = {"119", "97674223", "1195524421"}; 
        System.out.println(solution(phone_book));
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for(int i=0; i<phone_book.length; i++) {
            String currNumber = phone_book[i];
            
            Set<String> cpPhonebookSet = Stream.of(phone_book).parallel().filter(str->{
                if (str.equals(currNumber)) {
                    return false;
                } 
                return true;
            }).collect(Collectors.toSet());

//System.out.println(cpPhonebookSet); 

            Optional<String> result = cpPhonebookSet.stream().parallel().filter(s -> s.startsWith( currNumber )).findAny();

            if(result.isPresent()) {
                answer = false;
//              System.out.println("test:"+test);
                break;
            }
        }

        return answer;
    }
}