class MyCircularQueue {
    int[] arr;
    int front, rear, size;

    public MyCircularQueue(int k) {
        arr = new int[k];
        front = 0; rear = -1; size = 0;
    }

    public boolean enQueue(int value) {
        if(size == arr.length) return false;
        rear = (rear + 1) % arr.length;
        arr[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if(size == 0) return false;
        front = (front + 1) % arr.length;
        size--;
        return true;
    }

    public int Front() { return size == 0 ? -1 : arr[front]; }
    public int Rear() { return size == 0 ? -1 : arr[rear]; }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == arr.length; }
}
