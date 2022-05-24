package io.github.mysterix5.inheritance;

public class StudentDB {

    private Student[] students;

    public Student getByArrayIndex(int i){
        return this.students[i];
    }

    public StudentDB(Student[] students){
        this.students = students;
    }

    public void add(Student s){
        Student[] s1 = new Student[this.students.length+1];
        for(int i = 0; i<this.students.length; i++) s1[i] = this.students[i];
        s1[this.students.length] = s;
        this.students = s1;
    }

    public void remove(String id){
        if(!containsStudentWithId(id)) return;
        Student[] newStudentList = new Student[this.students.length-1];
        int addup = 0;
        for(int i = 0; i< newStudentList.length; i++){
            System.out.println("i: " + i);
            if((this.students[i].getID().equals(id))) {
                System.out.println(this.students[i]);
                System.out.println(this.students[i].getID());
                addup++;
            }
            newStudentList[i] = this.students[i+addup];
        }
        this.students = newStudentList;
    }
    private boolean containsStudentWithId(String id){
        for(Student s: this.students) if(s.getID().equals(id)) return true;
        return false;
    }

    public Student[] list(){
        return students;
    }

    @Override
    public String toString(){
        String returnString = "";
        for(Student s: this.students) returnString += s.toString() + "; ";
        return returnString;
    }

    public Student randomStudent() {
        int random = (int)(Math.random()*this.students.length);

        return this.students[random];
    }
}
