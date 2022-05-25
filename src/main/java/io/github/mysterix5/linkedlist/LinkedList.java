package io.github.mysterix5.linkedlist;

public class LinkedList {
    private AnimalListItem head;

    public LinkedList(){
        head = new AnimalListItem(null, null);
    }

    public Animal get(int index){
        AnimalListItem ali = getAnimalListItemByIndex(index);
        if(ali==null) return null;
        return ali.getValue();
    }

    private AnimalListItem getAnimalListItemByIndex(int index){
        AnimalListItem iterator = head;
        if(index<0) {
            System.out.println("Method needs a valid index");
            return null;
        }
        if(head.next()==null) {
            System.out.println("LinkedList is empty");
            return null;
        }
        if(index==0) return head.next();
        while(index>=0 && iterator.next()!=null) {
            iterator = iterator.next();
            index--;
        }
        if(index>=0){
            System.out.println("LinkedList is shorter than your given index; returning null!");
            return null;
        }

        return iterator;
    }

    public void add(Animal value){
        var lastEl = getLast();
        lastEl.setNext(new AnimalListItem(value, null));
    }

    private AnimalListItem getLast(){
        AnimalListItem iterator = head;
        while(iterator.next()!=null) iterator = iterator.next();
        return iterator;
    }

    @Override
    public String toString() {
        if(head.next()==null) return "List is empty";
        var iterator = head.next();
        String returnString = "" + iterator.getValue().toString();
        while(iterator.next()!=null){
            iterator = iterator.next();
            returnString += " -> " + iterator.getValue().toString();
        }
        return returnString;
    }

    public void remove(Animal a) {
        var iterator = head;
        while(iterator.next()!=null){
            if(iterator.next().getValue().equals(a)) {
                iterator.setNext(iterator.next().next());
                return;
            }
            iterator = iterator.next();
        }
        System.out.println("Element not found in LinkedList and therefore not removed.");
    }

    public void remove(int i) {
        if(head.next()==null) {
            System.out.println("LinkedList is empty, didnt remove anything");
            return;
        }
        AnimalListItem before;
        if(i == 0) {
            before = head;
        }
        else {
            before = getAnimalListItemByIndex(i-1);
        }
        if(before==null) {
            return;
        }
        if(before.next()==null) {
            before.setNext(null);
            return;
        }
        before.setNext(before.next().next());
    }
}
