package DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class tasks {

    public static void main(String[] args) {

        NumberContainers obj = new NumberContainers();
        System.out.println(obj.find(10));
        obj.change(2,10);
        obj.change(1,10);
        obj.change(3,10);
        obj.change(5,10);
        System.out.println(obj.find(10));
        obj.change(1,20);
        System.out.println(obj.find(10));

    }

    static class NumberContainers {

        HashMap<Integer, HashSet<Integer>> map;
        HashMap<Integer, Integer> indices;

        public NumberContainers() {
            map = new HashMap<>();
            indices = new HashMap<>();
        }

        public void change(int index, int number) {


            if (map.containsKey(number)) {
                HashSet<Integer> q = map.get(number);
                q.add(index);
                map.put(number, q);
            } else {

                HashSet<Integer> q = new HashSet<>();
                q.add(index);
                map.put(number, q);
            }

            if (indices.containsKey(index)) {
                int n = indices.get(index);
                if (n != number) {
                    HashSet<Integer> q = map.get(n);
                    q.remove(index);
                    map.put(n, q);
                }
            }

            indices.put(index, number);

        }

        public int find(int number) {
            int n = -1;
            if (map.containsKey(number)) {
                HashSet<Integer> q = map.get(number);
                if (!q.isEmpty()) {
                    n = (int) Collections.min(q);
                }
            }
            return n;
        }
    }
}
