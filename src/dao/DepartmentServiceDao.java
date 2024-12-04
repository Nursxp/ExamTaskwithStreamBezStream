package dao;

import model.Department;

import java.util.List;

public interface DepartmentServiceDao {
    List<Department> getAllDepartmentByHospital(Long id);

    Department findDepartmentByName(String name);
}