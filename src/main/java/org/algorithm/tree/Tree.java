package org.algorithm.tree;

/**
 * User: zhenguang.zhu
 * Date: 14-1-7
 * Time: 下午2:30
 */
public class Tree {
    Node root = new Node();

    public Node find(int id) {
        Node current = root;
        while (current.id != id) {
            if (id < current.id)
                current = current.leftChild;
            else
                current = current.rightChild;
            if (current == null)
                return null;
        }
        return current;
    }

    public void insert(int id, double data) {
        Node current = root;
        while (true) {
            if (id < current.id) {
                if (current.leftChild == null) {
                    current.leftChild = new Node(id, data);
                    break;
                } else {
                    current = current.leftChild;
                }
            } else {
                if (current.rightChild == null) {
                    current.rightChild = new Node(id, data);
                    break;
                } else {
                    current = current.rightChild;
                }
            }
        }
    }

    public void delete(int id) {

    }

    public static void main(String[] args) {
        Tree theTree = new Tree();
        theTree.insert(50, 1.5);
        theTree.insert(25, 1.7);
        theTree.insert(40, 1.9);

        Node found = theTree.find(25);

    }
}
