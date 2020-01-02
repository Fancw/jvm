package xyz.fanchw.threads;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] words = str.split(" ");
        StringBuilder sentence = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sentence.append(words[i]);
            if (i > 0) {
                sentence.append(" ");
            }
        }
        System.out.println(sentence.toString());
    }
}
