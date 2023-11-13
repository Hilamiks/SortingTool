package sorting;

import java.util.Comparator;
import java.util.Map;

class HashMapEntryComparator implements Comparator<Map.Entry<String,Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> EntryA, Map.Entry<String, Integer> EntryB) {
        return EntryA.getValue().compareTo(EntryB.getValue());
    }
}

class HashMapEntryComparatorSecondary implements Comparator<Map.Entry<String,Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> EntryA, Map.Entry<String, Integer> EntryB) {
        return EntryA.getKey().compareTo(EntryB.getKey());
    }
}

class HashMapNumEntryComparator implements Comparator<Map.Entry<Integer,Integer>> {

    @Override
    public int compare(Map.Entry<Integer, Integer> EntryA, Map.Entry<Integer, Integer> EntryB) {
        return EntryA.getValue().compareTo(EntryB.getValue());
    }
}
class HashMapNumEntryComparatorSecondary implements Comparator<Map.Entry<Integer,Integer>> {

    @Override
    public int compare(Map.Entry<Integer, Integer> EntryA, Map.Entry<Integer, Integer> EntryB) {
        return EntryA.getKey().compareTo(EntryB.getKey());
    }
}
