package io.github.mysterix5.hashmap;

import java.util.HashMap;
import java.util.Map;

public class StudentDB {

    private Map<String, Student> students;

    public Student getById(String id){
        return this.students.get(id);
    }

    public StudentDB(Map<String, Student> students){
        this.students = new HashMap<>(students);
    }

    public void add(Student s){
        students.put(s.getID(), s);
    }

    public void removeByStudent(Student s){
        students.remove(s.getID());
    }
    public void removeById(String s){
        students.remove(s);
    }

    public Map<String, Student> list(){
        return students;
    }

    @Override
    public String toString(){
        String returnString = "StudentDB: \n";
        for(Student s: this.students.values()) {
            returnString += s + "\n";
        }
        returnString += "------";
        return returnString;
    }

    public Student randomStudent() {
        int random = (int)(Math.random()*this.students.size());
        int counter = 0;
        for(Student s: students.values()){
            if(counter==random) return s;
            counter++;
        }

        return null;
    }
}
