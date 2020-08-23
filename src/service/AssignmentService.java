package service;

import model.Assignment;

public interface AssignmentService {

    public int saveNew(Assignment a) throws Exception;

    public void delete(int index) throws Exception;

    // public void delete(Assignment a);

    //  public void update(Assignment a);
}
