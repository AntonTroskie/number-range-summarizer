package com.numberrangesummarizer;

import java.io.Console;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Summarizer mySummarizer = new Summarizer();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter a comma delimited integer array: ");
        Collection<Integer> myCollection = null;
        if (myScanner.hasNext()) myCollection = mySummarizer.collect(myScanner.nextLine());
        assert myCollection != null;
        if (myCollection.size() != 0) {
            System.out.println("\n\nInput: " + myCollection.toString().substring(1, myCollection.toString().length()-1));
            System.out.println("Output: " + mySummarizer.summarizeCollection(myCollection));
        } else {
            System.out.println("Error: incorrect input");
        }
    }
}
