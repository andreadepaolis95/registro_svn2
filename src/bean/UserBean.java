package bean;

import java.util.List;

public class UserBean {

    private String fullName;
    private String course;
    private String id;
    private boolean isProfessor;
    private List<Page> pageList;


    public UserBean(){};


    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public List<Page> getPageList() {
        return pageList;
    }

    public void setPageList(List<Page> pageList) {
        this.pageList = pageList;
    }

    public boolean isProfessor() {
        return this.isProfessor;
    }

    public void setIsProfessor(boolean flag) {
        this.isProfessor = flag;
    }
}
