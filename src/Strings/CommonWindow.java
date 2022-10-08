package Strings;

import java.util.HashMap;

//Given two strings S and P. Find the smallest window in the string S consisting of all the
// characters(including duplicates) of the string P.  Return "-1" in case there is no such window
// present. In case there are multiple such windows of same length, return the one with the least starting index.
public class CommonWindow {

    public static void main(String args[]) {
        String s = "bdheedcfeeafhijabdbehhfaigjghiijabcfagjgcedbjhhehajgbgbiechagdfeaffejdhhihdhjjahbcgcgdf" +
                "bfdadhdgefghchdhdigbjciehiebgahbahddhiidebcfaieefjgefaafhbfiabgdbjcfbaedgfhigbgibegjfjjgic" +
                "jcgciccfdhehcgjdeccbfehdgcddighgagfbeheaccahgfggdbgeaiajeahegbcjadehajafjfcdbbjfgahhcjbai" +
                "gfbfiifdegiafeejibcfbdecfeicbjgabhbhfdgebfjjjjbggfgcibhehchhffhcebcbdbcedbadjehffjihhdichh" +
                "ebajjgbehjacbbidagihdijjecfcjeibfadbdaehcfjfbjhgbdgbhdjgg" +
                "iajfgjfdifafgebdbjghbehceaiedabebhgigagehcfegjeaiehbfgedaddegiaahgacigafihahegefjgjhhi" +
                "jjfgbddhiafhbjiicjaaigeeeiiadj";
        int l = s.length();

        String t = "cdaehaihiejehfcfajjcidcdhghfjejbgibadbbgbjegfhgggfgaefaaabcbgdiffdejdijebfebejhaccffehff";

        System.out.println(findCommonWindow(s, t));
    }

    public static String findCommonWindow(String s, String p) {

        if(s.length()<p.length())
            return "-1";

        HashMap<Character,Integer> p_characters = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            p_characters.put(p.charAt(i), p_characters.getOrDefault(p.charAt(i),0)+1);
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int i=-1;
        int j = -1;
        int m_count = 0;
        int count = p.length();
        int start = 0;
        int end = s.length()+5;

        while (true) { //if solution is not clear see YT video by Sumeet malik

            boolean flag = false; // flags to break out of the outer loop when inner loops are completed
            boolean flag2 = false;

            // checking from the begining if all the charcters are presnt in window
            while (i<s.length()-1 && m_count<count) {
                i++;
                char ch = s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);

                if(map.getOrDefault(ch,0) <= p_characters.getOrDefault(ch,0)) {
                    m_count++;
                }
                flag =true;
            }

            // as we get a window, we have got an answer and we start removing elements from begining until
            //the window does not have all elemenst of second string, the smallest substring encountered till now is
            //        the present ans, after that we agiain go to previous step
            while (j<i && m_count == count) {
                if((end - start+1) > (i-j)) {
                    start = j+1;
                    end = i;
                }
                j++;
                char ch = s.charAt(j);
                map.put(ch,map.get(ch)-1);
                if(map.getOrDefault(ch,0) < p_characters.getOrDefault(ch,0)) {
                    m_count--;
                }
                flag2 = true;
            }
            if(!flag && !flag2)
                break;
        }
        if(end == s.length()+5)
            return "-1";
        else
        return s.substring(start, end +1);

    }
}
