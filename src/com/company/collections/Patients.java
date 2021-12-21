package com.company.collections;

import java.util.ArrayList;

import com.company.converter.Converter;
import com.company.models.Patient;

public class Patients {
  private ArrayList<Patient> patientsList;

  public Patients() {
    this.patientsList = new ArrayList<>();
  }

  public Patients(ArrayList<Patient> patientsList) {
    this.patientsList = patientsList;
  }

  public ArrayList<Patient> getPatientsList() {
    return patientsList;
  }

  public boolean add(Patient patient) {
    return this.patientsList.add(patient);
  }

  public boolean add(String string) {
    Patient patient = Converter.mapStringToPatient(string);

    return this.add(patient);
  }

  public Patient find(int patientId) {
    for (Patient patient : patientsList) {
      if (patient.getId() == patientId) {
        return patient;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Patient patient : patientsList) {
      sb.append(patient);
      sb.append("\n");
    }
    return sb.toString();
  }
}
