package bean;

import model.Argument;
import model.Homework;
import model.Schedule;

import java.util.List;

public class HomeBean {


    public HomeBean() {
        //bean
    };

    private List<Schedule> schedule;
    private List<Argument> argument;
    private List<Homework> homework;


    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }


    public List<Argument> getArgument() {
        return argument;
    }

    public void setArgument(List<Argument> argument) {
        this.argument = argument;
    }

    public List<Homework> getHomework() {
        return homework;
    }

    public void setHomework(List<Homework> homework) {
        this.homework = homework;
    }
}