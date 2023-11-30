package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private String employeeName;
    private int salary;
    private String position;
    private List<Case> cases;
}
