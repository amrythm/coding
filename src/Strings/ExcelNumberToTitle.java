package Strings;

public class ExcelNumberToTitle {

    public static void main(String args[]) {
        String s = "ZY";
        int l = s.length();

        System.out.println(columnTitle(474578));
    }

    public static String columnTitle(int n) {

        String s = "";
        int l=0;
        Integer m = n;
        while (m >1) {
            m = m/26;
            l++;
        }
        char[] ch = new char[l];
        int i=0;
        while(n > 1 && i<l) {
            m = n%26;
            if(m == 0) {                  // Here we have to care of 'Z' as a special case beacuse remanider comes to be
                                            // zero  and it will not give the correct answer
                m += 26;
                n = n/26 -1;
            }else n = n/26;
            ch[i++] = (char)(m+64);
        }
        for (int j = l-1; j >=0; j--) {
            s = s + ch[j];
        }
        return s;
    }
}
