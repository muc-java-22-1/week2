package io.github.mysterix5.linkedlist;

public class AnimalListItem {
    private Animal value;
    private AnimalListItem next;

    public AnimalListItem(Animal value, AnimalListItem next){
        this.value = value;
        this.next = next;
    }

    public Animal getValue() {
        return value;
    }

    public AnimalListItem next(){
        return next;
    }

    public void setNext(AnimalListItem ali){
        next = ali;
    }
}
