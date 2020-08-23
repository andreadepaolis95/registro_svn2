package bean;

public class ArgumentBean implements Comparable<ArgumentBean> {

    private String title;
    private String description;
    private int index;

    public ArgumentBean(String title, String description, int index) {
        this.title = title;
        this.description = description;
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(ArgumentBean o) {
        return this.getIndex() - o.getIndex();
    }
}
