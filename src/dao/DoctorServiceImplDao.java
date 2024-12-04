package dao;

import database.Database;
import model.Department;
import model.Doctor;
import model.Hospital;

import java.util.List;

public class DoctorServiceImplDao implements DoctorServiceDao {
    @Override
    public Doctor findDoctorById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            for (Doctor doctor : hospital.getDoctors()) {
                if (doctor.getId().equals(id)) {
                    return doctor;
                }
            }
        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        for (Hospital hospital : Database.hospitals) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(departmentId)) {
                    for (Long doctorId : doctorsId) {
                        for (Doctor doctor : hospital.getDoctors()) {
                            if (doctor.getId().equals(doctorId)) {
                                if (!department.getDoctors().contains(doctor)) {
                                    department.getDoctors().add(doctor);
                                }
                            }
                        }
                    }
                    return "Врачи добавлены в отеление";
                }
            }
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(id)) {
                return hospital.getDoctors();
            }
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        for (Hospital hospital : Database.hospitals) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(id)) {
                    return department.getDoctors();
                }
            }
        }
        return null;
    }
}
