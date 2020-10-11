//
// At start, file has been created at https://ideone.com/I8kjSs
//
package com.company;
/* package whatever; -- don't place package name! */

//import java.util.*;
//import java.lang.*;
//import java.io.*;


/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Кофе-машина");

        int moneyAmount = 12;   // 120
        int cappucinoPrice = 150;
        int espressoPrice = 80;
        int waterPrice = 20;
        int milkPrice = 40;

        boolean canBuyAnything = false;

        if(moneyAmount >= cappucinoPrice) {
            System.out.println("Вы можете купить капучино");
            canBuyAnything = true;
        }

        if(moneyAmount >= espressoPrice) {
            System.out.println("Вы можете купить эспрессо");
            canBuyAnything = true;
        }

        if(moneyAmount >= waterPrice) {
            System.out.println("Вы можете купить воду");
            canBuyAnything = true;
        }

        if(moneyAmount >= milkPrice) {
            System.out.println("Вы можете купить молоко");
            canBuyAnything = true;
        }
        if(canBuyAnything == false) {
            System.out.println("Недостаточно средств :( Изучайте Java и зарабатывайте много!))");
        }
    }
}

//public  +
class Main extends Ideone {
    public static void main (String[] args) throws java.lang.Exception{
        Ideone.main(args);
    }
}