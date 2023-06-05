package sixth;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeRecordManager manager = new EmployeeRecordManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请选择操作（1-添加，2-修改，3-删除，4-查询，5-显示全部，6-保存并退出）：");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manager.addEmployee();
                    break;
                case 2:
                    manager.modifyEmployee();
                    break;
                case 3:
                    manager.deleteEmployee();
                    break;
                case 4:
                    manager.queryEmployee();
                    break;
                case 5:
                    manager.printAllEmployees();
                    break;
                case 6:
                    manager.saveEmployeesToFile();
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }
    }
}
