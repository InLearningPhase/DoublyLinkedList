package definition;
import adt.adt;

public class doublyDefinition<E> implements adt<E> {

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
