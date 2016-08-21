package morris;

import node.Node;

/**
 * Created by sjh on 2016/8/21.
 * Moriis遍历二叉树，后序遍历（三种顺序里面最复杂的一种）
 *其实过程是一致的，只是打印的时机变了，以及方法也不太一样，需要好好琢磨
 * 第一阶段一致，在第二阶段满足条件1的时候逆序打印cur1的左子树的右边界
 *
 * 详细步骤一，步骤二可以看左神书里的p108
 */
public class MoriisPost {
    public void morrisPost(Node head){
        if(head == null){
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;
            if (cur2 != null){
                while (cur2.right != null && cur2.right != cur1){//找到cur1左子树的最右子节点
                    cur2 = cur2.right;
                }
                if(cur2.right == null){//没连过
                    cur2.right = cur1;//连起来之后cur1左移，继续步骤一
                    cur1 = cur1.left;
                    continue;
                }else{//cur2.right == cur1 连过了
                    cur2.right = null;//解开链条，逆序打印cur1的左子树的右边界
                    printEdge(cur1.left);
                }
                cur1 = cur1.right;
            }
        }
        //在最右那个子节点结束的时候，把这棵树的右边界逆序打印（因为这颗树不属于任何树的左子树，只能单独打印）
        printEdge(head);
        System.out.println();
    }

    private void printEdge(Node head){
        Node tail = reverseNode(head);//逆序
        Node cur = tail;//tail后面有用，所以得用一个新的变量来做访问用
        while (cur != null){
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseNode(tail);//再调整回原来的
    }

    private Node reverseNode(Node head){
        Node pre = null;
        Node next;
        while (head != null){
            next = head.right;//拿到head的右孩子
            head.right = pre;//head的右孩子换方向
            pre = head;//这次处理完的节点作为下一次的pre
            head = next;//head变为head未调整前的下一个节点，继续循环
        }
        return pre;//跳出循环的时候，head是最右子节点的右孩子（为null）,所以pre是想要的最右子节点
    }
}
