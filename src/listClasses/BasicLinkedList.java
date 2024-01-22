package listClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BasicLinkedList<T> implements Iterable<T> {
    protected Node head;
    protected Node tail;
    protected int N;

    public BasicLinkedList() {
        N = 0;
        head = null;
        tail = null;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        Node current = head;
        while (current != tail) {
            s.append(current.data + ", ");
            current = current.next;
        }
        return s.toString();
    }

    public int getSize() {
        return N;
    }

    public BasicLinkedList<T> addToEnd(T data) {
        if (head == null) {
            N++;
            head = new Node(data);
            tail = head;
        } else {
            Node newTail = new Node(data);
            Node oldTail = tail;
            tail = newTail;
            oldTail.next = tail;
            tail.prev = oldTail;
            N++;
        }

        return this;
    }

    public BasicLinkedList<T> addToFront(T data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
            N++;
        } else {
            Node newHead = new Node(data);
            Node oldfirst = head;
            head = newHead;
            head.next = oldfirst;
            oldfirst.prev = head;
            N++;
        }

        return this;
    }

    public T getFirst() {
        return head.data;
    }

    public T getLast() {
        return tail.data;
    }

    public T retrieveFirstElement() {
        if (head == null)
            throw new NullPointerException("List is empty");
        Node copy = head;
        head = head.next;
        N--;
        return copy.data;
    }

    public T retrieveLastElement() {
        if (head == null)
            throw new NullPointerException("List is empty");
        Node copy = tail;
        tail.prev.next = null;
        N--;
        tail = tail.prev;
        return copy.data;
    }

    public BasicLinkedList<T> remove(T targetData, Comparator<T> comparator) {
        Node copy = head;
        while (copy != null) {
            if (copy == head) {
                if (comparator.compare(copy.data, targetData) == 0) {
                    head = head.next;
                    N--;
                }
            } else {
                if (copy.next != null) {
                    if (comparator.compare(copy.data, targetData) == 0) {
                        copy.prev.next = copy.next;
                        copy.next.prev = copy.prev;
                        N--;
                    }
                }
                if (copy.next == null) {
                    if (comparator.compare(copy.data, targetData) == 0) {
                        copy.prev.next = copy.next;
                        N--;
                        tail = copy.prev;
                    }
                }
            }
            copy = copy.next;
        }
        return this;
    }

    public ArrayList<T> getReverseArrayList() {
        ArrayList<T> arrayList = new ArrayList<>();
        addReverseToArrayList(head, arrayList);
        return arrayList;
    }

    private void addReverseToArrayList(Node node, ArrayList<T> arrayList) {
        if (node == null) {
            return;
        }

        addReverseToArrayList(node.next, arrayList);
        arrayList.add(node.data);
    }

    public BasicLinkedList<T> getReverseList() {
        BasicLinkedList<T> reversedList = new BasicLinkedList<>();
        reverseHelper(head, reversedList);
        return reversedList;
    }

    private void reverseHelper(Node node, BasicLinkedList<T> reversedList) {
        if (node == null) {
            return;
        }
        reverseHelper(node.next, reversedList);
        reversedList.addToEnd(node.data);
    }

    class Node {
        protected T data;
        protected Node prev;
        protected Node next;

        Node(T item) {
            data = item;
            prev = null;
            next = null;
        }

        Node() {
            data = null;
            prev = null;
            next = null;
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            Node current = head;
            while (current != tail) {
                s.append(current.data + ", ");
                current = current.next;
            }
            return s.toString();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;
            private Node lastReturned = null;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                lastReturned = current;
                current = current.next;
                return lastReturned.data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

    }
}
