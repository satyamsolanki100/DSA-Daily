// File: MinHeap.java

import java.util.*;

public class MinHeap {

    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void initializeHeap() {
        heap.clear();
    }

    public void insert(int x) {
        heap.add(x);
        heapifyUp(heap.size() - 1);
    }

    public int getMin() {
        if (isEmpty()) return -1;
        return heap.get(0);
    }

    public void extractMin() {
        if (isEmpty()) return;

        int last = heap.get(heap.size() - 1);
        heap.set(0, last);
        heap.remove(heap.size() - 1);

        heapifyDown(0);
    }

    public int heapSize() {
        return heap.size();
    }

    public int isEmpty() {
        return heap.isEmpty() ? 1 : 0;
    }

    public void changeKey(int index, int val) {
        if (index < 0 || index >= heap.size()) return;

        int old = heap.get(index);
        heap.set(index, val);

        if (val < old) {
            heapifyUp(index);
        } else {
            heapifyDown(index);
        }
    }

    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;

            if (heap.get(parent) > heap.get(i)) {
                swap(parent, i);
                i = parent;
            } else break;
        }
    }

    private void heapifyDown(int i) {
        int n = heap.size();

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < n && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            if (right < n && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args) {

        MinHeap h = new MinHeap();

        h.initializeHeap();
        h.insert(4);
        h.insert(1);
        h.insert(10);

        System.out.println(h.getMin()); // 1
        System.out.println(h.heapSize()); // 3
        System.out.println(h.isEmpty()); // 0

        h.extractMin();

        h.changeKey(0, 16);

        System.out.println(h.getMin()); // 10
    }
}