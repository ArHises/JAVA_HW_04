import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class TaskOne {
    public static void main(String[] args) {
//        Реализовать консольное приложение, которое:
//        1. Принимает от пользователя и “запоминает” строки.
//        2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//        3. Если введено revert, удаляет предыдущую введенную строку из памяти.
//        4. Если введено exit, то программа завершается
//
//                > - ввод в консоль (stdin), < - вывод на консоль (stdout)
//
//                > java
//                > python
//                > c#
//                > print
//                < [c#, python, java]
//                > revert
//                > print
//                < [python, java]
//                > revert
//                > revert
//                > print
//                < []
//                > revert -> throw new NoSuchElementException

        CkeckInput();
    }
    private static void CkeckInput(){
        ArrayDeque<String> ad = new ArrayDeque<>();
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (true){
            if(input.equals("Exit")){
                break;
            } else if (input.equals("print")) {
                printList(ad);
            } else if (input.equals("revert")) {
                ad = revertList(ad);
            } else {
                ad = addToList(ad, input);
            }
            input = scan.nextLine();
        }
        scan.close();
    }
    private static ArrayDeque<String> addToList(ArrayDeque<String> ad, String input) {
        ad.addFirst(input);
        return ad;
    }
    private static ArrayDeque<String> revertList(ArrayDeque<String> ad) {
        try {
            if(!ad.isEmpty()){
                ad.removeFirst();
            }
        } catch (NoSuchElementException e) {
            System.out.println("No more elements available.");
            e.printStackTrace();
        }
        return ad;
    }
    private static void printList(ArrayDeque<String> ad) {
        if(!ad.isEmpty()){
            System.out.println(ad);
        } else {
            System.out.println("Nothing to print :(");
        }
    }
}
