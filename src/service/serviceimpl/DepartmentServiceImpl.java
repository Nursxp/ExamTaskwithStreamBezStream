package service.serviceimpl;

import dao.DepartmentServiceImplDao;
import model.Department;
import service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentServiceImplDao departmentServiceImplDao = new DepartmentServiceImplDao();

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        departmentServiceImplDao.getAllDepartmentByHospital(id);
        return List.of();
    }

    @Override
    public Department findDepartmentByName(String name) {
        departmentServiceImplDao.findDepartmentByName(name);
        return null;
    }
}