package zuobook.morris;

import node.Node;

/**
 * Created by sjh on 2016/8/21.
 * Morris遍历二叉树（先序遍历）,O(1)空间复杂度，即不用栈和递归,时间复杂度为O(N)
 */
public class MorrisPre {
    public void mirrisPre(Node head){
        if(head == null){
            return;
        }
        Node cur1 = head;
        Node cur2= null;
        while (cur1 != null){
            cur2 = cur1.left;
            if(cur2 != null){
                while (cur2.right != null && cur2.right != cur1){//寻找cur1左孩子的最右节点
                    cur2 = cur2.right;
                }
                if(cur2.right == null){//说明之前没连过
                    System.out.print(cur1.value + " ");//直接先打印cur1节点
                    cur2.right = cur1;//将cur2的右孩子和cur1连起来
                    cur1 = cur1.left;//cur1左移动重复第一步骤
                    continue;
                }else {//cur2.right == cur1
                    cur2.right = null;
                }
            }else {//cur2 = cur1.left = null的情况下
                System.out.print(cur1.value + " ");//不进入第一步骤了，直接打印当前节点，然后移到下一个节点
            }

            cur1 = cur1.right;//移到下一个节点，进入第一步骤
        }
        System.out.println();
    }
}
