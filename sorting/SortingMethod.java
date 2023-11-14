package sorting;

import java.util.ArrayList;
import java.util.HashMap;

interface SortingMethod {
    void sort(ArrayList<String> toSort, String sortingType);

}

class WordSorting implements SortingMethod {
    @Override
    public void sort(ArrayList<String> toSort, String sortingType) {
        switch (sortingType) {
            case ("byCount"):
                //System.out.println("sorting words by count");
                new CountSorter().sortByCount(toSort, "word");
                break;
            default:
                //System.out.println("sorting words naturally");
                toSort.sort(new StringComparator());
                Main.output.append("\nTotal words: ").append(toSort.size()).append(".");
                Main.output.append("\nSorted data: ");
                for (String s : toSort) {
                    Main.output.append(s).append(" ");
                }
                break;

        }
    }
}

class LineSorting implements SortingMethod {
    @Override
    public void sort(ArrayList<String> toSort, String sortingType) {
        switch (sortingType) {
            case ("byCount"):
                //System.out.println("sorting lines by count");
                new CountSorter().sortByCount(toSort, "line");
                break;
            default:
                //System.out.println("sorting lines naturally");
                toSort.sort(new StringComparator());
                Main.output.append("\nTotal lines: " + toSort.size() + ".\n");
                Main.output.append("Sorted data: \n");
                for (String s : toSort) {
                    Main.output.append(s).append("\n");
                }
                break;

        }
    }
}

class NumberSorting implements SortingMethod {
    @Override
    public void sort(ArrayList<String> toSort, String sortingType) {
        switch (sortingType) {
            case ("byCount"):
                //System.out.println("sorting numbers by count");
                new CountSorter().sortByCount(toSort, "number");
                break;
            default:
                //System.out.println("sorting numbers naturally");
                toSort.sort(new NumberComparator());
                Main.output.append("\nTotal numbers: ").append(toSort.size()).append(".");
                Main.output.append("\nSorted data: ");
                for (String s : toSort) {
                    Main.output.append(s).append(" ");
                }
                break;
        }
    }
}

class ArraySorter {

    private SortingMethod method;

    ArraySorter (SortingMethod method) {
        this.method = method;
    }

    void sort(ArrayList<String> toSort, String sortingType) {
        this.method.sort(toSort, sortingType);
    }

}




















