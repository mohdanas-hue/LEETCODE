class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        int groupSize = 1;

        while (curr != null) {
            ListNode groupStart = curr;
            ListNode temp = curr;
            int count = 0;

            while (count < groupSize && temp != null) {
                temp = temp.next;
                count++;
            }

            if (count % 2 == 0) {
                ListNode p = null;
                ListNode node = groupStart;

                for (int i = 0; i < count; i++) {
                    ListNode next = node.next;
                    node.next = p;
                    p = node;
                    node = next;
                }

                if (prev != null)
                    prev.next = p;

                groupStart.next = node;
                prev = groupStart;
                curr = node;
            } else {
                for (int i = 0; i < count; i++) {
                    prev = curr;
                    curr = curr.next;
                }
            }

            groupSize++;
        }

        return head;
    }
}