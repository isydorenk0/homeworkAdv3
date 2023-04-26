package Ex3;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String text = "Необхідно створити рядок із текстом (текст взяти будь-який з інтернету). Розбити цей рядок на 2 підрядки "
                + "рівної довжині та вивести на екран кожне речення з нового рядка. Створіть у пакеті текстовий файл і"
                + " клас, внесіть у файл якийсь текст. Виведіть на екран вміст файлу.";
        String[] textSplit = splitTextMid(text);
        for (String s : textSplit) {
            Arrays.stream(s.split("\\. ")).forEach(System.out::println);
        }
    }

    private static String[] splitTextMid(String text) {
        int mid = text.length() / 2;
        String[] textSplit = new String[2];
        textSplit[0] = text.substring(0, mid);
        textSplit[1] = text.substring(mid);
        return textSplit;
    }
}
