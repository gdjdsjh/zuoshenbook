package morris;

import node.Node;

/**
 * Created by sjh on 2016/8/17.
 * Morris神级遍历二叉树法（中序遍历）,O（1）空间复杂度，即不用栈和递归,时间复杂度为O(N)
 */
public class MorrisIn {
    public void morrisIn(Node head){
        if(head == null){
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;
            if (cur2 != null){//第一步骤如果左子树不为null(即该左孩子不是叶子节点)
                while (cur2.right != null && cur2.right != cur1){//找到该左子树的最右节点
                    cur2 = cur2.right;
                }
                if (cur2.right == null){//将左子树的最右节点的右孩子（原本是null）指向cur1
                    cur2.right = cur1;
                    cur1 = cur1.left;//将cur1移到左孩子节点重复第一步骤
                    continue;
                }else {//cur2.right == cur1这种情况说明之前连过了这次是从那个节点右移过来的
                    cur2.right = null;//所以解开该链条
                }
            }
            System.out.print(cur1.value+" ");//是叶子节点直接打印或者是在解开链条之后打印
            cur1 = cur1.right;//打印完节点右移
        }
    }


}
