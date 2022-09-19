package ru.Seminar04;

/*
    Реализовать стэк с помощью массива.
    Нужно реализовать методы:
    size(), empty(), push(), peek(), pop().
 */

import java.util.Scanner;

public class Stack<T> {
    private T[] array;
    private int index;
    private final String[] menu = {"1: Добавить элемент в Stack", "2: Удалить елемент из Stack", "3: Вывести весь Stack",
            "4: Узнать размер Stack", "5: Вывести последний элемент Stack", "6: Выход"};

    public Stack(int length) {
        this.index = 0;
        this.array = (T[]) new Object[length];
    }

    public int size() {
        return this.index;
    }

    public boolean empty() {
        return this.size() == 0;
    }

    public void push(T value) {
        this.array[index++] = value;
    }
    public void printStack (){
        for (T t : this.array) {
            if (t != null) {
                System.out.println(t);
            } else {
                break;
            }
        }
    }

    public T peek() {
        if (size() < index - 1) {
            System.out.println("Can not peek element, stack is empty.");
        }
        return this.array[index - 1];
    }
    public int length(){
        return this.array.length;
    }

    public T pop() {
        if (empty()) {
            System.out.println("Can not pop element, stack is empty.");
        }
        return this.array[--index];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>(4);
        for (String item : stack.menu) {
            System.out.println(item);
        }
        boolean flag = true;
        while (flag) {
            System.out.print("Введите номер операции: ");
            int userOperation = scanner.nextInt();
            if (userOperation == 1) {
                if (stack.index == stack.length() - 1) {
                    System.out.println("Достигнут предел Stack, для добавления удалите элемент");
                } else {
                    System.out.print("Введите элемент для добавления в Stack: ");
                    String userInput = scanner.next();
                    stack.push(userInput);
                }
            } else if (userOperation == 2) {
                System.out.printf("Элемент [%s] удален из Stack\n", stack.pop());
            } else if (userOperation == 3) {
                stack.printStack();
            } else if (userOperation == 4) {
                System.out.printf("Размер Stack = %d\n", stack.size());
            } else if (userOperation == 5) {
                System.out.printf("Последний введенный элемент в Stack = %s\n", stack.peek());
            } else if (userOperation == 6) {
                System.out.println("Работа с программой завершена.");
                flag = false;
            } else {
                System.out.println("Операция не найдена, повторите ввод");
            }
        }
    }
}

