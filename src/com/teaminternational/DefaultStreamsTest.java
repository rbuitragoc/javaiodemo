package com.teaminternational;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DefaultStreamsTest {

    private void testDefaultOutputStreams() {
        System.out.println("Hola Mundo!");
        System.err.println("Un error en la segund linea de codigo!");
    }

    private void testDefaultInputStream() throws IOException, InterruptedException {
        System.out.print("Ingrese algo de texto: ");
        while (System.in.available() == 0) {
            Thread.currentThread().sleep(100L);
        }
        int avl = System.in.available();
        byte[] allBytes = System.in.readNBytes(avl);
        System.out.println(String.format("\nCadena de caracteres leida con system in: %s", new String(allBytes)));
    }


    public void testScannerLiveCoding() {
        try (Scanner sc = new Scanner(System.in)) {
            boolean readyForExit = false;
            while(sc.hasNext()) {
                System.out.println("EsBcriba un valor decimal muy grande y presione ENTER:");
                BigDecimal biggie = sc.nextBigDecimal();
                System.out.println("Leido desde teclado: " + biggie);
//                if (linea.equalsIgnoreCase("EXIT")) {
//                    readyForExit = true;
//                    break;
//                }
            }
            if (readyForExit) {
                System.out.println("Terminando ...");
                sc.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void testScanner() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Keyboard interrupt, exiting");
            }
        });

        System.out.println("Ingresar una expresion booleana o un valor booleano:");

        try (Scanner inputScanner = new Scanner(System.in)) {
            while (inputScanner.hasNext()) {
//                String inputText = inputScanner.nextLine();
//                if (inputText.matches("EXIT")) {
//                    System.out.println("Exiting... ");
//                    inputScanner.close();
//                } else {
                    boolean inputBool = inputScanner.nextBoolean();
                    System.out.println(String.format("Booleano leido con scanner: '%s'", inputBool));
//                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Asegurese de entrar booleanos!");
            System.exit(-9);
        }
    }

    public static void main(String ... args) throws IOException, InterruptedException {
        DefaultStreamsTest testClass = new DefaultStreamsTest();
//        testClass.testDefaultInputStream();
//        testClass.testDefaultOutputStreams();
        testClass.testScannerLiveCoding();
    }
}
