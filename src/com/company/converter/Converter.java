package com.company.converter;

import com.company.models.Doctor;
import com.company.models.DoctorRole;
import com.company.models.MedicalMedicine;
import com.company.models.MedicalOperation;
import com.company.models.MedicalProcedure;
import com.company.models.MedicalPurposeStatus;
import com.company.models.AbstractMedicalPurpose;
import com.company.models.Patient;
import com.company.models.PatientSex;

import java.util.Date;

public class Converter {
    public static Patient mapStringToPatient(String string) {
        String[] strings = string.split(",");

        int id = Integer.parseInt(strings[0]);
        String firstName = strings[1];
        String lastName = strings[2];
        int age = Integer.parseInt(strings[3]);
        PatientSex sex = PatientSex.valueOf(strings[4]);

        return new Patient(id, firstName, lastName, age, sex);
    }

    public static Doctor mapStringToDoctor(String string) {
        String[] strings = string.split(",");

        int id = Integer.parseInt(strings[0]);
        String firstName = strings[1];
        String lastName = strings[2];
        DoctorRole role = DoctorRole.valueOf(strings[3]);

        return new Doctor(id, firstName, lastName, role);
    }

    public static AbstractMedicalPurpose mapStringToAbstractMedicalPurpose(String string) {
        String[] strings = string.split(",");

        String type = strings[0];
        int id = Integer.parseInt(strings[1]);
        String title = strings[2];
        String description = strings[3];
        MedicalPurposeStatus status = MedicalPurposeStatus.valueOf(strings[4]);
        int patientId = Integer.parseInt(strings[5]);
        int doctorId = Integer.parseInt(strings[6]);
        
        if(type.equals("MedicalOperation")) {
            return new MedicalOperation(id, title, description, status, patientId, doctorId);
        } else if(type.equals("MedicalProcedure")) {
            return new MedicalProcedure(id, title, description, status, patientId, doctorId);
        } else {
            return new MedicalMedicine(id, title, description, status, patientId, doctorId);
        }
    }

    // public static SickLeave mapStringToSickLeave(String string) {
    // String[] strings = string.split(","); // " " - это и есть разделитель. Ты
    // можешь задать свой символ, либо
    // // использовать Regex.
    // int id = Integer.parseInt(strings[0]);
    // Date startDate = new Date(Long.parseLong(strings[1]));
    // Date endDate = new Date(Long.parseLong(strings[2]));
    // int patientId = Integer.parseInt(strings[3]);
    // int doctorId = Integer.parseInt(strings[4]);
    // SickLeaveStatus status = SickLeaveStatus.valueOf(strings[5]);
    // String diagnosis = strings[6];
    // // if (strings[6].equals("MedicalOperation")) {
    // // // strings[7] strings[8] strings[9] - эт точно new MedicalOperation()
    // // } else if (strings[6].equals("MedicalPro"))
    // MedicalProcedure medicalProcedure = new MedicalProcedure(1, "lulu", "lolo");
    // // convert strings to SickLeave
    // return new SickLeave(id, startDate, endDate, patientId, doctorId, status,
    // diagnosis, medicalProcedure);
    // }

    // public static String mapSickLeaveToString(SickLeave sickLeave, String
    // separator) {
    // int id = sickLeave.getId();
    // Date startDate = sickLeave.getStartDate();
    // Date endDate = sickLeave.getEndDate();
    // int patientId = sickLeave.getPatientId();
    // int doctorId = sickLeave.getDoctorId();
    // SickLeaveStatus status = sickLeave.getStatus();
    // String diagnosis = sickLeave.getDiagnosis();
    // AbstractMedicalPurpose AbstractMedicalPurpose =
    // sickLeave.getAbstractMedicalPurpose();
    // return id + separator + startDate.getTime() + separator + endDate.getTime() +
    // separator + patientId + separator
    // + doctorId + separator + status + separator + diagnosis + separator +
    // AbstractMedicalPurpose;
    // }
}
