package session12_kha2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Appointment {
    private String appointmentId;
    private String patientName;
    private String phoneNumber;
    private LocalDate appointmentDate;
    private String doctor;

    public Appointment() {
    }

    public Appointment(String appointmentId, String patientName,
                       String phoneNumber, LocalDate appointmentDate,
                       String doctor) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public void inputData(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Mã lịch hẹn (6 ký tự): ");
        appointmentId = scanner.nextLine();

        System.out.print("Tên bệnh nhân: ");
        patientName = scanner.nextLine();

        System.out.print("Số điện thoại: ");
        phoneNumber = scanner.nextLine();

        System.out.print("Ngày hẹn (dd/MM/yyyy): ");
        appointmentDate = LocalDate.parse(scanner.nextLine(), formatter);

        System.out.print("Bác sĩ phụ trách: ");
        doctor = scanner.nextLine();
    }

    @Override
    public String toString() {
        return appointmentId + " | " +
                patientName + " | " +
                phoneNumber + " | " +
                appointmentDate + " | " +
                doctor;
    }
}
