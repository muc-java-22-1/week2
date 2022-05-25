package io.github.mysterix5.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void get_empty() {
        LinkedList ll = new LinkedList();

        assertNull(ll.get(0));
        assertNull(ll.get(100));
        assertNull(ll.get(-1));
    }
    @Test
    void get_something() {
        LinkedList ll = new LinkedList();
        Animal a1 = new Animal("Lion");
        Animal a2 = new Animal("Dolphin");

        ll.add(a1);
        ll.add(a2);

        assertEquals(a1, ll.get(0));
        assertEquals(a2, ll.get(1));
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

    @Test
    void removeFirst(){
        LinkedList ll = new LinkedList();
        Animal a1 = new Animal("Lion");
        Animal a2 = new Animal("Dolphin");
        Animal a3 = new Animal("Dog");

        ll.add(a1);
        ll.add(a2);
        ll.add(a3);

        ll.remove(a1);

        assertEquals(a2, ll.get(0));
        assertEquals(a3, ll.get(1));
    }
    @Test
    void removeMiddle(){
        LinkedList ll = new LinkedList();
        Animal a1 = new Animal("Lion");
        Animal a2 = new Animal("Dolphin");
        Animal a3 = new Animal("Dog");

        ll.add(a1);
        ll.add(a2);
        ll.add(a3);

        ll.remove(a2);

        assertEquals(a1, ll.get(0));
        assertEquals(a3, ll.get(1));
    }
    @Test
    void removeLast(){
        LinkedList ll = new LinkedList();
        Animal a1 = new Animal("Lion");
        Animal a2 = new Animal("Dolphin");
        Animal a3 = new Animal("Dog");

        ll.add(a1);
        ll.add(a2);
        ll.add(a3);

        ll.remove(a3);

        assertEquals(a1, ll.get(0));
        assertEquals(a2, ll.get(1));


    }
    @Test
    void removeNonExisting(){
        LinkedList ll = new LinkedList();
        Animal a1 = new Animal("Lion");
        Animal a2 = new Animal("Dolphin");
        Animal a3 = new Animal("Dog");

        ll.add(a1);
        ll.add(a2);

        ll.remove(a3);

        assertEquals(a1, ll.get(0));
        assertEquals(a2, ll.get(1));
    }
}