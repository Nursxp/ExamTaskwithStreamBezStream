package service.serviceimpl;

import dao.HospitalServiceImplDao;
import model.Hospital;
import model.Patient;
import service.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {
    private HospitalServiceImplDao hospitalServiceImplDao = new HospitalServiceImplDao();

    @Override
    public String addHospital(Hospital hospital) {
     return    hospitalServiceImplDao.addHospital(hospital);

    }

    @Override
    public Hospital findHospitalById(Long id) {
        return  hospitalServiceImplDao.findHospitalById(id);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return   hospitalServiceImplDao.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return hospitalServiceImplDao.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {

     return    hospitalServiceImplDao.deleteHospitalById(id);
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
      return   hospitalServiceImplDao.getAllHospitalByAddress(address);

    }
}