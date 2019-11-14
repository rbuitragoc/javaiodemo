package com.teaminternational;

import java.io.*;

public class WriteToFileTest {

    private static final String FILENAME = "file.txt";

    private void writeToFile(String text) throws IOException {
    // create File instance
        File f = new File(FILENAME);
    // print text to be written to file
        System.out.println("Printing this text: " + text);
    // print file details (name, path)
        String ruta = f.getCanonicalPath();
        System.out.println("File written at (canonical) " + ruta);
        System.out.println("File written at (absolute) " + f.getAbsolutePath());
    // Create FileOutputStream instance
        FileOutputStream fos = new FileOutputStream(FILENAME);
    // write using fos
        fos.write(text.getBytes());
        // close output stream
        fos.close();
    // print file size and exit
        long size = f.length();
        System.out.println("File is " + size + " bytes.");
    }



















    private String readFromFile() {
        String texto = null;
    // create file instance
        File file = new File(FILENAME);
    // print file path
        System.out.println("Reading from file " + file.getAbsolutePath());
    // create file input stream instance
        try (FileInputStream fis = new FileInputStream(FILENAME)) {
    // find out available content size
            int disponible = fis.available();
    // read available content in bytes
            byte[] bytes = fis.readNBytes(disponible);
    // return string built from bytes
            texto = new String(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return texto;
    }








    private boolean deleteFile() {
       // create file instance
        File file = new File(FILENAME);
        // print file path
        System.out.println(String.format("Attempting to delete file at %s", file.getAbsolutePath()));
        // perform delete
        boolean wasDeleted = file.delete();
        // print whether delete succeeded or not
        return wasDeleted;
    }

    private boolean verifyFileExists() {
        // create file instance
        // print file path
        // assess whether file exists or not
        return false;
    }



















    public static void main(String[] args) throws IOException {
        WriteToFileTest test = new WriteToFileTest();
        test.writeToFile("Texto para escribir");
        String contents = test.readFromFile();
        System.out.println("File contents are: '" + contents + "'");
        boolean wasDeleted = test.deleteFile();
        System.out.println("File was deleted? " + wasDeleted);
    }
}
