package model;

public class StudentInfoByRegister {
    private String fullname;
    private String typeReport;
    private String valueReport;
    private String dateReport;

    public StudentInfoByRegister(String fullname , String typeReport , String valueReport , String dateReport){
        this.fullname = fullname;
        this.typeReport = typeReport;
        this.valueReport = valueReport;
        this.dateReport = dateReport;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setTypeReport(String typeReport) {
        this.typeReport = typeReport;
    }

    public void setValueReport(String valueReport) {
        this.valueReport = valueReport;
    }

    public void setDateReport(String dateReport) {
        this.dateReport = dateReport;
    }

    public String getDateReport() {
        return dateReport;
    }

    public String getFullname() {
        return fullname;
    }

    public String getTypeReport() {
        return typeReport;
    }

    public String getValueReport() {
        return valueReport;
    }
}
