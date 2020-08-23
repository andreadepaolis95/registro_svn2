package controllerfx;


import bean.*;
import model.Absence;

public class ControllerScenes {
    protected static UserBean user = null;
    protected static ProfessorBean professor = null;
    protected static HomeBean homeBean = null;
    protected static Util utils = null;
    protected static RegisterBean register = null;
    protected static String lastComReg = "primo_avvio";
    protected static StudentBean student = null;
    protected static String lastComStudent = "primo_avvio";
    protected static String matterPicked = "none";
    protected static ReportBean report = null;
    protected static AbsenceList absenceList = null;
    protected static Absence absenceToJustify = null;
    protected static String pinDigited = "none";

    protected ControllerScenes(){}

    public static UserBean getUserBean(){ return user; }
    public static void setUserBean(UserBean newUser){ user = newUser; }

    public static ProfessorBean getProfessorBean(){ return professor; }
    public static void setProfessorBean(ProfessorBean newProfessore){ professor = newProfessore; }

    public static HomeBean getHomeBean(){ return homeBean;}
    public static void setHomeBean(HomeBean newHomeBean){ homeBean = newHomeBean;}

    public static void setUtils(Util newUtils){  utils = newUtils;}

    public static RegisterBean getRegister(){ return register;}
    public static void setRegister(RegisterBean newRegister){ register = newRegister;}

    public static StudentBean getCurrentStudent(){ return student;}
    public static void setStudent(StudentBean newStudente){ student = newStudente;}

    public static ReportBean getReport() { return report; }
    public static void setReport(ReportBean newReport) { report = newReport; }

    public static AbsenceList getAbsenceList() { return absenceList; }
    public static void setAbsenceList(AbsenceList newAbsenceList) { absenceList = newAbsenceList; }

    public static Absence getAbsenceToJustify() { return absenceToJustify; }
    public static void setAbsenceToJustify(Absence newAbsenceToJustify) { absenceToJustify = newAbsenceToJustify; }
}
