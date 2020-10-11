//
// Details:
//  https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/
//      1.Using Buffered Reader Class
//      2. Using Scanner Class
//      3. Using Console Class
//

package com.company;
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.Console;

//public class ConsoleReadingDemo;
public class Main {

    /* Name of the class has to be "Main" only if the class is public. */
    public static void main(String[] args) {

        // ====
        // Java snippet to demonstrate BufferedReader
        //  Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("1: Please enter user name : ");
        String username = null;
        try {
            username = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("You entered : " + username);

        // =====
        // Java snippet to demonstrate working of Scanner in Java
        Scanner in = new Scanner(System.in);
        System.out.print("2: Please enter user name : ");
        username = in.nextLine();
        System.out.println("You entered : " + username);


        // ======
        // Java snippet to demonstrate working of System.console()
        // !!! Note that this program does not work on IDEs as System.console() may require console
        try{
            // Using Console to input data from user
            Console console = System.console();
            username = console.readLine("Please enter user name : ");
            System.out.println("You entered : " + username);
        } catch(Exception ex){
            System.out.println("Unable to fetch console.  Exception : " + ex);
        }
    }
}

/*
C:\Users\User\.jdks\openjdk-15\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2020.2.3\lib\idea_rt.jar=57207:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2020.2.3\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\User\IdeaProjects\Skillbox\Java_haker\Day_1\ConsoleReadingDemo\out\production\ConsoleReadingDemo com.company.Main
1: Please enter user name : 111
You entered : 111
2: Please enter user name : 222
You entered : 222
Unable to fetch console.  Exception : java.lang.NullPointerException: Cannot invoke "java.io.Console.readLine(String, Object[])" because "console" is null

Process finished with exit code 0
*/
