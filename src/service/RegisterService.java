package service;

import model.*;
import utilities.Configuration;

import java.util.*;

public class RegisterService {

    public List<RegisterStudent> loadStudentOfClass(String course) throws Exception {

        List<RegisterStudent> result = new ArrayList<>();
        List<Student> st = new StudentService().getAllStudent(course);
        st.forEach(item -> result.add(new RegisterStudent(item.getFullName(), item.getId())));
        Comparator<RegisterStudent> res = (RegisterStudent a1, RegisterStudent a2) -> a1.compareTo(a2);
        result.sort(res);
        return result;
    }




    public double calculateMedia(String id, String matter) throws Exception {

        double result = 0;
        double count = 0;

        MarkService markService = new MarkService();
        List<RegisterRecord> rd = markService.getAllBetweenDate(id,matter, Configuration.startOfAcademicYear(),Configuration.EndOfAcademicYear());
        for(RegisterRecord r: rd){
            result = result + Integer.parseInt(r.getValue());
            count = count +1;
        }
        if(count == 0)
             return 0;

        return Math.round(result/count * 10) /10.0;
    }


}
