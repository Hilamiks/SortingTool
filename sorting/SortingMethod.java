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
                System.out.println("Total words: " + toSort.size() + ".");
                System.out.print("Sorted data: ");
                for (String s : toSort) {
                    System.out.print(s + " ");
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
                System.out.println("Total lines: " + toSort.size() + ".");
                System.out.println("Sorted data: ");
                for (String s : toSort) {
                    System.out.println(s);
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
                System.out.println("Total numbers: " + toSort.size() + ".");
                System.out.print("Sorted data: ");
                for (String s : toSort) {
                    System.out.print(s + " ");
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




















