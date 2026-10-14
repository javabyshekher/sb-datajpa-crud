package in.ashokit.runner;

import in.ashokit.entity.Employee;
import in.ashokit.entity.EmployeeStatus;
import in.ashokit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyAppRunner implements ApplicationRunner {

    @Autowired
    private EmployeeRepository repository;
    @Override
    public void run(ApplicationArguments args) {
//        Employee employee = new Employee(7577, "Clark", 75000.0, "Research", EmployeeStatus.ACTIVE);
//        saveEmp(employee);

//        fetchEmployee(7788);

//        deleteEmployee(7788);
        Employee emp = new Employee(7577, "Clark", 69000.0, "Development", EmployeeStatus.ACTIVE);
        updateEmployee(emp);
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
