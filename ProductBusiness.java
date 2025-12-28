package session12_kha1;

import java.util.Scanner;

public class ProductBusiness {

    private Product[] products = new Product[100];
    private int count = 0;

    public void addProduct(Scanner scanner) {
        Product p = new Product();
        p.inputData(scanner);

        // validate cơ bản
        if (p.getPrice() <= 0) {
            System.out.println("Giá phải > 0");
            return;
        }

        if (p.getQuantity() < 0) {
            System.out.println("Số lượng phải >= 0");
            return;
        }

        products[count++] = p;
        System.out.println("Thêm sản phẩm thành công");
    }
    public void displayProducts() {
        if (count == 0) {
            System.out.println("Danh sách trống");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(products[i]);
        }
    }
    public void updateProduct(Scanner scanner) {
        System.out.print("Nhập ID cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            if (products[i].getProductId() == id) {

                System.out.print("Tên mới: ");
                products[i].setProductName(scanner.nextLine());

                System.out.print("Giá mới: ");
                products[i].setPrice(Float.parseFloat(scanner.nextLine()));

                System.out.print("Danh mục mới: ");
                products[i].setCategory(scanner.nextLine());

                System.out.print("Số lượng mới: ");
                products[i].setQuantity(Integer.parseInt(scanner.nextLine()));

                System.out.println("Cập nhật thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm");
    }

    public void deleteProduct(Scanner scanner) {
        System.out.print("Nhập ID cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            if (products[i].getProductId() == id) {

                for (int j = i; j < count - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[--count] = null;

                System.out.println("Xóa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm");
    }

    public void searchByName(Scanner scanner) {
        System.out.print("Nhập từ khóa: ");
        String key = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (products[i].getProductName().toLowerCase().contains(key)) {
                System.out.println(products[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sản phẩm");
        }
    }

    public void sortByPriceAsc() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (products[i].getPrice() > products[j].getPrice()) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp theo giá tăng dần");
    }

    public void sortByQuantityDesc() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (products[i].getQuantity() < products[j].getQuantity()) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp theo số lượng giảm dần");
    }
}
