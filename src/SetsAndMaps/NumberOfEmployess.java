package SetsAndMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class NumberOfEmployess {

    public static void main(String args[]) {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("Z", "G");
        dataSet.put("Q", "I");
        dataSet.put("R", "I");
        dataSet.put("P", "L");
        dataSet.put("N", "M");
        dataSet.put("S", "K");
        dataSet.put("L", "D");
        dataSet.put("O", "M");
        dataSet.put("M", "C");
        dataSet.put("I", "D");
        dataSet.put("K", "C");
        dataSet.put("G", "D");
        dataSet.put("C", "X");
        dataSet.put("D", "X");
        dataSet.put("E", "X");
        dataSet.put("X","X");

        System.out.println(findNumber(dataSet));
    }

    public static HashMap<String, Integer > findNumber(Map<String,String> dataset) {

        HashMap<String, HashSet<String>> no_of_employees = new HashMap<>();
        String CEO = "";
        for(String emp : dataset.keySet()) {
            String man = dataset.get(emp);

            if(man.equals(emp)) {
                CEO = man;
            } else {
                if(no_of_employees.containsKey(man)) {
                    HashSet<String> emps = no_of_employees.get(man);
                    emps.add(emp);
                }
                else {
                    HashSet<String> emps = new HashSet<>();
                    emps.add(emp);
                    no_of_employees.put(man, emps);
                }
            }
        }

        HashMap<String, Integer> result = new HashMap<>();
        getSize(CEO,no_of_employees, result);
        return result;

    }

    public static int getSize(String root,HashMap<String, HashSet<String>> manager_list, HashMap<String,Integer> result) {
        if(manager_list.isEmpty())
            return 0;
        if(!manager_list.containsKey(root)) {
            result.put(root,0);
            return 1;
        }
        int size =0;
        for(String s : manager_list.get(root)) {
            int sz = getSize(s, manager_list, result);
            size+=sz;
        }
        result.put(root, size);
        return size+1;
    }

}
