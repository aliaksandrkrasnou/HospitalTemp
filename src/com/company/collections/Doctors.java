package com.company.collections;

import java.util.ArrayList;

import com.company.converter.Converter;
import com.company.models.Doctor;

public class Doctors {
  private ArrayList<Doctor> doctorsList;

  public Doctors() {
    this.doctorsList = new ArrayList<>();
  }

  public Doctors(ArrayList<Doctor> doctorsList) {
    this.doctorsList = doctorsList;
  }

  public ArrayList<Doctor> getDoctorsList() {
    return doctorsList;
  }

  public boolean add(Doctor doctor) {
    return this.doctorsList.add(doctor);
  }

  public boolean add(String string) {
    Doctor doctor = Converter.mapStringToDoctor(string);

    return this.add(doctor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Doctor doctor : doctorsList) {
      sb.append(doctor);
      sb.append("\n");
    }
    return sb.toString();
  }
}
