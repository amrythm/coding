package Queues;

import java.util.Map;

public class HeapImplementationOfPriorityQueue {


    public static void main(String args[]) {
        MaxHeapPriorityQueue pq = new MaxHeapPriorityQueue(8);
        System.out.println(pq.peek());
        pq.push(45);
        pq.push(33);
        pq.push(11);
        pq.push(87);
        System.out.println(pq.pop());
        System.out.println(pq.peek());
        System.out.println(pq.pop());
        pq.push(56);
        pq.push(13);
        pq.push(3);
        System.out.println(pq.peek());
        System.out.println(pq.pop());


    }
    public static class MaxHeapPriorityQueue {


        int arr[];
        int size;
        int capacity;

        public MaxHeapPriorityQueue(int capacity){
            arr = new int[capacity];
            size = 0;
            this.capacity = capacity;
        }

        int getParent (int pos) {
            if(size == 0)
                return -1;
            return (pos-1)/2;
        }

        int leftChild(int pos) {
            if(pos<0)
                return -1;
            return 2*pos+1;
        }


        int rightChild(int pos) {
            if(pos<0)
                return -1;
            return 2*pos+2;
        }

        void swap (int pos1, int pos2) {
            if(pos1>=size || pos2>=size)
                return;
            int temp = arr[pos1];
            arr[pos1] = arr[pos2];
            arr[pos2] = temp;
        }



        public void push(int p) {
            if(size == capacity)
                return;
            arr[size] = p;
            int pos = size;
            size++;
            while (arr[getParent(pos)] < arr[pos]) {
                swap(getParent(pos),pos);
                pos = getParent(pos);
            }
        }

        int pop() {
            if(size == 0 )
                return -1;
            int val = arr[0];
            swap(0,size-1);
            size--;
            maxHeapify(0);
            return val;
        }

        int peek(){
            if(size==0)
                return -1;
            return arr[0];
        }

        void remove(int pos) {
            if(pos>= size)
                return;
            swap(pos, size-1);

            maxHeapify(pos);
        }


        boolean isLeaf(int pos) {
            if(pos > size/2 && pos < size)
                return true;

            return false;
        }
        void maxHeapify(int pos){
                if (isLeaf(pos) || pos >= size)
                    return;

                if (arr[leftChild(pos)] > arr[rightChild(pos)]) {
                    if (arr[leftChild(pos)] > arr[pos]) {
                        swap(leftChild(pos), pos);
                        maxHeapify(leftChild(pos));
                    }
                } else {
                    if (arr[rightChild(pos)] > arr[pos]) {
                        swap(rightChild(pos), pos);
                        maxHeapify(rightChild(pos));
                    }
                }
            }


    }
}
