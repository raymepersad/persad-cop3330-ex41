/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rayme Persad
 */

/*Create a program that reads in the following list of names from a file called `exercise41_input.txt` and sorts the list alphabetically:

Ling, Mai
Johnson, Jim
Zarnecki, Sabrina
Jones, Chris
Jones, Aaron
Swift, Geoffrey
Xiong, Fong


Then print the sorted list to a file called `exercise41_output.txt` that looks like the following example output.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

package ex41.Base;

public class nameSorter {
    // defining the readNames() function to read the data from Scanner object to the ArrayList

    public static void readNames(Scanner input, ArrayList<String> names) {

        // reading the data till the file has nextLine

        while (input.hasNextLine()) {

            // adding the read line to the list of names

            names.add(input.nextLine());
        }
    }

    // defining the function to print the names in the file

    public static void outputNames(ArrayList<String> names) throws IOException {

        // creating a FileWriter for the output file

        FileWriter output = new FileWriter("exercise41_output.txt");

        // writing the header of the output file about how many names are read from the input file

        output.write("Total of " + names.size() + " names\n");

        output.write("--------------------\n");

        // writing the names in the file after the header and separator


        for (String i : names) {

            output.write(i + "\n");

        }

        // closing the output FileWriter to avoid memory leakage

        output.close();

    }

    public static void main(String[] args) throws FileNotFoundException {

        // creating an scanner object to read from input file

        Scanner inputFile = new Scanner(new File("exercise41_input.txt"));

        // declaring an ArrayList for storing the names

        ArrayList<String> names = new ArrayList<>();

        // reading the names from the input file by calling the readNames() function

        readNames(inputFile, names);

        // sorting the list of names using sort function

        Collections.sort(names, String.CASE_INSENSITIVE_ORDER);

        // closing the scanner object after reading the file

        inputFile.close();

        // writing the required data to the output file

        try {
            outputNames(names);
        }

        // if any exception is raised in writing to the output file then printing the exception on the console

        catch (Exception e) {
            System.out.println(e);
        }
    }
}
