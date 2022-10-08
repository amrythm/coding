package Queues;

public class ArrayImplementationOfQueue {


    public static void main(String args[]) {
        Queue q = new Queue(6);
        System.out.println(q.dequeue());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(1);
        q.enqueue(3);
        q.dequeue();
        q.printQueue();
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.printQueue();

    }

    public static class Queue {

        int size;
        int capacity;
        int arr[];
        int head, tail;

        public Queue(int capacity) {
            size = 0;
            this.capacity = capacity;
            arr = new int[capacity];
            head = 0;
            tail = 0;
        }

        public void enqueue(int n) {
            if(size<capacity) {
                if(tail == capacity) {
                    tail = tail - capacity;
                }
                arr[tail] = n;
                tail++;
                size++;
            }else
                System.out.println("Queue is full bitch!!!!");
        }

        public void printQueue() {
            if(head<tail) {
                for (int i = head; i < tail; i++) {
                    System.out.print(arr[i] + " ");

                }
                size++;
                System.out.println();
            }else {
                for (int i = head; i < capacity ; i++) {
                    System.out.print(arr[i] + " ");
                }
                for (int i = 0; i < tail ; i++) {
                    System.out.print(arr[i] + " ");

                }
                System.out.println();
            }
        }
        public int dequeue() {
            if(size<1) {
                return Integer.MIN_VALUE;
            }
            if(head == capacity)
                head = head - capacity;
            int val = arr[head];
            head++;
            size--;
            return val;
        }
    }
}
