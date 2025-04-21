import java.io.*;

public class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Compare nodes and add the smaller one to the result
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Add remaining nodes of the non-empty list
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }

        // Return the merged list (skip dummy node)
        return dummy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create first list: 1 -> 3 -> 5
        ListNode list1 = createList(new int[]{1, 3, 5});

        // Create second list: 2 -> 4 -> 6
        ListNode list2 = createList(new int[]{2, 4, 6});

        // Merge the lists
        Solution solution = new Solution();
        ListNode merged = solution.mergeTwoLists(list1, list2);

        // Print the merged list
        printList(merged);  // Expected output: 1 -> 2 -> 3 -> 4 -> 5 -> 6
    }

    // Helper method to create a linked list from an array
    private static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print a linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}

