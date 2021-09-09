import org.w3c.dom.Node;

import java.util.Iterator;
import java.util.LinkedList;

public class CarLinkedList<T> implements CarList<T>, CarQueue<T> {

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public boolean add(T car) {
        if (size == 0) {
            Node node = new Node(null, car, null);
            first = node;
            last = node;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        size++;
        return true;
    }

    @Override
    public T peek() {
        return (size > 0) ? get(0) : null;

    }

    @Override
    public T poll() {
        T car = get(0);
        removeAt(0);
        return car;
    }

    @Override
    public boolean add(T car, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
           return add(car);

        }

        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, car, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(T car) {
        int index = findElement(car);
        if (index != -1){
            return removeAt(index);
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {

        Node node = getNode(index);
        Node nodePrevious = node.previous;
        Node nodeNext = node.next;
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }

        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }

        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clean() {

        first = null;
        last = null;
        size = 0;

    }


    @Override
    public boolean contains(T car) {
        return findElement(car) != -1;
        }


    private Node getNode(int index) {
        if (index < 0 || index >= size){
            throw  new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


    private int findElement(T car){
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(car)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private CarLinkedList.Node node = first;
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                T car = (T) node.value;
                node = node.next;
                return car;
            }
        };
    }


    private  class Node{
        private Node previous;
        private T value;
        private Node next;

        public Node(Node previous, T value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
