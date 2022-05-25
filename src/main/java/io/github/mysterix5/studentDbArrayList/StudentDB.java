package io.github.mysterix5.studentDbArrayList;

import java.util.ArrayList;

public class StudentDB {

    private ArrayList<Student> students;

    public Student getByArrayIndex(int i){
        return this.students.get(i);
    }

    public StudentDB(ArrayList<Student> students){
        this.students = new ArrayList<>(students);
    }

    public void add(Student s){
        students.add(s);
    }

    public void remove(Student s){
        students.remove(s);
    }
    public void remove(String id){
        int index = findStudentIndexById(id);
        if(index==-1) return;
        students.remove(index);
    }

    private int findStudentIndexById(String id){
        for(int i = 0; i<students.size(); i++) {
            if(students.get(i).getID().equals(id)) return i;
        }
        // throw exception
        return -1;
    }

    public ArrayList<Student> list(){
        return students;
    }

    @Override
    public String toString(){
        String returnString = "";
        for(Student s: this.students) returnString += s.toString() + "; ";
        return returnString;
    }

    public Student randomStudent() {
        int random = (int)(Math.random()*this.students.size());

        return this.students.get(random);
    }
}
