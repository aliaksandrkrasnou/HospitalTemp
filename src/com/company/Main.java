package com.company;

import java.util.Scanner;

import com.company.models.MedicalPurposeStatus;

public class Main {
        public static void main(String[] args) {
                System.out.println("Начало программы");

                Worker worker = new Worker();

                worker.readAllData();

                Scanner in = new Scanner(System.in);
                Boolean flag = false;

                while (!flag) {

                        worker.printCommands();
                        int command = in.nextInt();
                        in.nextLine();

                        switch (command) {
                                case 1:
                                        worker.printPatients();
                                        break;
                                case 2:
                                        worker.printDoctors();
                                        break;
                                case 3:
                                        worker.addPatient(in);
                                        break;
                                case 4:
                                        System.out.println("Реализуй меня");
                                        break;
                                case 5:
                                        worker.makeAppointment(in);
                                        break;
                                case 6:
                                        worker.startAppointment(in);
                                        break;
                                case 7:
                                        worker.endAppointment(in);
                                        break;
                                case 8:
                                        worker.printArchieve(MedicalPurposeStatus.NOT_STARTED);
                                        break;
                                case 9:
                                        worker.printArchieve(MedicalPurposeStatus.IN_PROGRESS);
                                        break;
                                case 10:
                                        worker.printArchieve();
                                        break;
                                default:
                                        flag = true;
                                        break;
                        }
                }

                in.close();

                worker.writeAllData();

                System.out.println("Завершение программы");
        }
}
