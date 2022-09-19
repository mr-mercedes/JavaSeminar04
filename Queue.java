package ru.Seminar04;

/*
    2. Написать реализацию очереди на основе массива; Реализовать методы size(), empty(), offer(), poll(), peek()
 */

public class Queue<T> {
    private T[] array;
    private int index;

    public Queue(int length) {
        this.index = 0;
        this.array = (T[]) new Object[length];
    }

    public int size(){
        return this.index;
    }
    public boolean empty(){
        return this.index == 0;
    }
    public boolean offer(T item){
        this.array[index++] = item;
        return this.array[index - 1] == item;
    }
    public Object poll(){
        T[] tmp = (T[]) new Object[this.array.length - 1];
        if (empty()){
            System.out.println("null");
        }
        System.arraycopy(this.array, 1, tmp, 0, tmp.length);
        System.arraycopy(tmp, 0, this.array, 0, tmp.length);
        return this.array[0];
    }
    public Object peek() {
        return this.array[0] == null ? null : this.array[0];
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>(10);
        queue.offer("String 1");
        queue.offer("String 2");
        queue.offer("String 3");
        System.out.println(queue.empty());
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue.size());
    }

}
