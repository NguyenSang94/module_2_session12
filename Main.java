package session12_kha1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductBusiness pb = new ProductBusiness();

        while (true) {
            System.out.println("====== MENU ======");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("6. Sắp xếp giá tăng dần");
            System.out.println("7. Sắp xếp số lượng giảm dần");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    pb.addProduct(scanner);
                    break;
                case 2:
                    pb.displayProducts();
                    break;
                case 3:
                    pb.updateProduct(scanner);
                    break;
                case 4:
                    pb.deleteProduct(scanner);
                    break;
                case 5:
                    pb.searchByName(scanner);
                    break;
                case 6:
                    pb.sortByPriceAsc();
                    break;
                case 7:
                    pb.sortByQuantityDesc();
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình");
                    return;
                default:
                    System.out.println("Chọn sai, nhập lại");
            }
        }
    }
}
