package com.milkit.programmers.hash;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;

import org.junit.Test;


public class Participant3 {


    @Test
    public void participant() {

//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};

        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};


//        String[] participant = {"mislav", "stanko", "mislav", "ana"};
//        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < completion.length; i++){
            if(hm.containsKey(completion[i])){
                hm.put(completion[i], hm.get(completion[i])+1);
            }else{
                hm.put(completion[i], 1);
            }
        }
        
        for(int i = 0; i < participant.length; i++){
            if(hm.containsKey(participant[i])){
                if(hm.get(participant[i]) > 0){
                    hm.put(participant[i], hm.get(participant[i]) - 1);
                }else{
                    answer = participant[i];
                    break;
                }
            }else{
                answer = participant[i];
                break;
            }
        }
        return answer;
    }

    public <K, V> Map<K, V> remove(Map<K, V> participant, Map<K, V> completion) {


        for (Iterator<Map.Entry<K,V>> it = completion.entrySet().iterator(); it.hasNext();) {
            Map.Entry<K,V> e = it.next();

            if(participant.containsValue(e.getValue())) {
                Set<K> key = getKeysByValue(participant, e.getValue());

                participant.remove(key.toArray()[0]);
            }

        }


        return participant;
    }

    public <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
        Set<T> keys = new HashSet<T>();
        for (Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

}