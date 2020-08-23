package controller;

import bean.AbsenceList;
import excep.ConnectionError;
import excep.InputException;
import model.Absence;
import model.RegisterRecord;
import service.AbsenceService;
import service.PinService;
import service.Validator;
import utilities.Mailer;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.util.List;


public class StudentAbsenceController {


    public StudentAbsenceController() {
        //controller
    }

    ;


    public void generateNewPin(String email, String id) throws InputException, SQLException, ConnectionError, MessagingException {

        Validator v = new Validator();

        if (!v.isAMail(email)) throw new InputException("email");

        PinService service = new PinService();
        String pin = service.generateNewPin();
        if (service.checkPin(id) == 0)
            service.savePin(pin, id);
        else
            service.updatePin(pin, id);
        Mailer m = new Mailer();
        m.SendMail(pin, email);
    }


    public boolean justifyAbsence(Absence absence, String id, String pin) throws InputException,SQLException,ConnectionError {

        PinService pinService = new PinService();
        if (!pinService.verifyPin(pin, id))
            throw new InputException("Invalid Pin if you not remember that try to generate a new one");

        AbsenceService service = new AbsenceService();
        service.justifyAbsence(absence);
        return true;
    }


    public AbsenceList loadAllAbsence(String id) throws Exception {

        AbsenceList list = new AbsenceList();
        AbsenceService service = new AbsenceService();
        List<RegisterRecord> absences = service.getAllAbsence(id);
        absences.forEach(item -> {
            Absence ab = (Absence) item;
            if (ab.isJustified())
                list.addJustified(ab);
            else
                list.addAbsence(ab);
        });
        return list;
    }


}
