package io.github.mysterix5.linkedlist;

public class LinkedList {
    private AnimalListItem head;

    public LinkedList(){
        head = new AnimalListItem(null, null);
    }

    public Animal get(int index){
        System.out.println("linkedlist get start");
        AnimalListItem iterator = head;
        if(index<0) {
            System.out.println("Method needs a valid index");
        }
        if(head.next()==null) {
            System.out.println("LinkedList is empty");
            return null;
        }
        while(index>=0 && iterator.next()!=null) {
            System.out.println("value: " + iterator.next().getValue());
            iterator = iterator.next();
            index--;
            /*if(iterator.next()==null){
                System.out.println("LinkedList is shorter than your given index; returning null!");
                return null;
            }*/
        }
        if(index>=0){
            System.out.println("LinkedList is shorter than your given index; returning null!");
            return null;
        }

        System.out.println("linkedlist get end");
        return iterator.getValue();
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
}
