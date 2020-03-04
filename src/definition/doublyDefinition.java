package definition;
import adt.adt;

public class doublyDefinition<E> implements adt<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private Node<E> getNode(int index) {

        Node<E> response = head;
        for (int i = 0; i < index && response!=null; i++) {
            response = response.getNext();
        }
        return response;
    }

    private void addFirst(E item) {

     if (head == null) {
         Node<E> newNode = new Node<>(item, null, null);
         head = newNode;
         tail = newNode;
     }
     else {
         Node<E> newNode = new Node<>(item, head, null);
         head.previous = newNode;
         head = newNode;
     }
     size++;
    }

    private void addAfter(E item, Node<E> afterNode) {

       Node<E> temp = afterNode.getNext();
        if (temp == null) {
            Node<E> newNode = new Node<>(item, temp, afterNode);
            afterNode.next = newNode;
            tail = newNode;
        }
        else {
            Node<E> newNode = new Node<>(item, temp, afterNode);
            afterNode.next = newNode;
            temp.previous = newNode;
        }
        size++;
    }

    @Override
    public void add(E item) {

    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public int search(E item) {
        return 0;
    }

    @Override
    public void sort() {

    }

    @Override
    public void print() {

    }

    private static class Node<E> {

        private E data;
        private Node<E> next;
        private Node<E> previous;

        private Node(E data) {
            this.data = data;
        }

        private Node(E data, Node<E> next, Node<E> previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrevious() {
            return previous;
        }
    }
}
