package sorting;

import java.util.Comparator;

public class NumberComparator implements Comparator<String> {

    @Override
    public int compare(String s, String t) {
        return (int) (Double.parseDouble(s) - Double.parseDouble(t));
    }
}
