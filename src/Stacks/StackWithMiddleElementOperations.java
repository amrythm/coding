package Stacks;

//How to implement a stack which will support the following operations in O(1) time complexity?
//1) push() which adds an element to the top of stack.
//2) pop() which removes an element from top of stack.
//3) findMiddle() which will return middle element of the stack.
//4) deleteMiddle() which will delete the middle element.
//Push and pop are standard stack operations.

import java.util.ArrayList;
import java.util.Stack;

public class StackWithMiddleElementOperations {


    public static void main(String args[]) {
        //   int arr[] = new int[]{3, 4, 2, 3, 16, 3, 15, 16, 15, 15, 16, 2, 3};
        //  int n = arr.length;
        MidElementStack<Integer> mes = new MidElementStack<>();
        mes.push(1);
        mes.push(2);
        mes.push(3);
        mes.push(4);
        mes.push(5);
        mes.push(6);
        mes.push(7);
        System.out.println(mes.peek());
        System.out.println(mes.findMiddle());
        System.out.println("Size "+mes.size());
        mes.deleteMiddle();
        System.out.println("Top Element " + mes.peek());
        System.out.println("Middle Element " + mes.findMiddle());
        System.out.println("Size "+mes.size());
        System.out.println(mes.list);
        mes.push(8);
        mes.push(9);
        mes.push(10);
        mes.push(11);
        mes.push(12);
        System.out.println(mes.pop());
        System.out.println("Size "+mes.size());
        mes.deleteMiddle();
        System.out.println("Top Elemnt " + mes.peek());
        System.out.println("Middle Element " +mes.findMiddle());
        System.out.println("Size "+mes.size());

        System.out.println(mes.list);

    }


    static class MidElementStack<E> {

        Stack<E> st;
        int mid;
        int size;
        ArrayList<E> list;

        MidElementStack() {
            st = new Stack<>();
            list = new ArrayList<>();
            mid = 0;
            size = 0;
        }

        void push(E x) {
            st.push(x);
            list.add(x);
            size++;
            mid = size/2;
        }

        int size() {
            return size;
        }
        E peek() {
            return st.peek();
        }
        E pop() {
            if(size == 0)
                return null;
            E ans = st.pop();
            list.remove(size-1);
            size--;
            mid = size/2;
            return ans;
        }
        E findMiddle() {
            if(st.isEmpty())
                return null;
            return list.get(mid);
        }
        void deleteMiddle() {
            if(st.isEmpty())
                return;
            E res = st.peek();
            while (res!= list.get(mid)) {
                res = st.pop();
            }
            E ans = st.pop();
            list.remove(mid);

            for (int i = mid; i <list.size(); i++) {
                st.push(list.get(i));
            }
            size--;
            mid = size/2;
        }
    }

}
