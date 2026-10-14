
class Solution {
    public String majorityFrequencyGroup(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] count = new int[101];

        for (int f : freq) {
            if (f > 0) {
                count[f]++;
            }
        }

        int maxSize = 0;
        int maxFreq = 0;

        for (int i = 1; i <= 100; i++) {
            if (count[i] > maxSize ||
                (count[i] == maxSize && i > maxFreq)) {
                maxSize = count[i];
                maxFreq = i;
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (freq[i] == maxFreq) {
                ans.append((char) ('a' + i));
            }
        }

        return ans.toString();
    }
}
