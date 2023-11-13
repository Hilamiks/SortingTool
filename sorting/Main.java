package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {

        String sortingType = "natural";
        String dataType = "word";
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();

        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-sortingType")) {
                    sortingType = args[i + 1];
                } else if (args[i].equals("-dataType")) {
                    dataType = args[i + 1];
                }
            }
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
                    input.add(scanner.next());
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
    }
}
