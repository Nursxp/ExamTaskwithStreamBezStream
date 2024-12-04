package service.serviceimpl;

import dao.PatientServiceImplDao;
import model.Patient;
import service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService {
    private PatientServiceImplDao patientServiceImplDao = new PatientServiceImplDao();

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
      return   patientServiceImplDao.addPatientsToHospital(id, patients);

    }

    @Override
    public Patient getPatientById(Long id) {
       return patientServiceImplDao.getPatientById(id);

    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
      return   patientServiceImplDao.getPatientByAge();

    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
     return    patientServiceImplDao.sortPatientsByAge(ascOrDesc);

    }
}