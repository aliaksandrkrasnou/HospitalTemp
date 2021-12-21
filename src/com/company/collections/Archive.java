package com.company.collections;

import com.company.converter.Converter;
import com.company.models.AbstractMedicalPurpose;
import com.company.models.MedicalPurposeStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class Archive {
    private ArrayList<AbstractMedicalPurpose> medicalPurposesList;

    public Archive() {
        this.medicalPurposesList = new ArrayList<>();
    }

    public Archive(ArrayList<AbstractMedicalPurpose> medicalPurposesList) {
        this.medicalPurposesList = medicalPurposesList;
    }

    public ArrayList<AbstractMedicalPurpose> getMedicalPurposesList() {
        return medicalPurposesList;
    }
    
    public boolean add(AbstractMedicalPurpose medicalPurpose) {
        return this.medicalPurposesList.add(medicalPurpose);
    }

    public ArrayList<AbstractMedicalPurpose> getSickList() {
        return this.medicalPurposesList;
    }

    public boolean add(String string) {
        AbstractMedicalPurpose medicalPurpose = Converter.mapStringToAbstractMedicalPurpose(string);

        return this.add(medicalPurpose);
    }

    public AbstractMedicalPurpose getById(int medicalPurposeId) {
        for (AbstractMedicalPurpose medicalPurpose : this.medicalPurposesList) {
            if (medicalPurpose.getId() == medicalPurposeId) {
                return medicalPurpose;
            }
        }
        return null;
    }

    public ArrayList<AbstractMedicalPurpose> find(MedicalPurposeStatus status) {
        ArrayList<AbstractMedicalPurpose> filteredList = new ArrayList<>();
        
        for (AbstractMedicalPurpose medicalPurpose : this.medicalPurposesList) {
            if (medicalPurpose.getStatus() == status) {
                filteredList.add(medicalPurpose);
            }
        }

        return filteredList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (AbstractMedicalPurpose medicalPurpose: medicalPurposesList) {
            sb.append(medicalPurpose);
            sb.append("\n");
        }
        return sb.toString();
    }

//    @Override
//    public String toString() {
//        return sickList.stream().map(Object::toString).collect(Collectors.joining(", \n"));
//
//    }
}
