package com.milkit.programmers.hash;

import java.lang.Long;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.*;

import org.junit.Test;


public class Participant2 {


    @Test
    public void participant() {

//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};

//        final String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//        final String[] completion = {"josipa", "filipa", "marina", "nikola"};


        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution(participant, completion));
    }

    public String solution(final String[] participant, final String[] completion) {
        String answer = "";

        Map<String, java.lang.Long> map1 = Stream.of(participant).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, java.lang.Long> map2 = Stream.of(completion).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//System.out.println(map1);
//System.out.println(map2);

        Map<String, java.lang.Long>  result = remove2(map1, map2);

//System.out.println(result);

        if(result != null && result.size() > 0) {
            answer = result.keySet().iterator().next();
        }
        return answer;
    }

    public Map<String, java.lang.Long> remove2(final Map<String, java.lang.Long> participant, final Map<String, Long> completion) {

        for (final Iterator<Map.Entry<String, Long>> it = completion.entrySet().iterator(); it.hasNext();) {
            final Map.Entry<String, Long> e = it.next();

            if(participant.containsKey(e.getKey())) {
                int pcount = participant.get(e.getKey()).intValue();
                int ccount = completion.get(e.getKey()).intValue();

                int count = pcount - ccount;

//System.out.println("Key:"+e.getKey()+"    count:"+count+"    ccount:"+ccount);
                if(count> 0) {
                    participant.put(e.getKey(), new java.lang.Long((count)));
                } else {
                    participant.remove(e.getKey());
                }
            }

//System.out.println(participant);
        }

        return participant;

    }

    public <K, V> Map<K, V> remove(final Map<K, V> participant, final Map<K, V> completion) {


        for (final Iterator<Map.Entry<K,V>> it = completion.entrySet().iterator(); it.hasNext();) {
            final Map.Entry<K,V> e = it.next();

            if(participant.containsValue(e.getValue())) {
                final Set<K> key = getKeysByValue(participant, e.getValue());

                participant.remove(key.toArray()[0]);
            }

        }


        return participant;
    }

    public <T, E> Set<T> getKeysByValue(final Map<T, E> map, final E value) {
        final Set<T> keys = new HashSet<T>();
        for (final Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

}