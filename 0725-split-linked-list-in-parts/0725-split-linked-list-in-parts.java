class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode curr = head;

        while (curr != null) {
            n++;
            curr = curr.next;
        }

        int size = n / k;
        int rem = n % k;

        ListNode[] ans = new ListNode[k];
        curr = head;

        for (int i = 0; i < k; i++) {
            if (curr == null) {
                break;
            }

            ans[i] = curr;

            int len = size + (i < rem ? 1 : 0);

            for (int j = 1; j < len; j++) {
                curr = curr.next;
            }

            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }

        return ans;
    }
}