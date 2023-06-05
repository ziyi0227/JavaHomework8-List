package second;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1001, "Tom", "Market", 1200));
        employees.add(new Employee(1002, "Jack", "Department", 1300));
        employees.add(new Employee(1003, "Simth", "Market", 2000));
        employees.add(new Employee(1004, "Tony", "Department", 3000));

        // 列出所有员工姓名
        System.out.println("所有员工姓名：");
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

        // 列出所有员工姓名及其工资
        System.out.println("所有员工姓名及其工资：");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + "：" + employee.getSalary() + "元");
        }

        for (Employee employee : employees){
            if (employee.getName().equals("Jack")){
                employee.changePay(1500);
            }
        }

        for (Employee employee : employees){
            if (employee.getSalary() < 1000){
                employee.changePay(0.2f);
            }
        }

        HashMap<String, Collection<Integer>> departmentSalaryMap = new HashMap<String, Collection<Integer>>();
        for (Employee employee : employees){
            String department = employee.getDepartment();
            int salary = employee.getSalary();
            if (departmentSalaryMap.containsKey(department)){
                departmentSalaryMap.get(department).add(salary);
            } else {
                ArrayList<Integer> salaryList = new ArrayList<Integer>();
                salaryList.add(salary);
                departmentSalaryMap.put(department,salaryList);
            }
        }
        System.out.println("每个部门的平均工资：");
        for (String department : departmentSalaryMap.keySet()){
            Collection<Integer> salaryList = departmentSalaryMap.get(department);
            int totalSalary = 0;
            for (int salary : salaryList){
                totalSalary += salary;
            }
            double avgSalary = (double) totalSalary / salaryList.size();
            System.out.println(department + ":" + avgSalary + "元");
        }

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee.getName().equals("Tom")){
                iterator.remove();
            }
        }
    }
}
