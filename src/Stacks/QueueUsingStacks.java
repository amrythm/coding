package Stacks;

//We are given a stack data structure with push and pop operations,
// the task is to implement a queue using instances of stack data structure and operations on them.

import java.util.Stack;

public class QueueUsingStacks {

    public static void main(String args[]) {
     //   int arr[] = new int[]{3, 4, 2, 3, 16, 3, 15, 16, 15, 15, 16, 2, 3};
      //  int n = arr.length;
        StackQueue<Integer> sq = new StackQueue<>();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        System.out.println(sq.pop());
        System.out.println("Size "+sq.size());

    }

    static class StackQueue <E> {
        Stack<E> s1;
         Stack<E> s2;
         int size;

        StackQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
            size = 0;
        }

        public void push(E n) {
            s1.push(n);
            size++;
        }

        public E pop() {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            E ans = s2.pop();
            size--;
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return ans;
        }

        public int size() {
            return size;
        }
    }

}
