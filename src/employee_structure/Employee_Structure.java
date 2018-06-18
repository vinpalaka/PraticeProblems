package employee_structure;

import java.util.*;

public class Employee_Structure {

    class Employee {
        String name;

        public Employee(String name, String managerName) {
            this.name = name;
            this.managerName = managerName;
        }

        public void setManagerName(String managerName) {
            this.managerName = managerName;
        }

        public void addEmployee(Employee e) {
            employeeSetMap.get(this).add(e);
        }

        public void removeEmployee(Employee m) {
            employeeSetMap.get(this).remove(m);
        }

        String managerName;

    }

    public Map<Employee, Set<Employee>> employeeSetMap;
    Map<String, Employee> employees;
    String root;


    public Employee_Structure(String name) {
        Employee firstEmpl = new Employee(name, null);
        employeeSetMap = new HashMap<>();
        employeeSetMap.put(firstEmpl, new HashSet<>());
        employees = new HashMap<>();
        employees.put(name, firstEmpl);
        root = name;
    }

    public void addNewEmployee(String name, String manager) {
        if(!employees.containsKey(manager)) {
            System.out.println("Cannot find manager");
        } else {
            Employee managerObj = employees.get(manager);
            Employee newEmployee = new Employee(name, manager);
            employees.put(name, newEmployee);
            employeeSetMap.get(managerObj).add(newEmployee);
            employeeSetMap.put(newEmployee, new HashSet<>());
        }
    }

    public void removeEmployee(String name) {
        Employee m = employees.remove(name);//Remove from list of employees
        Set<Employee> belowEmployees = employeeSetMap.get(m);
        Employee newManager = employees.get(m.managerName);
        newManager.removeEmployee(m);//remove from manager's list
        if(belowEmployees != null) {
            for(Employee e : belowEmployees) {
                e.setManagerName(m.managerName);//Set new manager to manager of old manager
                newManager.addEmployee(e);
            }
            employeeSetMap.remove(m);
        }
    }

    public void getEmployeeInfo(String name) {
        employees.get(name);
    }

    public String getEmployeTree(String name) {
        String tree = "";
        Employee employee = employees.get(name);
        while(employee != null) {
            tree += employee.name + " -->";
            employee = employees.get(employee.managerName);
        }
        return tree;
    }

    public void printAllEmployees() {
        ArrayDeque<Employee> q = new ArrayDeque<>();
        q.add(employees.get(root));
        while (!q.isEmpty()) {
            Employee next = q.remove();
            System.out.println(next.name + " --->");
            for(Employee e : employeeSetMap.get(next)) {
                q.push(e);
            }
        }
    }


}
