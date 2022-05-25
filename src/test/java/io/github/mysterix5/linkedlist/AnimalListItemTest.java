package io.github.mysterix5.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalListItemTest {

    @Test
    void getValue() {
        Animal a = new Animal("wuff");
        AnimalListItem ali = new AnimalListItem(a, null);

        assertEquals(a, ali.getValue());
    }

    @Test
    void next() {
        Animal a1 = new Animal("wuff");
        Animal a2 = new Animal("Kräh");
        AnimalListItem ali2 = new AnimalListItem(a2, null);
        AnimalListItem ali1 = new AnimalListItem(a1, ali2);

        assertNull( ali2.next());
        assertEquals(ali2, ali1.next());
    }

    @Test
    void setNext() {
        Animal a1 = new Animal("wuff");
        Animal a2 = new Animal("Kräh");
        AnimalListItem ali2 = new AnimalListItem(a2, null);
        AnimalListItem ali1 = new AnimalListItem(a1, ali2);

        assertNull( ali2.next());
        assertEquals(ali2, ali1.next());

        ali2.setNext(ali1);
        assertEquals(ali1, ali2.next());
    }
}