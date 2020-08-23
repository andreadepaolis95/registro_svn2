package model;


public class Professor implements User {

        private String name;
        private String last;
        private String id;

        public Professor(String name,String last,String id){
            this.name = name;
            this.last = last;
            this.id = id;
        }

        @Override
        public String getFullName() {
            return "Prof " + this.name + " " + this.last;
        }

        @Override
        public String getId(){
            return this.id;
        }

        @Override
        public boolean isProfessor(){
            return true;
        }

    @Override
    public String getCourse() {
        return null;
    }
}
