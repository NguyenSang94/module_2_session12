package session12_kha1;

import java.util.Scanner;

public class Product {
    private static int autoId = 1;

    private int productId;
    private String productName;
    private float price;
    private String category;
    private int quantity;
    public Product() {
        this.productId = autoId++;
    }


    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void inputData(Scanner scanner) {
        System.out.print("Tên sản phẩm: ");
        productName = scanner.nextLine();

        System.out.print("Giá sản phẩm: ");
        price = Float.parseFloat(scanner.nextLine());

        System.out.print("Danh mục: ");
        category = scanner.nextLine();

        System.out.print("Số lượng tồn: ");
        quantity = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "ID=" + productId +
                ", Name=" + productName +
                ", Price=" + price +
                ", Category=" + category +
                ", Quantity=" + quantity;
    }
}
