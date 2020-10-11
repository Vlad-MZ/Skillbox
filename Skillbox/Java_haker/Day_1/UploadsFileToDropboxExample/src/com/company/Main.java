//
//  App: skillbox_java_20201010     --- all works!..
//
package com.company;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class Main {
    // "<ACCESS TOKEN>";
    private static final String ACCESS_TOKEN = "FP1aP2Q8-Q4AAAAAAAAAARFLKiRU6GzmC5vX5SA4PnWE93BdT6e-Gsvfhm6vwhgx";

    public static void main(String args[]) throws DbxException, IOException {
        // Create Dropbox client
        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        // Get current account info
        FullAccount account = client.users().getCurrentAccount();
        System.out.println(account.getName().getDisplayName());

        // Get files and folder metadata from Dropbox root directory
        ListFolderResult result = client.files().listFolder("");
        while (true) {
            for (Metadata metadata : result.getEntries()) {
                System.out.println(metadata.getPathLower());
            }

            if (!result.getHasMore()) {
                break;
            }

            result = client.files().listFolderContinue(result.getCursor());
        }

        // Upload our file  to Dropbox:
        //      "C:/Users/User/IdeaProjects/Skillbox/Java_haker/Day_1/GetScreenshot/myScreenshot.png"
        String fname = "C:/Users/User/IdeaProjects/Skillbox/Java_haker/Day_1/GetScreenshot/myScreenshot.png";
        try (InputStream in = new FileInputStream(fname)) {
            FileMetadata metadata = client.files().uploadBuilder("/myScreenshot.png")
                    .uploadAndFinish(in);
        }
    }
}