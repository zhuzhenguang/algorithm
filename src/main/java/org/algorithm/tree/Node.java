package org.algorithm.tree;

/**
 * User: zhenguang.zhu
 * Date: 14-1-7
 * Time: 下午2:27
 */
public class Node {
    int id;
    double data;
    Node leftChild;
    Node rightChild;

    public Node() {
    }

    public Node(int id, double data) {
        this.id = id;
        this.data = data;
    }
}

class Person {
    long id;
    String name;
}
