package com.company.models;

public class MedicalOperation extends AbstractMedicalPurpose{
    public MedicalOperation(String title, String description, int patientId, int doctorId) {
        super(title, description, patientId, doctorId);
    }

    public MedicalOperation(int id, String title, String description, MedicalPurposeStatus status, int patientId,
            int doctorId) {
        super(id, title, description, status, patientId, doctorId);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.getId() + " " + this.getTitle() + " "
                + this.getDescription() + " " + this.getStatus() + " " + this.getPatientId() + " " + this.getDoctorId();
    }

    public String toStringWithSeparator(String separator) {
        return this.getClass().getSimpleName() + separator + this.getId() + separator + this.getTitle() + separator
                + this.getDescription() + separator + this.getStatus() + separator + this.getPatientId() + separator + this.getDoctorId();
    }
}
