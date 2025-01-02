package javabase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Homework {

    // Перевернуть строку и вывести на консоль
    //  String string = "I love Java";
    public static void turnString(String string) {
        char[] chars = string.toCharArray();
        System.out.print("Строка " + string + " в перевернутом виде: ");
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
        System.out.println(".");
    }

    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль
    public static void getDistinctNumbers(int[] ints) {
        Set<Integer> intSet = new HashSet<>();
        for (int anInt : ints) {
            intSet.add(anInt);
        }
        System.out.println("Массив ints без дубликатов: " + intSet);
    }

    // Дан массив, заполненный уникальными значениями типа int.
    // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
    public static Integer findSecondMaxElement(int[] arr) {
        Arrays.stream(arr).sorted().toArray();
        return arr[arr.length - 1];
    }

    // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    // "Hello world" - 5
    // "    fly me    to the moon    " - 4
    public static Integer lengthOfLastWord(String string) {
        while (string.charAt(string.length() - 1) == ' ') {
            string = string.substring(0, string.length() - 1);
        }
        return string.substring(string.lastIndexOf(' '), string.length() - 1).length();
    }

    // Определить, что строка является палиндромом
    // Сложность по памяти O(1), не создавать новые String, StringBuilder
    // Примеры:
    // abc - false
    // 112233 - false
    // aba - true
    // 112211 - true
    public static boolean isPalindrome(String string) {
        /* Это был код для условия O(1), но в ходе написания условия упростили до O(n).
        Код все равно не работает, потому, что метод .contentEquals не обрабатывает 2 CharSequence.
        Но концептуально это решение правильное(если дописать ручной компаратор, то оно будет лучше цикла по скорости).

        if (string.length() % 2 == 0){
            System.out.println(string.substring(0, string.length() / 2) + " " +"\u202E" +  string.substring(string.length() / 2));
            return string.substring(0, string.length() / 2).contentEquals("\u202E" + string.substring(string.length() / 2));
        }else {
            System.out.println(string.substring(0, string.length() / 2 + 1) + " " +"\u202E" +  string.substring(string.length() / 2));
            return string.substring(0, string.length() / 2 + 1).contentEquals("\u202E" + string.substring(string.length() / 2));
        }*/
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("==============================Ex1==============================");
        turnString("I love Java");
        System.out.println("==============================Ex2==============================");
        int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
        getDistinctNumbers(ints);
        System.out.println("==============================Ex3==============================");
        int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
        System.out.println("Предпоследнее по величине число в массиве arr: " + findSecondMaxElement(arr));
        System.out.println("==============================Ex4==============================");
        System.out.println("Количество букв в последнем слове выражения \"Hello world\": " + lengthOfLastWord("Hello world"));
        System.out.println("Количество букв в последнем слове выражения \"    fly me    to the moon    \": " + lengthOfLastWord("    fly me    to the moon    "));
        System.out.println("==============================Ex5==============================");
        System.out.println("Является ли выражение \"abc\" палиндромом? - " + isPalindrome("abc"));
        System.out.println("Является ли выражение \"112233\" палиндромом? - " + isPalindrome("112233"));
        System.out.println("Является ли выражение \"aba\" палиндромом? - " + isPalindrome("aba"));
        System.out.println("Является ли выражение \"112211\" палиндромом? - " + isPalindrome("112211"));
    }
}
