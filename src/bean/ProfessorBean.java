package bean;

import model.Matter;

import java.util.List;

public class ProfessorBean {

    private String fullName;
    private List<Matter> matterList;
    private Matter matter;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Matter> getMatterList() {
        return matterList;
    }

    public void setMatterList(List<Matter> matterList) {
        this.matterList = matterList;
    }

    public Matter getMatter() {
        return matter;
    }

    public void setMatter(Matter matter) {
        this.matter = matter;
    }


}
