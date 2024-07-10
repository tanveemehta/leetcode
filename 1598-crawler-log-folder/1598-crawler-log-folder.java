class Solution {
    public int minOperations(String[] logs) {
        Stack<String> st = new Stack<>();

        for (String currentOperation : logs) {
            if (currentOperation.equals("../")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (!currentOperation.equals("./")) {
                st.push(currentOperation);
            }
        }

        return st.size();
    }
}