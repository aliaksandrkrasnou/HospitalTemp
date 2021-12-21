package com.company;

import java.util.Scanner;

import com.company.collections.Archive;
import com.company.collections.Doctors;
import com.company.collections.Patients;
import com.company.models.Doctor;
import com.company.models.DoctorRole;
import com.company.models.MedicalMedicine;
import com.company.models.MedicalOperation;
import com.company.models.MedicalProcedure;
import com.company.models.MedicalPurposeStatus;
import com.company.models.AbstractMedicalPurpose;
import com.company.models.Patient;
import com.company.models.PatientSex;
import com.company.reader.Reader;
import com.company.writer.Writer;

public class Worker {
    private Patients patients;
    private Doctors doctors;
    private Archive archive;

    public Worker() {
        this.patients = new Patients();
        this.doctors = new Doctors();
        this.archive = new Archive();
    }

    public void readAllData() {
        Reader.readPatients("files/patients.csv", this.patients);
        Reader.readDoctors("files/doctors.csv", this.doctors);
        Reader.readArchieve("files/archive.csv", this.archive);
    }

    public void writeAllData() {
        Writer.writePatients("files/patients.csv", this.patients);
        Writer.writeDoctors("files/doctors.csv", this.doctors);
        Writer.writeArchive("files/archive.csv", this.archive);
    }

    public void printCommands() {
        System.out.println("Доступные команды:");
        System.out.println("1 - посмотреть список всех Пациентов");
        System.out.println("2 - посмотреть список всех Докторов");
        System.out.println("3 - добавить нового Пациента");
        System.out.println("4 - добавить нового Доктора");
        System.out.println("5 - сделать Назначение Пациенту (процедура, лекарство, операция)");
        System.out.println("6 - выполнить Назначение Пациента");
        System.out.println("7 - выписать Пациента");
        System.out.println("8 - посмотреть созданные Назначения");
        System.out.println("9 - посмотреть выполняемые Назначения");
        System.out.println("10 - посмотреть весь Архив");
        System.out.println("0 - завершить программу");
        System.out.println("Введите номер команды для выполнения: ");
    }

    public void printPatients() {
        System.out.println("Список всех Пациентов: ");
        System.out.println(this.patients);
    }

    public void printDoctors() {
        System.out.println("Список всех Докторов: ");
        System.out.println(this.doctors);
    }

    public void addPatient(Scanner in) {
        System.out.print("Введите имя нового Пациента: ");
        String firstName = in.next();

        System.out.print("Введите фамилию нового Пациента: ");
        String lastName = in.next();

        System.out.print("Введите возраст нового Пациента: ");
        int age = in.nextInt();

        System.out.print("Введите пол нового Пациента (MALE или FEMALE): ");
        PatientSex sex = PatientSex.valueOf(in.next());

        Patient patient = new Patient(firstName, lastName, age, sex);

        boolean result = this.patients.add(patient);

        if (result) {
            System.out.println("Новый Пациент " + patient + " успешно добавлен");
        } else {
            System.out.println("Ошибка при добавлении нового Пациента");
        }
    }

    public void makeAppointment(Scanner in) {
        System.out.println("Доступные типы назначения");
        System.out.println("1 - Medical Medicine");
        System.out.println("2 - Medical Operation");
        System.out.println("3 - Medical Procedure");
        System.out.print("Выберите тип Назначения: ");
        int type = in.nextInt();
        in.nextLine(); // чтобы символ переноса строки \n (который появляется при нажатии на enter) не
                       // мешал дальше вводить строки

        System.out.print("Введите название Назначения: ");
        String title = in.nextLine();

        System.out.print("Введите описание Назначения: ");
        String descriptipn = in.nextLine();

        System.out.print("Введите id Пациента, которому хотите сделать Назначение: ");
        int patientId = in.nextInt();

        System.out.print("Введите id Доктора, которому делает Назначение: ");
        int doctorId = in.nextInt();

        AbstractMedicalPurpose medicalPurpose = null;

        if (type == 1) {
            medicalPurpose = new MedicalMedicine(title, descriptipn, patientId, doctorId);
        } else if (type == 2) {
            medicalPurpose = new MedicalOperation(title, descriptipn, patientId, doctorId);
        } else {
            medicalPurpose = new MedicalProcedure(title, descriptipn, patientId, doctorId);
        }

        this.archive.add(medicalPurpose);

        System.out.println("Успешно создано Назначение");
        System.out.println(medicalPurpose);
    }

    public void startAppointment(Scanner in) {
        System.out.print("Введите id Назначения, которое хотите выполнить: ");
        int medicalPurposeId = in.nextInt();

        AbstractMedicalPurpose medicalPurpose = this.archive.getById(medicalPurposeId);

        if (medicalPurpose != null) {
            MedicalPurposeStatus prevStatus = medicalPurpose.getStatus();
            medicalPurpose.setStatus(MedicalPurposeStatus.IN_PROGRESS);
            System.out.println("Статус Назначения с id " + medicalPurposeId + " изменен с " + prevStatus + " на "
                    + medicalPurpose.getStatus());
        } else {
            System.out.println("Назначение с id " + medicalPurposeId + " не найдено");
        }
    }

    public void endAppointment(Scanner in) {
        System.out.print("Введите id Назначения, которое хотите выполнить: ");
        int medicalPurposeId = in.nextInt();

        in.nextLine(); // чтобы символ переноса строки \n (который появляется при нажатии на enter) не
                       // мешал дальше вводить строки

        AbstractMedicalPurpose medicalPurpose = this.archive.getById(medicalPurposeId);

        if (medicalPurpose != null) {
            System.out.print("Введите причину закрытия Назначения: ");
            String description = in.nextLine();

            medicalPurpose.setDescription(description);
            medicalPurpose.setStatus(MedicalPurposeStatus.ENDED);
        } else {
            System.out.println("Назначение с id " + medicalPurposeId + " не найдено");
        }

    }

    public void printArchieve() {
        System.out.println(this.archive);
    }

    public void printArchieve(MedicalPurposeStatus status) {
        System.out.println(this.archive.find(status));
    }

    // public static void appointDoctorToPatient(Patient patient, Doctor doctor,
    // SickLeave sickLeave) {
    // sickLeave.setPatientId(patient.getId());
    // sickLeave.setDoctorId(doctor.getId());
    // }

    // public static void makeAppointmentToPatient(Patient patient, Doctor doctor,
    // AbstractMedicalPurpose AbstractMedicalPurpose) {
    // if(AbstractMedicalPurposeType == 1) {
    // AbstractMedicalPurpose AbstractMedicalPurpose = new MedicalMedicine();
    // } else if(AbstractMedicalPurposeType == 2) {
    // AbstractMedicalPurpose AbstractMedicalPurpose = new MedicalProcedure();
    // } else {
    // AbstractMedicalPurpose AbstractMedicalPurpose = new MedicalOperation();
    // }
    // if (doctor.getRole() == DoctorRole.NURSE && AbstractMedicalPurpose.equals(new
    // MedicalOperation(AbstractMedicalPurpose.getId(),
    // AbstractMedicalPurpose.getTitle(), AbstractMedicalPurpose.getDescription())))
    // {
    // System.out.println("Ошибка");
    // } else {
    // AbstractMedicalPurpose.setPatient(patient);
    // AbstractMedicalPurpose.setDoctor(doctor);
    // AbstractMedicalPurpose.setSickLeaveStatus(SickLeaveStatus.IN_PROGRESS);
    // }
    // }

}
