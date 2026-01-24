import java.io.*;

class CopyThread extends Thread {
    File source;
    File destination;

    CopyThread(File source, File destination) {
        this.source = source;
        this.destination = destination;
    }

    public void run() {
        try (
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(destination)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Copied file: " + source.getPath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class DirectoryCopyUsingThread {

    static void copyDirectory(File sourceDir, File destDir) {

        if (!destDir.exists()) {
            destDir.mkdir();
        }

        File[] files = sourceDir.listFiles();
        if (files == null) return;

        for (File file : files) {

            File destFile = new File(destDir, file.getName());

            if (file.isDirectory()) {
                // RECURSIVE call for subdirectory
                copyDirectory(file, destFile);
            } else {
                // THREAD for file copy
                CopyThread t = new CopyThread(file, destFile);
                t.start();
            }
        }
    }

    public static void main(String[] args) {

        File sourceDir = new File("C:\\test_java_example");
        File destDir   = new File("D:\\Maria_Java_Pgms\\java_example_dir");

        if (!sourceDir.exists() || !sourceDir.isDirectory()) {
            System.out.println("Invalid source directory");
            return;
        }

        copyDirectory(sourceDir, destDir);
        System.out.println("Directory copy started...");
    }
}
