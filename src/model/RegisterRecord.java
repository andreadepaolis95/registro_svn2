package model;

import java.util.Date;

public interface RegisterRecord {


    public String getValue();

    public String getDateFormatted();

    public int getDayAsIndex();

    public String getType();

    public String getID();

    public Boolean isInRange(Date start, Date end);

    public Date getDate();

    void setId(String res);


    //voto A o Voto
    //classe css?
    //show Date
    //getIndexDay
}
