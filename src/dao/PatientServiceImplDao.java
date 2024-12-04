package dao;

import database.Database;
import model.Hospital;
import model.Patient;

import java.util.List;
import java.util.Map;

public class PatientServiceImplDao implements PatientServiceDao {
    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(id)) {
                if (hospital.getPatients() == null) {
                    hospital.setPatients(patients);
                } else {
                    hospital.getPatients().addAll(patients);
                }
                return "Пациенты добавлены в больницу";
            }
        }
        return null;
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getId().equals(id)) {
                    return patient;
                }
            }
        }
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        for (Hospital hospital : Database.hospitals) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getAge() == patient.getAge()) {

                }
            }
        }
        return Map.of();
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        for (Hospital hospital : Database.hospitals){
            for (Patient patient : hospital.getPatients()){
            }
        }
        return List.of();
    }
}
