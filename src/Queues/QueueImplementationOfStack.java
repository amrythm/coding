package Queues;

import java.util.LinkedList;
import java.util.Queue;

//Implement a Stack using two queues q1 and q2.
public class QueueImplementationOfStack {

    public static void main(String args[]) {
       QueueImplementationOfStack q = new QueueImplementationOfStack();
       q.push(2);
       q.push(3);
       System.out.println(q.pop());
       q.push(4);
        System.out.println(q.pop());


    }


    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();


    void push(int a)
    {
        q1.add(a);
    }

    //Function to pop an element from stack using two queues.
    int pop()
    {
        if(q1.size() == 0)
            return -1;
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int val = q1.poll();
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
        return val;
    }

}
