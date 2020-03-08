package adt;

public interface adt<E> {

    void add(E item);

    E remove();

    int search(E item);

    void sort();

}
