package io.github.mysterix5.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void get_empty() {
        LinkedList ll = new LinkedList();

        assertNull(ll.get(0));
        assertNull(ll.get(100));
    }

    @Test
    void add(){
        LinkedList ll = new LinkedList();
        Animal a1 = new Animal("Lion");
        Animal a2 = new Animal("Dolphin");

        ll.add(a1);
        ll.add(a2);

        System.out.println(ll);

        assertEquals(a1, ll.get(0));
        assertEquals(a2, ll.get(1));
    }
}