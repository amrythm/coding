package Stacks;

import java.util.Stack;

//The Tower of Hanoi is a mathematical puzzle. It consists of three poles and a number of disks of
// different sizes which can slide onto any poles. The puzzle starts with the disk in a neat stack in
// ascending order of size in one pole, the smallest at the top thus making a conical shape. The objective
// of the puzzle is to move all the disks from one pole (say ‘source pole’) to another pole (say ‘destination pole’)
// with the help of the third pole (say auxiliary pole).
//
//The puzzle has the following two rules:
//      1. You can’t place a larger disk onto a smaller disk
//      2. Only one disk can be moved at a time
public class TowersOfhanoi {

    public static void main(String args[]) {
        int arr[] = new int[]{10, 4, 5, 90, 120, 80};
        int n = arr.length;

        Stack<Integer> src = new Stack<>();
        for (int i = 7; i > 0; i--) {
            src.push(i);
        }
        System.out.println(src);

        Stack<Integer> aux = new Stack<>();
        Stack<Integer> dest = new Stack<>();
        System.out.println(dest);
        moveDisks(src, aux, dest, 7);

        System.out.println(dest);
    }

    public static void moveDisks(Stack<Integer> a, Stack<Integer> b, Stack<Integer> c, int no_of_plates) {

       if(no_of_plates == 1) {
           c.push(a.pop());
       }

       else {
           moveDisks(a,c,b, no_of_plates-1);
           c.push(a.pop());
           moveDisks(b,a,c,no_of_plates-1);
       }
    }
}
