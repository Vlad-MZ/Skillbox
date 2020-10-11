package com.company;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        String ACCESS_TOKEN = "FP1aP2Q8-Q4AAAAAAAAAARFLKiRU6GzmC5vX5SA4PnWE93BdT6e-Gsvfhm6vwhgx"; // copy it to here
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

//      while(true){
        for(int i = 0 ; i < 3; i++){
            // creat and start new thread
            MyThread thread = new MyThread(client);
            thread.start();

            try{
                Thread.sleep(5000);
            }
            catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }

}
