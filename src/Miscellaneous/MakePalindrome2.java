package Miscellaneous;

//You are given a string s consisting only of lowercase English letters.
//
//In one move, you can select any two adjacent characters of s and swap them.
//
//Return the minimum number of moves needed to make s a palindrome.
//
//Note that the input will be generated such that s can always be converted to a palindrome.
public class MakePalindrome2 {

    public static void main(String[] args) {
        System.out.println(minMovesToMakePalindrome("letelt"));
    }

    //https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/discuss/1847011/c%2B%2B-2-pointers-with-detail-proof-and-explanation
    // check the above link for detailed explanation
    // here as we know that the string can be made into a palindrome, there are multiple palindromes that can be made
    // to make the palindrome with the minimum moves we have to keep two pointers, where if we do not find the matching
    // characters at these pointer positions, we move one of the pointers in other direction till we fidn the corresponding
    // mactching charcter and swap it the required number of times
    public static int minMovesToMakePalindrome(String s) {

        int l = 0;
        int r = s.length()-1;

        char t[] = s.toCharArray();
        int count = 0;
        int center_index = -1;

        while(l<r) {
            if(t[l] == t[r]) {
                l++;
                r--;
            } else {
                int k = r;
                while(k>l) {
                    if(t[k] == t[l])
                        break;
                    k--;
                }
                if(k==l) {
                    swap(t, k, k+1);
                    count++;
                }else {
                    while(k<r) {
                        swap(t, k, k+1);
                        k++;
                        count++;
                    }
                    l++;
                    r--;
                }
            }
        }

        return count;
    }

    public static void swap(char[] s, int pos1, int pos2) {

        char temp = s[pos1];
        s[pos1] = s[pos2];
        s[pos2] = temp;
    }
}
