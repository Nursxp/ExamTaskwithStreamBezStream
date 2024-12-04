import database.Database;
import enums.Gender;
import model.Department;
import model.Doctor;
import model.Hospital;
import model.Patient;
import service.DoctorService;
import service.PatientService;
import service.serviceimpl.DoctorServiceImpl;
import service.serviceimpl.PatientServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerLong = new Scanner(System.in);
        DoctorService doctorService = new DoctorServiceImpl();
        PatientService patientService = new PatientServiceImpl();

        try {

            System.out.println("Введите название больницы:");
            String hospitalName = scanner.nextLine();
            System.out.println("Введите адрес больницы:");
            String address = scanner.nextLine();

            Hospital hospital = new Hospital(
                    1L, hospitalName, address, List.of(
                    new Department(
                            1L,
                            "Ibraimova", List.of(
                            new Doctor(
                                    1L,
                                    "Ernest",
                                    "Abramov", Gender.MALE,
                                    29)))), List.of(
                    new Doctor(
                            2L,
                            "Adil",
                            "Adilov", Gender.MALE,
                            12)), List.of(new Patient(
                    2L, "Adilet",
                    "Adolov", 17, Gender.MALE)));
            Database.hospitals.add(hospital);
            System.out.println("Больница добавлена: " + hospital.getHospitalName());
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении больницы: " + e.getMessage());
        }

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1 - Добавить врача");
            System.out.println("2 - Добавить пациента");
            System.out.println("3 - Получить список врачей");
            System.out.println("4 - Сортировать пациентов по возрасту");
            System.out.println("5 - Найти пациента по ID");
            System.out.println("6 - Выход");
            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:

                        System.out.println("Введите имя врача");
                        String firstName = scanner.nextLine();
                        System.out.println("Введите фамилию врача:");
                        String lastName = scanner.nextLine();
                        System.out.println("Введите пол врача (MALE/FEMALE)");
                        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
                        System.out.println("Введите стаж врача");
                        int experienceYear = scanner.nextInt();
                        scanner.nextLine();

                        Doctor doctor = new Doctor(
                                (long) (Database.hospitals.get(0).getDoctors().size() + 1),
                                firstName, lastName, gender, experienceYear);
                        Database.hospitals.get(0).getDoctors().add(doctor);
                        System.out.println("Врач успешно добавлен" + doctor.getFirstName() + " " + doctor.getLastName());
                        break;

                    case 2:

                        System.out.println("Введите имя пациента");
                        String patientFirstName = scannerStr.nextLine();
                        System.out.println("Введите фамилию пациента");
                        String patientLastName = scannerStr.nextLine();
                        System.out.println("Введите возраст пациента");
                        int age = scanner.nextInt();
                        System.out.println("Введите пол пациента (MALE/FEMALE):");
                        Gender patientGender = Gender.valueOf(scanner.nextLine().toUpperCase());

                        Patient patient = new Patient(
                                (long) (Database.hospitals.get(0).getPatients().size() + 1),
                                patientFirstName, patientLastName, age, patientGender);

                        patientService.addPatientsToHospital(1L, Arrays.asList(patient));
                        System.out.println("Пациент успешно добавлен " + patient.getFirstName() + " " + patient.getLastName());
                        break;

                    case 3:
                        System.out.println("hospital id jaz : ");
                        Long hospitalId =  scannerLong.nextLong();
                        List<Doctor> doctors = doctorService.getAllDoctorsByHospitalId(hospitalId);
                        System.out.println("Список врачей в больнице");
                        doctors.forEach(doc -> System.out.println(doc.getFirstName() + " " + doc.getLastName()));
                        break;

                    case 4:

                        System.out.println("Введите порядок сортировки (asc/desc)");
                        String order = scanner.nextLine().toLowerCase();
                        List<Patient> sortedPatients = patientService.sortPatientsByAge(order);
                        System.out.println("Пациенты, отсортированные по возрасту:");
                        sortedPatients.forEach(p -> System.out.println(p.getFirstName() + " - " + p.getAge() + "лет"));
                        break;

                    case 5:

                        System.out.println("Введите ID пациента");
                        Long patientId = scanner.nextLong();
                        scanner.nextLine();

                        Patient foundPatient = patientService.getPatientById(patientId);
                        if (foundPatient != null) {
                            System.out.println("Найден пациент: " + foundPatient.getFirstName() + " " + foundPatient.getLastName());
                        } else {
                            System.out.println("Пациент с таким ID не найден.");
                        }
                        break;

                    case 6:
                        System.out.println("Программа завершена");
                        return;

                    default:
                        System.out.println("Неверный выбор Попробуйте снова");
                }
            } catch (Exception e) {
                System.out.println("Произошла ошибка" + e.getMessage());
            }
        }
    }
}