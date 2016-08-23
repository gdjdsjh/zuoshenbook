package leetcode;

import node.ListNode;
import node.Node;

/**
 * Created by sjh on 2016/8/23.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers_2 {
    /**
     * 此方法太low了，代码太长！！！！！
     * 希望能改进一下！！！
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int meat = 0;//需要进上去的数
        ListNode head = null;
        ListNode cur = null;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        while (l1 != null && l2 != null){
            int sum = l1.value + l2.value + meat;
            meat = 0;
            if(sum > 9){
                meat = sum / 10;
                ListNode node = new ListNode(sum - 10);
                if(head == null){
                    head = node;
                    cur = node;
                }else{
                    cur.next = node;
                    cur= node;
                }
            }else{
                ListNode node = new ListNode(sum);
                if(head == null){
                    head = node;
                    cur = node;
                }else{
                    cur.next = node;
                    cur = node;
                }
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 == null && l2 != null) {
            int sum = l2.value + meat;
                if(sum > 9){
                    meat = sum / 10;
                    ListNode node = new ListNode(sum - 10);
                    if(head == null){
                        head = node;
                        cur = node;
                    }else{
                        cur.next = node;
                        cur= node;
                    }
                }else{
                    meat = 0;
                    ListNode node = new ListNode(sum);
                    if(head == null){
                        head = node;
                        cur = node;
                    }else{
                        cur.next = node;
                        cur = node;
                    }
                }
            l2 = l2.next;
        }
        while(l2 == null && l1 != null){
            int sum = l1.value + meat;
                if(sum > 9){
                    meat = sum / 10;
                    ListNode node = new ListNode(sum - 10);
                    if(head == null){
                        head = node;
                        cur = node;
                    }else{
                        cur.next = node;
                        cur= node;
                    }
                }else{
                    meat = 0;
                    ListNode node = new ListNode(sum);
                    if(head == null){
                        head = node;
                        cur = node;
                    }else{
                        cur.next = node;
                        cur = node;
                    }
                }
            l1 = l1.next;
        }

        if(l1 == null && l2 == null && meat != 0){
            ListNode node = new ListNode(meat);
            cur.next = node;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(8);
//        node.next.next = new ListNode(3);


        ListNode node2 = new ListNode(0);
//        node2.next = new ListNode(6);
//        node2.next.next = new ListNode(4);

        new AddTwoNumbers_2().addTwoNumbers(node, node2);
    }
}
