package in.ashokit.repository;

import in.ashokit.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.List;

@Repository  // optional
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByDepartment(String department);

    List<Employee> findBySalGreaterThan(double sal);

    @Query(value = "select e from Employee e where e.sal between ?1 and ?2")
    List<Employee> fetchEmployeesWithSalBetween(double min, double max);

    @Query(value = "select e from Employee e where e.department = :department or e.sal > :sal")
    List<Employee> fetchEmployeesWithDeptOrSal(@Param("department")String s, @Param("sal")double d);

    @Query(value = "delete from employee where sal > ?", nativeQuery = true)
    @Modifying
    @Transactional
    int deleteBySalGreaterThan(double sal);

    List<Employee> fetchAllEmployees();


}
