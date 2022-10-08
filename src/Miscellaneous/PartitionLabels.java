package Miscellaneous;


//You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
//
//Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
//
//Return a list of integers representing the size of these parts.
//
//
//
//Example 1:
//
//Input: s = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
import java.util.ArrayList;

public class PartitionLabels {

    public static void main (String[] args) {

        String s = "ababcbacadefegdehijhklij";
        System.out.println(findPartitions(s));
    }

    static ArrayList<Integer> findPartitions(String s) {

        ArrayList<Integer> ans = new ArrayList<>();
        int n = s.length();
        String temp = "";
        for (int i = 0; i < n;) {
            temp = temp + s.charAt(i);

            for (int j = 0; j < temp.length(); j++) {
                String t = s.substring(i+temp.length());
                int l = t.lastIndexOf(temp.charAt(j));
                if(l != -1)
                temp = temp + t.substring(0, l+1);
            }
            i+= temp.length();
            ans.add(temp.length());
            temp = "";

        }

        return ans;
    }

}
