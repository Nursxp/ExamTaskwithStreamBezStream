package dao;

import database.Database;
import model.Hospital;
import model.Patient;

import java.util.List;
import java.util.Map;

public class HospitalServiceImplDao implements HospitalServiceDao {
    @Override
    public String addHospital(Hospital hospital) {
        Database.hospitals.add(hospital);
        return "Больница успешно добавлена";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(id)) {
                return hospital;
            }
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return Database.hospitals;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(id)) {
                return hospital.getPatients();
            }
        }
        return List.of();
    }

    @Override
    public String deleteHospitalById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(id)) {
                Database.hospitals.remove(hospital);
                return "Больница успешно удалена";
            }
        }
        return "Больноца не найдена";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getAddress().equals(address)) {
                return Map.of(address, hospital);
            }
        }
        return null;
    }
}