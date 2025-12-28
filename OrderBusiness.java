package session12_gioi1;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderBusiness {
    private ArrayList<Order> orders = new ArrayList<>();


    public void addOrder(Scanner scanner) {
        Order order = new Order();
        order.inputData(scanner);

        if (order.getCustomerName().length() < 6 || order.getCustomerName().length() > 100) {
            System.out.println("Tên khách hàng phải từ 6–100 ký tự");
            return;
        }

        if (!order.getPhoneNumber().matches("^(03|05|07|08|09)\\d{8}$")) {
            System.out.println("Số điện thoại không hợp lệ");
            return;
        }

        if (order.getAddress().isEmpty()) {
            System.out.println("Địa chỉ không được để trống");
            return;
        }

        if (order.getOrderAmount() <= 0) {
            System.out.println("Giá trị đơn hàng phải > 0");
            return;
        }

        orders.add(order);
        System.out.println("Thêm đơn hàng thành công");
    }


    public void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }

        for (int i = 0; i < orders.size() - 1; i++) {
            for (int j = i + 1; j < orders.size(); j++) {
                if (orders.get(i).getOrderAmount() < orders.get(j).getOrderAmount()) {
                    Order temp = orders.get(i);
                    orders.set(i, orders.get(j));
                    orders.set(j, temp);
                }
            }
        }

        for (Order o : orders) {
            System.out.println(o);
        }
    }


    public void updateStatus(Scanner scanner) {
        System.out.print("Nhập mã đơn hàng: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Order o : orders) {
            if (o.getOrderId() == id) {
                if (o.getStatus().equals("Pending")) {
                    o.setStatus("Shipped");
                } else if (o.getStatus().equals("Shipped")) {
                    o.setStatus("Delivered");
                } else {
                    System.out.println("Không thể cập nhật thêm");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy đơn hàng");
    }


    public void deleteOrder(Scanner scanner) {
        System.out.print("Nhập mã đơn hàng: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Order o : orders) {
            if (o.getOrderId() == id) {
                if (o.getStatus().equals("Pending")) {
                    orders.remove(o);
                    System.out.println("Đã xóa");
                } else {
                    System.out.println("Chỉ xóa khi trạng thái Pending");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy đơn hàng");
    }


    public void searchByName(Scanner scanner) {
        System.out.print("Nhập tên cần tìm: ");
        String key = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Order o : orders) {
            if (o.getCustomerName().toLowerCase().contains(key)) {
                System.out.println(o);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy");
        }
    }


    public void statistic() {
        float totalRevenue = 0;
        int pending = 0, shipped = 0, delivered = 0;
        Order maxOrder = null;

        for (Order o : orders) {
            if (o.getStatus().equals("Delivered")) {
                totalRevenue += o.getOrderAmount();
            }

            if (o.getStatus().equals("Pending")) pending++;
            if (o.getStatus().equals("Shipped")) shipped++;
            if (o.getStatus().equals("Delivered")) delivered++;

            if (maxOrder == null || o.getOrderAmount() > maxOrder.getOrderAmount()) {
                maxOrder = o;
            }
        }

        System.out.println("Tổng số đơn hàng: " + orders.size());
        System.out.println("Tổng doanh thu (Delivered): " + totalRevenue);
        System.out.println("Pending: " + pending);
        System.out.println("Shipped: " + shipped);
        System.out.println("Delivered: " + delivered);

        if (maxOrder != null) {
            System.out.println("Đơn hàng giá trị lớn nhất:");
            System.out.println(maxOrder);
        }
    }
}
