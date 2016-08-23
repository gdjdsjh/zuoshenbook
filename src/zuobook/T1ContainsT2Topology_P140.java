package zuobook;

import node.Node;

/**
 * Created by sjh on 2016/8/23.
 * 判断T1树是否包含t2树全部的拓扑结构
 */
public class T1ContainsT2Topology_P140 {
    public boolean contains(Node t1, Node t2){
        if(t2 == null){
            return true;
        }
        if(t1 == null){
            return false;
        }
        return check(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
    }

    public boolean check(Node h, Node t2){
        if(t2 == null){
            return true;
        }
        if(h == null){
            return false;
        }
        if(h.value != t2.value){
            return false;
        }
        return check(h.left, t2.left) && check(h.right, t2.right);
    }


    public static void main(String[] args) {
        /**
         * 左神书里的例子
         */
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);
        t1.right.left = new Node(6);
        t1.right.right = new Node(7);
        t1.left.left.left = new Node(8);
        t1.left.left.right = new Node(9);
        t1.left.right.left = new Node(10);

        Node t2 = new Node(2);
        t2.left = new Node(4);
        t2.left.left = new Node(8);
        t2.right = new Node(5);

        System.out.println(new T1ContainsT2Topology_P140().contains(t1, t2));
    }
}
