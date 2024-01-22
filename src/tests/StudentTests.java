package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import listClasses.BasicLinkedList;
import listClasses.SortedLinkedList;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentTests {

    // Tests for SortedLinkedList class

    @Test
    public void testGetFirst() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>(new IntegerComparator());
        list.add(5);
        list.add(2);
        list.add(8);

        assertEquals(2, (int) list.getFirst());//2 not 5 because it's sorted
    }

    @Test
    public void testGetLast() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>(new IntegerComparator());
        list.add(5);
        list.add(2);
        list.add(8);

        assertEquals(8, (int) list.getLast());
    }

    @Test
    public void testGetSize() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>(new IntegerComparator());
        list.add(5);
        list.add(2);
        list.add(8);

        assertEquals(3, list.getSize());
    }

    @Test
    public void testSortedLinkedListAdd() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>(new IntegerComparator());
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);

        assertEquals(1, (int) list.getFirst());
        assertEquals(8, (int) list.getLast());
        assertEquals(4, list.getSize());
    }

    @Test
    public void testSortedLinkedListRemove() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>(new IntegerComparator());
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);

        list.remove(2);

        assertEquals(1, (int) list.getFirst());
        assertEquals(8, (int) list.getLast());
        assertEquals(3, list.getSize());
    }

    // Tests for BasicLinkedList class
    // Tests getSize, getFirst, and getLast in most of the tests

    @Test
    public void testBasicLinkedListAddToEnd() {
        BasicLinkedList<String> list = new BasicLinkedList<>();
        list.addToEnd("apple");
        list.addToEnd("banana");
        list.addToEnd("cherry");

        assertEquals("apple", list.getFirst());
        assertEquals("cherry", list.getLast());
        assertEquals(3, list.getSize());
    }

    @Test
    public void testBasicLinkedListAddToFront() {
        BasicLinkedList<String> list = new BasicLinkedList<>();
        list.addToFront("apple");
        list.addToFront("banana");
        list.addToFront("cherry");

        assertEquals("cherry", list.getFirst());
        assertEquals("apple", list.getLast());
        assertEquals(3, list.getSize());
    }

    @Test
    public void testBasicLinkedListRemove() {
        // Create a basic linked list
        BasicLinkedList<Integer> list = new BasicLinkedList<>();
        list.addToEnd(1).addToEnd(2).addToEnd(3).addToEnd(2).addToEnd(4).addToEnd(5).addToEnd(2);

        // Remove all instances of 2 from the list
        list.remove(2, new IntegerComparator());

        // Expected output: [1, 3, 4, 5]
        assertEquals(1, (int) list.getFirst());
        assertEquals(4, list.getSize());
        assertEquals(5, (int) list.getLast());
    }

    @Test
    public void testBasicLinkedListRetrieveFirstElement() {
        BasicLinkedList<Integer> list = new BasicLinkedList<>();
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);

        int retrieved = list.retrieveFirstElement();

        assertEquals(1, retrieved);
        assertEquals(2, (int) list.getFirst());
        assertEquals(3, (int) list.getLast());
        assertEquals(2, list.getSize());
    }

    @Test
    public void testBasicLinkedListRetrieveLastElement() {
        BasicLinkedList<Integer> list = new BasicLinkedList<>();
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);

        int retrieved = list.retrieveLastElement();

        assertEquals(3, retrieved);
        assertEquals(1, (int) list.getFirst());
        assertEquals(2, (int) list.getLast());
        assertEquals(2, list.getSize());
    }

    @Test
    public void testGetReverseArrayList() {
        BasicLinkedList<Integer> linkedList = new BasicLinkedList<>();
        linkedList.addToEnd(1).addToEnd(2).addToEnd(3).addToEnd(4).addToEnd(5);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(4);
        expected.add(3);
        expected.add(2);
        expected.add(1);

        ArrayList<Integer> reverseArrayList = linkedList.getReverseArrayList();
        assertEquals(reverseArrayList, expected);
    }

    @Test
    public void testGetReverseList() {
        // Create a basic linked list
        BasicLinkedList<Integer> list = new BasicLinkedList<>();
        list.addToEnd(1).addToEnd(2).addToEnd(3).addToEnd(4).addToEnd(5);

        // Get the reverse list
        BasicLinkedList<Integer> reverseList = list.getReverseList();
        assertEquals((int) reverseList.getFirst(), 5);
        assertEquals((int) reverseList.getLast(), 1);
        assertEquals(reverseList.getSize(), 5);
    }

    public class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
}
