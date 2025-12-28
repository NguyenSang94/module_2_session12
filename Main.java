package session12_kha2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppointmentBusiness ab = new AppointmentBusiness();

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Thêm lịch hẹn");
            System.out.println("2. Hiển thị lịch hẹn");
            System.out.println("3. Tìm theo tên bệnh nhân");
            System.out.println("4. Cập nhật lịch hẹn");
            System.out.println("5. Xóa lịch hẹn");
            System.out.println("6. Thống kê");
            System.out.println("0. Thoát");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> ab.addAppointment(scanner);
                case 2 -> ab.displayAppointments();
                case 3 -> ab.searchByPatientName(scanner);
                case 4 -> ab.updateAppointment(scanner);
                case 5 -> ab.deleteAppointment(scanner);
                case 6 -> ab.statistic();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Chọn sai");
            }
        }
    }
}
