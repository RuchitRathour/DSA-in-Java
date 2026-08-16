/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
    //    if (head == null || head.next == null) return null;

    //     ListNode slow = head;
    //     ListNode fast = head;

    //     // Step 1: Detect cycle using slow and fast pointers
    //     while (fast != null && fast.next != null) {
    //         slow = slow.next;
    //         fast = fast.next.next;

    //         // Cycle found
    //         if (slow == fast) {
    //             break;
    //         }
    //     }

    //     // If no cycle
    //     if (fast == null || fast.next == null) {
    //         return null;
    //     }

    //     // Step 2: Find the start of the cycle
    //     slow = head;  // move slow to head

    //     while (slow != fast) {
    //         slow = slow.next;
    //         fast = fast.next; // both move one step
    //     }

    //     return slow;  // this is the start of the cycle 


    ListNode slow = head;
    ListNode fast = head;

    // Phase 1: Cycle detect
    while (fast != null && fast.next != null) {

        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {

            // Phase 2: Find cycle start
            slow = head;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }
    }

    return null;

    }
}