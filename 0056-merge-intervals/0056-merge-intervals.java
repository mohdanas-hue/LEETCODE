import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort according to starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {

            // No overlap
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[0]) {
                ans.add(interval);
            }

            // Overlap
            else {
                ans.get(ans.size() - 1)[1] =
                    Math.max(ans.get(ans.size() - 1)[1], interval[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}