package dao;

import database.Database;
import model.Department;
import model.Hospital;

import java.util.List;

public class DepartmentServiceImplDao implements DepartmentServiceDao {
    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(id)) {
                return hospital.getDepartments();
            }

        }
        return List.of();
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Hospital hospital : Database.hospitals) {
            for (Department department : hospital.getDepartments()) {
                if (department.getDepartmentName().equals(name)) {
                    return department;
                }
            }
        }
        return null;
    }
}