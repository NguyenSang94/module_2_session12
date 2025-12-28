package session12_gioi1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderBusiness ob = new OrderBusiness();

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Hiển thị đơn hàng");
            System.out.println("3. Cập nhật trạng thái");
            System.out.println("4. Xóa đơn hàng");
            System.out.println("5. Tìm theo tên khách hàng");
            System.out.println("6. Thống kê");
            System.out.println("0. Thoát");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> ob.addOrder(scanner);
                case 2 -> ob.displayOrders();
                case 3 -> ob.updateStatus(scanner);
                case 4 -> ob.deleteOrder(scanner);
                case 5 -> ob.searchByName(scanner);
                case 6 -> ob.statistic();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Chọn sai");
            }
        }
    }
}
