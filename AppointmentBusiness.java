package session12_kha2;

import java.util.*;
import java.util.regex.Pattern;

public class AppointmentBusiness {

    private List<Appointment> appointments = new ArrayList<>();
    public void addAppointment(Scanner scanner) {
        Appointment ap = new Appointment();
        ap.inputData(scanner);


        if (ap.getAppointmentId().length() != 6 ||
                appointments.stream().anyMatch(a -> a.getAppointmentId().equals(ap.getAppointmentId()))) {
            System.out.println("Mã lịch hẹn không hợp lệ hoặc bị trùng");
            return;
        }

        if (ap.getPatientName().length() < 10 || ap.getPatientName().length() > 50) {
            System.out.println("Tên bệnh nhân phải từ 10–50 ký tự");
            return;
        }


        String phoneRegex = "^(03|05|07|08|09)\\d{8}$";
        if (!Pattern.matches(phoneRegex, ap.getPhoneNumber())) {
            System.out.println("Số điện thoại không hợp lệ");
            return;
        }

        appointments.add(ap);
        System.out.println("Thêm lịch hẹn thành công");
    }


    public void displayAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }

        appointments.stream()
                .sorted(Comparator.comparing(Appointment::getAppointmentDate))
                .forEach(System.out::println);
    }


    public void searchByPatientName(Scanner scanner) {
        System.out.print("Nhập tên cần tìm: ");
        String key = scanner.nextLine().toLowerCase();

        List<Appointment> result = appointments.stream()
                .filter(a -> a.getPatientName().toLowerCase().contains(key))
                .toList();

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy");
        } else {
            result.forEach(System.out::println);
        }
    }

    public void updateAppointment(Scanner scanner) {
        System.out.print("Nhập mã lịch hẹn: ");
        String id = scanner.nextLine();

        Optional<Appointment> opt = appointments.stream()
                .filter(a -> a.getAppointmentId().equals(id))
                .findFirst();

        opt.ifPresentOrElse(a -> {
            System.out.print("Tên bệnh nhân mới: ");
            a.setPatientName(scanner.nextLine());

            System.out.print("SĐT mới: ");
            a.setPhoneNumber(scanner.nextLine());

            System.out.print("Ngày hẹn mới (dd/MM/yyyy): ");
            a.setAppointmentDate(
                    java.time.LocalDate.parse(scanner.nextLine(),
                            java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            );

            System.out.print("Bác sĩ mới: ");
            a.setDoctor(scanner.nextLine());

            System.out.println("Cập nhật thành công");
        }, () -> System.out.println("Không tìm thấy lịch hẹn"));
    }


    public void deleteAppointment(Scanner scanner) {
        System.out.print("Nhập mã lịch hẹn cần xóa: ");
        String id = scanner.nextLine();

        Optional<Appointment> opt = appointments.stream()
                .filter(a -> a.getAppointmentId().equals(id))
                .findFirst();

        opt.ifPresentOrElse(a -> {
            System.out.print("Bạn có chắc muốn xóa? (Y/N): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                appointments.remove(a);
                System.out.println("Đã xóa");
            }
        }, () -> System.out.println("Không tìm thấy lịch hẹn"));
    }


    public void statistic() {
        System.out.println("Tổng số lịch hẹn: " + appointments.size());

        appointments.stream()
                .collect(java.util.stream.Collectors.groupingBy(Appointment::getDoctor, java.util.stream.Collectors.counting()))
                .forEach((doctor, count) ->
                        System.out.println("Bác sĩ " + doctor + ": " + count + " lịch"));
    }
}
