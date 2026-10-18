class Solution {
    public int similarPairs(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (same(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    boolean same(String a, String b) {
        int x = 0, y = 0;

        for (char c : a.toCharArray()) {
            x |= 1 << (c - 'a');
        }

        for (char c : b.toCharArray()) {
            y |= 1 << (c - 'a');
        }

        return x == y;
    }
}