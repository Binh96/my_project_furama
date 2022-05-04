package services;

import modules.Employee;

public interface IEmployeeService extends IServices<Employee> {
    String listLevelEmployee();
    String chooseLevel(int num);
    String listPositionEmployee();
    String choosePosition(int num);
    void displayId();
}
