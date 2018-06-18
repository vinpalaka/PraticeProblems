package employee_structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Employee_StructureTest {

    public static final String CEO = "CEO";
    public static final String CTO = "CTO";
    public static final String CMO = "CMO";

    public static final String ENG_Director = "Engineering Director";

    public static final String ENG_MANGER = "Engineering Manager";
    public static final String MARK_MANGER = "Marketing Manager";

    public static final String SOFTWARE_DEV = "Software Engineer";
    public static final String SENIOR_SOFTWARE_DEV = "SENIOR_SOFTWARE_DEV";
    public static final String SOFTWARE_INTERN = "Software Intern";

    public static final String MARKETING_ANALYST = "Marketing Anaylst";
    public static final String MARKETING_OPERATIONS = "Marketing Operations";



    @Test
    void getEmployeTree() {
        Employee_Structure employee_structure = new Employee_Structure(CEO);
        employee_structure.addNewEmployee(CTO, CEO);
        employee_structure.addNewEmployee(CMO, CEO);
        employee_structure.addNewEmployee(ENG_Director, CTO);
        employee_structure.addNewEmployee(ENG_MANGER, ENG_Director);
        employee_structure.addNewEmployee(MARK_MANGER, CMO);
        employee_structure.addNewEmployee(SOFTWARE_DEV, ENG_MANGER);
        employee_structure.addNewEmployee(MARKETING_ANALYST, MARK_MANGER);
        employee_structure.addNewEmployee(MARKETING_OPERATIONS, MARK_MANGER);
        employee_structure.addNewEmployee(SOFTWARE_INTERN, ENG_MANGER);
        employee_structure.addNewEmployee(SENIOR_SOFTWARE_DEV, ENG_MANGER);

        employee_structure.printAllEmployees();

        assertEquals("Software Intern -->Engineering Manager -->Engineering Director -->CTO -->CEO -->", employee_structure.getEmployeTree(SOFTWARE_INTERN));
        employee_structure.removeEmployee(ENG_MANGER);
        employee_structure.printAllEmployees();

    }
}