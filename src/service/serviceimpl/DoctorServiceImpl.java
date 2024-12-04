package service.serviceimpl;

import dao.DoctorServiceImplDao;
import model.Doctor;
import service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    private DoctorServiceImplDao doctorServiceImplDao = new DoctorServiceImplDao();

    @Override
    public Doctor findDoctorById(Long id) {
        doctorServiceImplDao.findDoctorById(id);
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        doctorServiceImplDao.assignDoctorToDepartment(departmentId, doctorsId);
        return "";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        doctorServiceImplDao.getAllDoctorsByHospitalId(id);
        return List.of();
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        doctorServiceImplDao.getAllDoctorsByDepartmentId(id);
        return List.of();
    }
}