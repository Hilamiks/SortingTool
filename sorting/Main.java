package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    static StringBuilder output = new StringBuilder("");
    public static void main(final String[] args) {

        String sortingType = "natural";
        String dataType = "word";
        File inputFile = null;
        File outputFile = null;
        Scanner scanner;
        ArrayList<String> input = new ArrayList<>();

        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-sortingType")) {
                    try {
                        sortingType = args[i + 1];
                    } catch (IndexOutOfBoundsException E) {
                        System.out.println("No sorting type defined!");
                    }
                } else if (args[i].equals("-dataType")) {
                    try {
                        dataType = args[i + 1];
                    } catch (IndexOutOfBoundsException E) {
                        System.out.println("No data type defined!");
                    }
                } else if (args[i].equals("-inputFile")) {
                    inputFile = new File(args[i + 1]);
                } else if (args[i].equals("-outputFile")) {
                    outputFile = new File(args[i + 1]);
                } else if (args[i].startsWith("-")) {
                    System.out.println(args[i] + " is not a valid parameter. It will be skipped.");
                }
            }
        }
        if (inputFile != null) {
            try {
                scanner = new Scanner(inputFile);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            scanner = new Scanner(System.in);
        }

        switch (dataType) {
            case ("line"):
                while (scanner.hasNextLine()) {
                    input.add(scanner.nextLine());
                }
                new ArraySorter(new LineSorting()).sort(input, sortingType);
                break;
            case ("long"):
                while (scanner.hasNext()) {
                    String temp = scanner.next();
                    try {
                        Double.parseDouble(temp);
                        input.add(temp);
                    } catch (Exception E) {
                        System.out.println("\"" + temp + "\" is not a long. It will be skipped.");
                    }
                }
                new ArraySorter(new NumberSorting()).sort(input, sortingType);
                break;
            default:
                while (scanner.hasNext()) {
                    input.add(scanner.next());
                }
                new ArraySorter(new WordSorting()).sort(input, sortingType);
                break;
        }
        scanner.close();
        if (outputFile != null) {
            try (FileWriter writer = new FileWriter(outputFile)) {
                writer.write(output.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(output);
        }
    }
}
