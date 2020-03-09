package definition;
import adt.adt;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class doublyDefinition<E> implements adt<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
     int size = 0;

    public Node<E> getNode(int index) {

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

    private void add(int index, E item) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        else if (index == 0) {
            addFirst(item);
        }
        else {
            addAfter(item, getNode(index - 1));
        }
    }

    @Override
    public void add(E item) {
        add(size, item);
    }

    public E removeFirst() {

        E response = null;
        Node<E> temp = head;
        if (temp != null) {
            head.getNext().previous = null;
            response = head.getData();
            head = head.getNext();
            size--;
        }
        return response;
    }

    public E removeAfter(Node<E> afterNode) {

        E response = null;
        Node<E> temp = afterNode.getNext();
       if (temp.getNext() == null) {
           afterNode.next = null;
           tail = afterNode;
           response = temp.getData();
       }
       else {
           afterNode.next = temp.getNext();
           temp.getNext().previous = afterNode;
           response = temp.getData();
       }
       size--;
       return response;
    }

    private E remove(int index) {

        E response = null;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        else if (index == 0) {
            response = removeFirst();
        }
        else {
            response = removeAfter(getNode(index - 1));
        }
        return response;
    }

    @Override
    public E remove() {
        return remove(size - 1);
    }

    @Override
    public int search(E item) {
        int response = -1;
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.getData().equals(item)) {
                response = i;
                break;
            }
            temp = temp.getNext();
        }
        return response;
    }

    @Override
    public void sort() {

    }

    @Override
    public String toString() {


        StringBuilder stringBuilder = new StringBuilder("[");
        Node<E> currentNode = head;

        for (int i = 0; i < size && currentNode != null; i++) {
            stringBuilder.append(currentNode.getData());
            stringBuilder.append(i < size - 1 ? "," : "");
            currentNode = currentNode.getNext();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
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
