package controller;

import excep.InputException;
import model.Argument;
import model.Assignment;
import model.Homework;
import service.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AssignmentController {

    public AssignmentController(){};


    public Argument saveNewArgument(String title, String text, String matter, String course,String date) throws Exception {

        Validator v = new Validator();
        if(!v.validateString(title)) throw  new InputException("title");

        if(!v.validateString(text))throw new InputException("text");

        if(!v.validateDate(date)) throw  new InputException("date"); //check if parsing date give error or the date is correct

        Date d =  new SimpleDateFormat("yyyy-MM-dd").parse(date);

            Argument a = new Argument("temp",matter,text,course,title,d);
            ArgumentService as = new ArgumentService();
            int id = as.saveNew(a);
            a.setId(String.valueOf(id));
            return  a;

    }



    public Homework saveNewHomework(String text, String matter, String course,String date) throws Exception {

        Validator v = new Validator();

        if(!v.validateString(text))throw new InputException("text");

        if(!v.validateDate(date)) throw  new InputException("date"); //check if parsing date give error or the date is correct

        Date d =  new SimpleDateFormat("yyyy-MM-dd").parse(date);


        Homework a = new Homework("temp",matter,text,course,d);
        HomeworkService as  = new HomeworkService();
        int id =  as.saveNew(a);

        a.setId(String.valueOf(id));
        return  a;

    }



    public void deleteHomework(Homework h) throws Exception {

        HomeworkService hs = new HomeworkService();
        hs.delete(h);

    }

    public void deleteArgument(Argument a) throws Exception {
        ArgumentService as = new ArgumentService();
        as.delete(a);
    }

}
