package xyz.fanchw.threads;

import java.util.Scanner;

public class MyPool {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num=sc.nextInt();
        StringBuilder reverse = new StringBuilder(num+"").reverse();
        System.out.println(reverse.toString());
    }
}
