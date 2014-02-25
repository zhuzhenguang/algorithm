package org.algorithm.node;

/**
 * 链表节点
 * <p/>
 * User: zhenguang.zhu
 * Date: 14-2-25
 * Time: 上午10:04
 */
public class Node<E> {
    private Node<E> next;
    private Node<E> previous;
    private E element;

    public Node(Node<E> next, Node<E> previous) {
        this.next = next;
        this.previous = previous;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }
}
