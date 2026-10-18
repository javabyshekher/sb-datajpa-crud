package in.ashokit.runner;

import in.ashokit.entity.Employee;
import in.ashokit.entity.EmployeeStatus;
import in.ashokit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MyAppRunner implements ApplicationRunner {

    @Autowired
    private EmployeeRepository repository;
    @Override
    public void run(ApplicationArguments args) {
//        Employee employee = new Employee(7552, "Mary", 57000.0, "HR", EmployeeStatus.INACTIVE);
//        saveEmp(employee);

//        fetchEmployee(7788);

//        deleteEmployee(7788);
//        Employee emp = new Employee(7577, "Clark", 69000.0, "Development", EmployeeStatus.ACTIVE);
//        updateEmployee(emp);

//        fetchEmployeesByDepartment("Hr");
//        fetchEmployeesBySalMoreThan(60000);
//        fetchEmployeesBetween(40000.0, 60000.0);
//        fetchEmployeesWithDeptOrSal("HR", 80000.0);
        //deleteEmployeesBySalGreaterThan(65000);

        fetchAllData();
    }

    private void fetchAllData() {
        List<Employee> employees = repository.fetchAllEmployees();
        employees.forEach(System.out::println);
    }

    private void deleteEmployeesBySalGreaterThan(double sal) {
        int i = repository.deleteBySalGreaterThan(sal);
        System.out.println(i + " row(s) deleted");
    }

    private void fetchEmployeesWithDeptOrSal(String dept, double sal) {
        List<Employee> employees = repository.fetchEmployeesWithDeptOrSal(dept, sal);
        employees.forEach(System.out::println);
    }
    private void fetchEmployeesBetween(double min, double max) {
        List<Employee> employees = repository.fetchEmployeesWithSalBetween(min, max);
        employees.forEach(System.out::println);
    }

    private void fetchEmployeesBySalMoreThan(double sal) {
        List<Employee> bySalGreaterThan = repository.findBySalGreaterThan(sal);
        bySalGreaterThan.forEach(System.out::println);
    }

    private void fetchEmployeesByDepartment(String department) {
        List<Employee> byDepartment = repository.findByDepartment(department);
        byDepartment.forEach(e -> System.out.println(e));
    }

    private void updateEmployee(Employee e) {
        repository.save(e);
    }

    private void deleteEmployee(int empno) {
        repository.deleteById(empno);
    }

    private void fetchEmployee(int empno) {
        Optional<Employee> byId = repository.findById(empno);
        if(byId.isPresent()) {
            Employee employee = byId.get();
            System.out.println(employee);
        }

    }

    private void saveEmp(Employee employee) {
        repository.save(employee);
    }
}















