package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Main {

    public static void robo() throws Exception {
        Calendar now = Calendar.getInstance();
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        //ImageIO.write(screenShot, "JPG", new File("d:\\"+formatter.format(now.getTime())+".jpg"));
        //System.out.println(formatter.format(now.getTime()));
        System.out.println(screenShot.getWidth() + "x" + screenShot.getHeight());
    }


    public static void main(String[] args) {
        System.out.println("Кофе-машина");

        //TODO: read from console
        //int moneyAmount = 120;
        System.out.println("Please write your moneyAmount: ");
//        String s = "";
//        System.console().readLine(s);
//        int moneyAmount = Integer.parseInt(s);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();       // java.io.IOException
//        int moneyAmount = Integer.parseInt(s);
        int moneyAmount = 0;
        for(boolean good_input = false;good_input == false; ){
            Scanner in = new Scanner(System.in);
            try {
                moneyAmount = in.nextInt();
                good_input = true;
            }
            //catch(java.io.IOException ex){
            catch(Exception ex){
                System.out.println("Wrong input: please use digits... ");
                //in.reset();
                good_input = false;
            }
        }

        System.out.println("Your moneyAmount is: " + moneyAmount);

        int[] drinkPrices = {150, 80, 20, 50};
        String[] drinkNames = {"капучино", "эспрессо", "воду", "молоко"};

        //TODO: add boolean canBuyAnything
        boolean canBuyAnything = false;
        for(int i = 0; i < drinkPrices.length; i++) {
            if (moneyAmount >= drinkPrices[i]) {
                System.out.println("Вы можете купить " + drinkNames[i]);
                canBuyAnything = true;
            }
        }
        if(!canBuyAnything) {
            System.out.println("Недостаточно средств :( Изучайте Java и зарабатывайте много!))");
        }

        //TODO: print date in format: 20201008_174908
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date now = new Date();
        System.out.println(formatter.format(now));

        //TODO: get screenshot to image variable
        ///BufferedImage image = null;
        ///System.out.println(image.getWidth() + "x" + image.getHeight());
        try {
            robo();
        } catch(Exception ex){
            System.out.println("Can't get screenshot!..");
        }

        //TODO: publish result screenshots in telegram chat
        //  with tag #javamonster
    }
}
