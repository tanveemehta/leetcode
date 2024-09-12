class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Create a set of allowed characters
        HashSet<Character> allowedSet = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            allowedSet.add(ch);
        }

        int count = 0;

        // Iterate over each word in words
        for (String word : words) {
            boolean allCharAllowed = true;

            // Check if every character in the word is in the allowedSet
            for (char ch : word.toCharArray()) {
                if (!allowedSet.contains(ch)) {
                    allCharAllowed = false;
                    break;
                }
            }

            // Increment count if all characters are allowed
            if (allCharAllowed) {
                count++;
            }
        }

        return count;
    }
}