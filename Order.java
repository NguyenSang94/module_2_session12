package session12_gioi1;

import java.util.Scanner;

public class Order {
    private static int AUTO_ID = 1;

    private int orderId;
    private String customerName;
    private String phoneNumber;
    private String address;
    private float orderAmount;
    private String status;


    public Order() {
        this.orderId = AUTO_ID++;
        this.status = "Pending";
    }


    public Order(int orderId, String customerName, String phoneNumber,
                 String address, float orderAmount, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderAmount = orderAmount;
        this.status = status;
    }


    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(float orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public void inputData(Scanner scanner) {
        System.out.print("Tên khách hàng: ");
        customerName = scanner.nextLine();

        System.out.print("Số điện thoại: ");
        phoneNumber = scanner.nextLine();

        System.out.print("Địa chỉ giao hàng: ");
        address = scanner.nextLine();

        System.out.print("Giá trị đơn hàng: ");
        orderAmount = Float.parseFloat(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "ID: " + orderId +
                " | Tên: " + customerName +
                " | SĐT: " + phoneNumber +
                " | Địa chỉ: " + address +
                " | Giá trị: " + orderAmount +
                " | Trạng thái: " + status;
    }
}
