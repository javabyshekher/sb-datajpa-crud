package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    @Id
    @Column(name = "empno")
    private Integer empno;

    @Column(name="ename")
    private String ename;

    @Column(name="sal")
    private Double sal;

    @Column(name="department")
    private String department;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;


}
