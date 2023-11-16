package pages;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

import setup.PropertyLoader;
 

public class DownloadVerification {
    public static boolean isFileDownloaded(String expectedFileName, String fileExtension, int timeOut) throws IOException {
    	PropertyLoader.loadProperty(fileExtension);
        String folderName = PropertyLoader.loadProperty("download.folder.path");
        System.out.println("Download Folder Path: " + folderName);
        System.out.println("Make sure the folder path is correct!");

        File[] listOfFiles;
        String fileName;
        boolean fileDownloaded = false;
        long startTime = Instant.now().toEpochMilli();
        long waitTime = startTime + timeOut;

        while (Instant.now().toEpochMilli() < waitTime) {
            listOfFiles = new File(folderName).listFiles();

            assert listOfFiles != null;
            for (File file : listOfFiles) {
                fileName = file.getName();

                if (!fileName.contains("crdownload") && fileName.contains(expectedFileName) && fileName.contains(fileExtension)) {
                    System.out.println("Name of the found file: " + fileName);
                    fileDownloaded = true;
                    file.delete();
                    break;
                }
            }
            if (fileDownloaded)
                break;
        }
        return fileDownloaded;
    }


}
