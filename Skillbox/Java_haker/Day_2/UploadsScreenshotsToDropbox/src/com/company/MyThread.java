package com.company;

import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread{

    private DbxClientV2 client;
    private boolean flDebug;

    public MyThread(DbxClientV2 clientV2){
        this.client = clientV2;
        this.flDebug = false;
    }

    @Override
    public void run(){
         try{
            // +TODO: create screenshot
            BufferedImage image = null;
            image = createShortcut();

            // +TODO: convert it to InputStream, используя классы
            //  ByteArrayOutputStream + ByteArrayInputStream
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "png", os);               // Passing: ​(RenderedImage im, String formatName, OutputStream output)

            // +TODO: upload to Dropbox. Именовать файлы по такому шаблону: 2020100_171004.png
            String outFileName = getFileName();
            try (InputStream in = new ByteArrayInputStream(os.toByteArray())) {
                FileMetadata metadata = client.files().uploadBuilder("/" + outFileName).uploadAndFinish(in);
            }
         }
         catch(Exception ex){
            ex.printStackTrace();
         }
    }

    public BufferedImage createShortcut() /*throws AWTException*/ {
        BufferedImage image = null;
        try{
            // determine current screen size
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();
            Rectangle screenRect = new Rectangle(screenSize);
            // create screen shot
            Robot robot = new Robot();
            image = robot.createScreenCapture(screenRect);

            if(flDebug){
                String outFileName = getFileName();
                // save captured image to PNG file
                ImageIO.write(image, "png", new File(outFileName));
                // give feedback
                System.out.println("Saved screen shot (" + image.getWidth() +
                        " x " + image.getHeight() + " pixels) to file \"" +
                        outFileName + "\".");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    return image;
    }

    // Именовать файлы по такому шаблону: 2020100_171004.png
    public String getFileName(){
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String outFileName = String.format("%s.png", formatter.format(now));
        if(flDebug) {
            System.out.println(outFileName);
        }
        return outFileName;
    }
}
