package Strings;

import java.util.HashMap;

public class RemoveReverse {

    public static void main(String[] args) {
        System.out.println(removeReverse("abab"));
    }

    static String removeReverse(String S)
    {
        int N = S.length();
        int l = 0;
        int r = N-1;

        boolean flag = true;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++) {
            char c = S.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        char[] c = S.toCharArray();
        System.out.println(c);
        System.out.println(map);

        while(l<r) {
            if(flag) {
                char temp = c[l];
                if(map.get(temp) >1) {
                    c[l] = '$';
                    flag = false;
                    map.put(temp, map.get(temp)-1);
                    l++;
                } else l++;
            }
            else {
                char temp = c[r];
                if(map!= null && map.get(temp) >1) {
                    c[r] = '$';
                    flag = true;
                    map.put(temp, map.get(temp)-1);
                    r--;
                } else r--;
            }
        }

        String res = "";
        if(flag) {
            for(int i=0;i<N;i++)  {
                if(c[i] != '$')
                    res = res + c[i];
            }
        }
        else {
            for(int i=N-1;i>=0;i--)  {
                if(c[i] != '$')
                    res = res + c[i];
            }
        }

        return res;
    }
}
