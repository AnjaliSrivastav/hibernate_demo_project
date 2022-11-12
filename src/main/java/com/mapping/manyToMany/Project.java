package com.mapping.manyToMany;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

public class Project {
    @Id
    private int projectId;
    @Column(name="project_name")
    private String projectName;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Project() {
        super();
    }
    public Project(int projectId, String projectName, List<Employee> employees) {
        super();
        this.projectId = projectId;
        this.projectName = projectName;
        this.employees = employees;
    }
}
