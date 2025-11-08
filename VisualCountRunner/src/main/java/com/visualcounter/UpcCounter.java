package com.visualcounter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UpcCounter {

    private static final HashMap<String, Integer> upcMap = new HashMap<>();
    private String upc;

    public UpcCounter() {
        this.upc = "";
    }

    public UpcCounter(String scannedUPC) {
        this.upc = scannedUPC;
    }

    public void hashCheck() {
        // Check if the UPC is already in the map
        if (upcMap.containsKey(this.upc)) {
            // If it exists, get the current count, add 1, and put it back
            int currentCount = upcMap.get(this.upc);
            upcMap.put(this.upc, currentCount + 1);
        } else {
            // If it's a new UPC, put it in the map with a count of 1
            upcMap.put(this.upc, 1);
        }
    }

    public static void runScanner() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nWhen finished scanning, enter 666 to see all values");
        System.out.println("___________________________________________________");

        while (true) {
            System.out.print("Scan a barcode if you dare: ");
            String scannedCode = keyboard.nextLine();

            if (scannedCode.equals("666")) {
                break;
            }
            //creates a temporary UpcCounter object for the runScanner method to use
            UpcCounter tempCounter = new UpcCounter(scannedCode);
            tempCounter.hashCheck();
        }

        keyboard.close();

        System.out.println("\n--- Final Counts ---");
        UpcCounter printer = new UpcCounter("");
        System.out.println(printer.getKeysAndVals());
    }

    //Returns values for user
    public static String getKeysAndVals() {
        StringBuilder keyAndVal = new StringBuilder();
        for (Map.Entry<String, Integer> entry : upcMap.entrySet()) {
            keyAndVal.append("UPC: ");
            keyAndVal.append(entry.getKey());
            keyAndVal.append(", Count: ");
            keyAndVal.append(entry.getValue());
            keyAndVal.append("\n");
        }
        return keyAndVal.toString();
    }

}
