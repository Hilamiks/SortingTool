package sorting;

import java.util.*;

class CountSorter {
    void sortByCount(ArrayList<String> toSort, String dataType) {

        HashMap<String, Integer> sortedCounter = null;
        HashMap<Integer, Integer> sortedCounterNums = null;

        switch(dataType) {
            case ("line"):
                System.out.println("Total lines: " + toSort.size());
                sortedCounter = sortText(toSort);
                for (String s : sortedCounter.keySet()) {
                    System.out.println(s + ": " + sortedCounter.get(s) + " time(s), " + (100*sortedCounter.get(s)/toSort.size()) +"%");
                }
                break;
            case ("number"):
                System.out.println("Total numbers: " + toSort.size());
                sortedCounterNums = sortNums(toSort);
                for (Integer i : sortedCounterNums.keySet()) {
                    System.out.println(i + ": " + sortedCounterNums.get(i) + " time(s), " + (100*sortedCounterNums.get(i)/toSort.size()) +"%");
                }
                break;
            default:
                System.out.println("Total words: " + toSort.size());
                sortedCounter = sortText(toSort);
                for (String s : sortedCounter.keySet()) {
                    System.out.println(s + ": " + sortedCounter.get(s) + " time(s), " + (100*sortedCounter.get(s)/toSort.size()) +"%");
                }
                break;
        }
    }

    static HashMap<String, Integer> sortHashMapByValue(HashMap<String, Integer> counter) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(counter.entrySet());

        list.sort(new HashMapEntryComparator().thenComparing(new HashMapEntryComparatorSecondary()));

        HashMap<String, Integer> sortedCounter = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> a : list) {
            sortedCounter.put(a.getKey(), a.getValue());
        }

        return sortedCounter;
    }

    static HashMap<Integer, Integer> sortNumHashMapByValue(HashMap<Integer, Integer> counter) {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(counter.entrySet());

        list.sort(new HashMapNumEntryComparator().thenComparing(new HashMapNumEntryComparatorSecondary()));

        HashMap<Integer, Integer> sortedCounter = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> a : list) {
            sortedCounter.put(a.getKey(), a.getValue());
        }

        return sortedCounter;
    }

    static HashMap<String, Integer> sortText(ArrayList<String> toSort) {
        HashMap<String, Integer> counter = new HashMap<>();
        for (int i = 0; i < toSort.size(); i++) {
            if (!counter.containsKey(toSort.get(i))) {
                counter.put(toSort.get(i), 1);
            } else {
                counter.replace(toSort.get(i), counter.get(toSort.get(i))+1);
            }
        }

        return sortHashMapByValue(counter);
    }

    static HashMap<Integer, Integer> sortNums(ArrayList<String> toSort) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < toSort.size(); i++) {
            if (!counter.containsKey(Integer.parseInt(toSort.get(i)))) {
                counter.put(Integer.parseInt(toSort.get(i)), 1);
            } else {
                counter.replace(Integer.parseInt(toSort.get(i)), counter.get(Integer.parseInt(toSort.get(i)))+1);
            }
        }

        return sortNumHashMapByValue(counter);
    }
}