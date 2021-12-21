package com.company.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.company.collections.Archive;
import com.company.collections.Doctors;
import com.company.collections.Patients;
import com.company.converter.Converter;
import com.company.models.AbstractMedicalPurpose;
import com.company.models.Doctor;
import com.company.models.Patient;

public class Writer {

    public static void writePatients(String filename, Patients patientsList) {
        File file = new File(filename);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            ArrayList<Patient> list = new ArrayList<>(patientsList.getPatientsList());
            for (Patient patient : list) {
                bw.write(patient.toStringWithSeparator(","));
                bw.write("\n");
            }
            bw.flush();
            bw.close();
        } catch (FileNotFoundException e) {
            System.err.println("File \"" + filename + "\" not found");
        } catch (IOException e) {
            System.err.println("IOException while writing in \"" + filename + "\"");
        }
    }

    public static void writeDoctors(String filename, Doctors doctorsList) {
        File file = new File(filename);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            ArrayList<Doctor> list = new ArrayList<>(doctorsList.getDoctorsList());
            for (Doctor doctor : list) {
                bw.write(doctor.toStringWithSeparator(","));
                bw.write("\n");
            }
            bw.flush();
            bw.close();
        } catch (FileNotFoundException e) {
            System.err.println("File \"" + filename + "\" not found");
        } catch (IOException e) {
            System.err.println("IOException while writing in \"" + filename + "\"");
        }
    }

    public static void writeArchive(String filename, Archive archive) {
        File file = new File(filename);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            ArrayList<AbstractMedicalPurpose> list = new ArrayList<>(archive.getMedicalPurposesList());
            for (AbstractMedicalPurpose medicalPurpose : list) {
                bw.write(medicalPurpose.toStringWithSeparator(","));
                bw.write("\n");
            }
            bw.flush();
            bw.close();
        } catch (FileNotFoundException e) {
            System.err.println("File \"" + filename + "\" not found");
        } catch (IOException e) {
            System.err.println("IOException while writing in \"" + filename + "\"");
        }
    }

    

    // public static void write(String filename, Archive archive) {
    //     File file = new File(filename);
    //     try {
    //         BufferedWriter bw = new BufferedWriter(new FileWriter(file));
    //         ArrayList<SickLeave> list = new ArrayList<>(archive.getSickList());
    //         for (SickLeave sickLeave : list) {
    //             bw.write(Converter.mapSickLeaveToString(sickLeave, ","));
    //             bw.write("\n");
    //         }
    //         bw.flush();
    //         bw.close();
    //     } catch (FileNotFoundException e) {
    //         System.err.println("File \"" + filename + "\" not found");
    //     } catch (IOException e) {
    //         System.err.println("IOException while writing in \"" + filename + "\"");
    //     }
    // }
}
