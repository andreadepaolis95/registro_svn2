package model;

public class Student implements User{


        private String name;
        private String last;
        private String course;
        private String id;

        public Student(String name,String last,String id,String course){
            this.name = name;
            this.last = last;
            this.id = id;
            this.course = course;
        }

        @Override
        public String getFullName() {
            return  this.last + " " + this.name;
        }

        @Override
        public String getId(){
            return this.id;
        }

        @Override
        public boolean isProfessor(){
            return false;
        }


    @Override
    public String getCourse() {
        return this.course;
    }
}
