package zuobook.binarytreevisit;

import node.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sjh on 2016/8/21.
 * 按层访问二叉树,另外每一层要单独打一行（也要打出这是第几层）
 * 两个变量last用来记录当前层最右的节点，nlast记录last下一层的最右节点
 * 当cur为last时更新last=nlast,问题就变为nlast如何更新
 * 其实很简单，当有节点入队的时候更新nlast为该节点（因为该节点肯定是当前last下一层的最右那个节点了）
 */
public class VisitNodeByLevel {
    public void visitNodeByLevel(Node head){
        if(head == null){
            return;
        }
        Node last = head;//用来记录这一层最右边的那个节点
        Node nlast = null;//用来记录下一层最右边的那个节点
        int level = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        System.out.print("Level "+ level++ +": ");
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.print(cur.value+" ");//打印该节点
            if (cur.left != null){
                queue.offer(cur.left);
                nlast = cur.left;//跟随节点入队更新nlast（因为这肯定是下一层最右的）
            }
            if(cur.right != null){
                queue.offer(cur.right);
                nlast = cur.right;//跟随节点入队更新nlast（因为这肯定是下一层最右的）
            }
            if(cur == last && !queue.isEmpty()){//如果是当前层最后一个节点，且当前不是最后一层，打印下一层的level，并更新last
                System.out.print("\nLevel " + level++ + ": ");
                last = nlast;
            }
        }
        System.out.println();//最后一层需要补一个换行
    }
}
