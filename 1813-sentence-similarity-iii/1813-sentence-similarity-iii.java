import java.util.*;

class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        // Ensure s1 is the longer string
        if (s1.length() < s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        // Split the strings into Deques
        Deque<String> deq1 = new LinkedList<>(Arrays.asList(s1.split(" ")));
        Deque<String> deq2 = new LinkedList<>(Arrays.asList(s2.split(" ")));

        // Remove matching words from the front
        while (!deq1.isEmpty() && !deq2.isEmpty() && deq1.peekFirst().equals(deq2.peekFirst())) {
            deq1.pollFirst();
            deq2.pollFirst();
        }

        // Remove matching words from the back
        while (!deq1.isEmpty() && !deq2.isEmpty() && deq1.peekLast().equals(deq2.peekLast())) {
            deq1.pollLast();
            deq2.pollLast();
        }

        // If deq2 is empty, then s2 is a sub-sequence of s1
        return deq2.isEmpty();
    }
}