package com.milkit.programmers.hash;

import java.util.*;

import org.junit.Test;


public class Participant {


    @Test
    public void participant() {

//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};


        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";


        List<String> list1 = new ArrayList<String>(Arrays.asList(participant));
        List<String> list2 = new ArrayList<String>(Arrays.asList(completion));
        
        List<String> result = remove(list1, list2);

System.out.println(result);

        if(result != null && result.size() > 0) {
            answer = result.get(0);
        }
        return answer;
    }

    public <T> List<T> remove(List<T> participant, List<T> completion) {
        List<T> list = new ArrayList<T>();

        for (T t : completion) {
            if(participant.contains(t)) {
                participant.remove(t);
            }
        }

        return participant;
    }

}