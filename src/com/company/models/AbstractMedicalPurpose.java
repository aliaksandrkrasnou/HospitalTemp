package com.company.models;

public abstract class AbstractMedicalPurpose {
    private int id;
    private String title;
    private String description;
    private MedicalPurposeStatus status;
    private int patientId;
    private int doctorId;

    public AbstractMedicalPurpose(String title, String description, int patientId, int doctorId) {
        this.title = title;
        this.description = description;
        this.patientId = patientId;
        this.doctorId = doctorId;

        this.id = (int) (Math.random() * 1000 + 1);
        this.status = MedicalPurposeStatus.NOT_STARTED;
    }

    public AbstractMedicalPurpose(int id, String title, String description, MedicalPurposeStatus status, int patientId,
            int doctorId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MedicalPurposeStatus getStatus() {
        return status;
    }

    public void setStatus(MedicalPurposeStatus status) {
        this.status = status;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public abstract String toStringWithSeparator(String string);
}
