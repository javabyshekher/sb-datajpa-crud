package in.ashokit.repository;

import in.ashokit.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // optional
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
