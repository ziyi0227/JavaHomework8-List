package sixth;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeRecordManager {
    private ArrayList<Employee> employees;
    private final String FILE_PATH = "employees.dat";

    public EmployeeRecordManager() {
        employees = new ArrayList<Employee>();
        readEmployeesFromFile();
    }

    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入雇员号：");
        int empNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("请输入姓名：");
        String name = scanner.nextLine();
        System.out.print("请输入地址：");
        String address = scanner.nextLine();
        System.out.print("请输入工资：");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(empNo, name, address, salary);
        employees.add(employee);
        System.out.println("添加雇员成功！");
    }

    public void modifyEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要修改的雇员号：");
        int empNo = scanner.nextInt();
        scanner.nextLine();

        for (Employee employee : employees) {
            if (employee.getEmpNo() == empNo) {
                System.out.print("请输入要修改的信息（1-姓名，2-地址，3-工资）：");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("请输入新的姓名：");
                        String name = scanner.nextLine();
                        employee.setName(name);
                        System.out.println("修改雇员姓名成功！");
                        break;
                    case 2:
                        System.out.print("请输入新的地址：");
                        String address = scanner.nextLine();
                        employee.setAddress(address);
                        System.out.println("修改雇员地址成功！");
                        break;
                    case 3:
                        System.out.print("请输入新的工资：");
                        double salary = scanner.nextDouble();
                        employee.setSalary(salary);
                        System.out.println("修改雇员工资成功！");
                        break;
                    default:
                        System.out.println("输入有误，修改雇员信息失败！");
                        break;
                }

                return;
            }
        }

        System.out.println("没有找到指定雇员，修改雇员信息失败！");
    }

    public void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要删除的雇员号：");
        int empNo = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpNo() == empNo){
                employees.remove(i);
                System.out.println("删除雇员成功！");
                return;
            }
        }

        System.out.println("没有找到指定雇员，删除雇员失败！");
    }

    public void queryEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要查询的雇员号：");
        int empNo = scanner.nextInt();
        scanner.nextLine();

        for (Employee employee : employees) {
            if (employee.getEmpNo() == empNo) {
                System.out.println(employee);
                return;
            }
        }

        System.out.println("没有找到指定雇员，查询雇员信息失败！");
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void saveEmployeesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(employees);
            System.out.println("保存雇员记录成功！");
        } catch (IOException e) {
            System.out.println("保存雇员记录失败：" + e.getMessage());
        }
    }

    private void readEmployeesFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            employees = (ArrayList<Employee>) ois.readObject();
            System.out.println("从文件中读取雇员记录成功！");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("从文件中读取雇员记录失败：" + e.getMessage());
        }
    }
}