package bean;

import model.Absence;

import java.util.ArrayList;
import java.util.List;

public class AbsenceList{
    
    private List<Absence> justifiedAbsences = new ArrayList<>();
    private List<Absence> absences = new ArrayList<>();


    public List<Absence> getJustifiedAbsences() {
        return justifiedAbsences;
    }

    public void setJustifiedAbsences(List<Absence> justifiedAbsences) {
        this.justifiedAbsences = justifiedAbsences;
    }

    public List<Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(List<Absence> absences) {
        this.absences = absences;
    }

    public void addJustified(Absence a){
        System.out.println('justified');
        this.justifiedAbsences.add(a);
    }

    public  void addAbsence(Absence a){
        this.absences.add(a);
    }


}
