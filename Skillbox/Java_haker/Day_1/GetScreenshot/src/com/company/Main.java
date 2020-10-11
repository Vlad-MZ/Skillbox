package com.company;

/*
 * GetScreenshot.java (requires Java 1.4+)
 *      http://web.archive.org/web/20090204074007/http://schmidt.devlib.org/java/save-screenshot.html
 *  java—Take a screenshot and save it to a PNG file using javax.imageio
 *      e.x.
 *          com.company.Main 5 myScreenshot.png
 */

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

//public
class GetScreenshot {
    public static void main(String[] args) throws java.lang.Exception {
        // make sure we have exactly two arguments,
        // a waiting period and a file name
        if (args.length != 2) {
            System.err.println("Usage: java Screenshot " +
                    "WAITSECONDS OUTFILE.png");
            System.exit(1);
        }
        // check if file name is valid
        String outFileName = args[1];
        if (!outFileName.toLowerCase().endsWith(".png")) {
            System.err.println("Error: output file name must " +
                    "end with \".png\".");
            System.exit(1);
        }
        // wait for a user-specified time
        try {
            long time = Long.parseLong(args[0]) * 1000L;
            System.out.println("Waiting " + (time / 1000L) +
                    " second(s)...");
            Thread.sleep(time);
        } catch(NumberFormatException nfe) {
            System.err.println(args[0] + " does not seem to be a " +
                    "valid number of seconds.");
            System.exit(1);
        }
        // determine current screen size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        Rectangle screenRect = new Rectangle(screenSize);
        // create screen shot
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRect);
        // save captured image to PNG file
        ImageIO.write(image, "png", new File(outFileName));
        // give feedback
        System.out.println("Saved screen shot (" + image.getWidth() +
                " x " + image.getHeight() + " pixels) to file \"" +
                outFileName + "\".");
        // use System.exit if the program hangs after writing the file;
        // that's an old bug which got fixed only recently
        // System.exit(0);
    }
}

public class Main extends GetScreenshot {
    public static void main(String[] args) throws java.lang.Exception {
        GetScreenshot.main(args);
    }
}
