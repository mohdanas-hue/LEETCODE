class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> set = solve(expression, 0, expression.length() - 1);
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    Set<String> solve(String s, int l, int r) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        int i = l;

        while (i <= r) {
            if (s.charAt(i) == ',') {
                result.addAll(current);
                current = new HashSet<>();
                current.add("");
                i++;
            } 
            else if (s.charAt(i) == '{') {
                int count = 1;
                int j = i + 1;

                while (count != 0) {
                    if (s.charAt(j) == '{') count++;
                    else if (s.charAt(j) == '}') count--;
                    j++;
                }

                Set<String> inside = solve(s, i + 1, j - 2);
                current = combine(current, inside);
                i = j;
            } 
            else {
                String ch = String.valueOf(s.charAt(i));
                Set<String> temp = new HashSet<>();

                for (String x : current) {
                    temp.add(x + ch);
                }

                current = temp;
                i++;
            }
        }

        result.addAll(current);
        return result;
    }

    Set<String> combine(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}