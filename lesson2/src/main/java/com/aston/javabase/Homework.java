package com.aston.javabase;

import java.util.Comparator;

public class Homework {

    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(4);

        System.out.println("Первый элемент списка до удаления: " + list.get(0));
        System.out.println("Удаление первого элемента массива.");
        list.remove(0);
        System.out.println("Первый элемент списка после удаления: " + list.get(0));
        System.out.println("============================================================");
        list.sort((o1, o2) -> o1 - o2);
        System.out.println("Список после сортировки: ");
        list.print();
    }
}

