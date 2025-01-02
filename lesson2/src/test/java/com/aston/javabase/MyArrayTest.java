package com.aston.javabase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyArrayTest {

    @Test
    public void testAddAndGet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(Integer.valueOf(1), list.get(0));
        Assertions.assertEquals(Integer.valueOf(2), list.get(1));
        Assertions.assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test
    public void testRemove() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals(Integer.valueOf(1), list.get(0));
        Assertions.assertEquals(Integer.valueOf(3), list.get(1));
    }

    @Test
    public void testClear() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void testSort() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.sort(Integer::compareTo);
        Assertions.assertEquals(Integer.valueOf(1), list.get(0));
        Assertions.assertEquals(Integer.valueOf(2), list.get(1));
        Assertions.assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test
    public void testLargeListOperations() {
        MyArrayList<Integer> list = new MyArrayList<>();

        // Добавление 300 элементов
        for (int i = 0; i < 300; i++) {
            list.add(i);
        }
        Assertions.assertEquals(300, list.size());

        // Проверка значений
        for (int i = 0; i < 300; i++) {
            Assertions.assertEquals(Integer.valueOf(i), list.get(i));
        }

        // Удаление 100 элементов
        for (int i = 0; i < 100; i++) {
            list.remove(0);
        }
        Assertions.assertEquals(200, list.size());

        // Проверка значений после удаления
        for (int i = 0; i < 200; i++) {
            Assertions.assertEquals(Integer.valueOf(i + 100), list.get(i));
        }

        // Очистка списка
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    // Класс для тестирования добавления разных типов
    static class CustomClass implements Comparable<CustomClass> {
        private final int value;

        public CustomClass(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(CustomClass o) {
            return Integer.compare(this.value, o.value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CustomClass that = (CustomClass) o;
            return value == that.value;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(value);
        }
    }

    @Test
    public void testAddDifferentTypes() {
        // Коллекция для Integer
        MyArrayList<Integer> intList = new MyArrayList<>();
        intList.add(1);
        intList.add(2);
        Assertions.assertEquals(2, intList.size());
        Assertions.assertEquals(Integer.valueOf(1), intList.get(0));
        Assertions.assertEquals(Integer.valueOf(2), intList.get(1));

        // Коллекция для String
        MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        Assertions.assertEquals(2, stringList.size());
        Assertions.assertEquals("Hello", stringList.get(0));
        Assertions.assertEquals("World", stringList.get(1));

        // Коллекция для CustomClass
        MyArrayList<CustomClass> customList = new MyArrayList<>();
        CustomClass custom1 = new CustomClass(10);
        CustomClass custom2 = new CustomClass(20);
        customList.add(custom1);
        customList.add(custom2);
        Assertions.assertEquals(2, customList.size());
        Assertions.assertEquals(custom1, customList.get(0));
        Assertions.assertEquals(custom2, customList.get(1));
    }

    // Тестирование сортировки с помощью quickSort и объявление величины массива
    @Test
    public void testQuickSort() {
        MyArrayList<Integer> list = new MyArrayList<>(8);
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(6);
        list.add(4);

        list.quickSort(0, list.size() - 1, Integer::compareTo);

        Assertions.assertEquals(Integer.valueOf(1), list.get(0));
        Assertions.assertEquals(Integer.valueOf(2), list.get(1));
        Assertions.assertEquals(Integer.valueOf(3), list.get(2));
        Assertions.assertEquals(Integer.valueOf(4), list.get(3));
        Assertions.assertEquals(Integer.valueOf(5), list.get(4));
        Assertions.assertEquals(Integer.valueOf(6), list.get(5));
        Assertions.assertEquals(Integer.valueOf(7), list.get(6));
        Assertions.assertEquals(Integer.valueOf(8), list.get(7));
    }
}
