package sorting;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {

    @Override
    public int compare(String s, String t) {
        return s.compareTo(t);
    }
}
