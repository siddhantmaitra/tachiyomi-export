package com.smaitra;

import com.google.protobuf.*;
import com.google.protobuf.util.JsonFormat;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
// import com.smaitra.BackupOuterClass;

public class App {
    public static void main(String[] args) {
        try {
            // .tachibk OR .proto.gz OR .gz
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/tachiyomi_test.tachibk");
            GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);

            
            BackupOuterClass.Backup backup = BackupOuterClass.Backup.parseFrom(gzipInputStream);

            // Convert protobuf object to JSON
            String jsonFormat = JsonFormat.printer().print(backup);

            FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/tachiyomi_test.json");
            fileOutputStream.write(jsonFormat.getBytes());

          
            fileOutputStream.close();
            gzipInputStream.close();
            fileInputStream.close();

            System.out.println("Successfully converted .proto.gz to .json");
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
