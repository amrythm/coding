package Heap;

public class MinHeap {

    int arr[];
    int heap_size;
    int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap_size = 0;
        arr = new int[capacity];
    }

    private int parent(int pos) {
        return (pos-1)/2;
    }

    private int left_child(int pos) {
        return 2*pos + 1;
    }

    private int right_child(int pos) {
        return 2*pos + 2;
    }

    private boolean isLeaf(int pos) {
        if(pos > heap_size/2 && pos <=heap_size)
            return true;

        return false;
    }


    public int extractMin( ) {
        if (heap_size <=0)
            return Integer.MAX_VALUE;
        if(heap_size == 1) {
            heap_size--;
            return arr[0];
        }

       int val = arr[0];
        arr[0] = arr[heap_size-1];
        heap_size--;
        minHeapify(0);
        return val;
    }

    public void deleteKey(int i) {
        swap(heap_size-1,i);
        minHeapify(i);
        heap_size--;
    }

    private void swap (int pos1, int pos2) {

        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
    public void minHeapify(int pos){

        if(!isLeaf(pos) && heap_size > 1) {
            if(arr[pos] > arr[left_child(pos)] || arr[pos] > arr[right_child(pos)]) {

                if(arr[left_child(pos)] > arr[right_child(pos)]) {
                    swap(pos,right_child(pos));
                    minHeapify(right_child(pos));
                }

                else {
                    swap(pos,left_child(pos));
                    minHeapify(left_child(pos));
                }
            }
        }
    }

    public void insert(int val) {

        if(heap_size < capacity) {
            arr[heap_size] = val;
            heap_size++;

            int current = heap_size-1;
            while(arr[parent(current)]>arr[current]) {
                swap(parent(current),current);
                current = parent(current);
            }
        }

    }

    public void displayHeap() {

        System.out.println(arr[0] + " ");

        int count = 2;
        for (int i = 1; i < heap_size; i++) {

            System.out.print(arr[i] + " ");
            if(i == count) {
                System.out.println();
                count = i + count^2;
            }

        }
        System.out.println();
    }

    public static void main(String args[]) {



        // Creating object opf class in main() methodn
        MinHeap minHeap = new MinHeap(15);

        // Inserting element to minHeap
        // using insert() method

        // Custom input entries
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        System.out.println("The Min Heap is ");
        // Print all elements of the heap
        minHeap.displayHeap();

        // Removing minimum value from above heap
        // and printing it
        System.out.println("The Min val is "
                + minHeap.extractMin());

        System.out.println("The Min Heap is ");
        // Print all elements of the heap
        minHeap.displayHeap();

        minHeap.deleteKey(2);
        minHeap.displayHeap();
    }
}
