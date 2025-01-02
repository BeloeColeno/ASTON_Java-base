package com.aston.javabase;

import java.util.Comparator;

/**
 * Этот класс представляет собой пользовательскую реализацию ArrayList.
 * Он предоставляет методы для добавления, удаления и доступа к элементам, а также функции сортировки.
 *
 * @param <T> тип элементов в этом списке
 * @version 1.0
 * @since 2023-10-01
 */
public class MyArrayList<T extends Comparable<? super T>>{

    private Object[] array;
    private int size;

    /**
     * Конструктор по умолчанию, создающий массив с начальной емкостью 10.
     */
    public MyArrayList(){
        array = new Object[10];
        size = 0;
    }

    /**
     * Конструктор, создающий массив с заданной начальной емкостью.
     *
     * @param ArraySize начальная емкость массива
     */
    public MyArrayList(int ArraySize){
        array = new Object[ArraySize];
        size = 0;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент для добавления
     */
    public void add(T element){
        if(size == array.length){
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size++] = element;
    }

    /**
     * Добавляет элемент в список по указанному индексу.
     *
     * @param index индекс, по которому элемент должен быть добавлен
     * @param element элемент для добавления
     */
    public void add(int index, T element){
        if(size == array.length){
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index индекс элемента для возврата
     * @return элемент по указанному индексу
     * @throws IndexOutOfBoundsException если индекс находится вне диапазона (index < 0 || index >= size)
     */
    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index];
    }

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index индекс элемента для удаления
     */
    public void remove(int index){
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }

    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов в списке
     */
    public int size(){
        return size;
    }

    /**
     * Выводит все элементы списка в консоль.
     */
    public void print(){
        for(int i = 0; i < size; i++){
            System.out.println(array[i]);
        }
    }

    /**
     * Очищает список, удаляя все элементы.
     */
    public void clear(){
        size = 0;
    }

    /**
     * Сортирует элементы списка с использованием указанного компаратора.
     *
     * @param comparator компаратор для сортировки элементов
     */
    public void sort(Comparator<T> comparator){
        quickSort(0, size - 1, comparator);
    }

    /**
     * Выполняет быструю сортировку элементов списка.
     *
     * @param low начальный индекс
     * @param high конечный индекс
     * @param comparator компаратор для сортировки элементов
     */
    public void quickSort(int low, int high, Comparator<T> comparator){
        if (low < high){
            int pi = partition(low, high, comparator);
            quickSort(low, pi - 1, comparator);
            quickSort(pi + 1, high, comparator);
        }
    }

    private int partition(int low, int high, Comparator<T> comparator){
        T pivot = (T) array[high];
        int i = low - 1;
        for (int j = low; j < high; j++){
            if (comparator.compare((T) array[j], pivot) < 0){
                i++;
                T temp = (T) array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = (T) array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
