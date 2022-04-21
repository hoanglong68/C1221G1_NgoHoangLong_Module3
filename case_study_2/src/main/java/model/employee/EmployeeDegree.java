package model.employee;

public class EmployeeDegree {
    Integer idDegree;
    String nameDegree;

    public EmployeeDegree() {
    }

    public EmployeeDegree(Integer idDegree, String nameDegree) {
        this.idDegree = idDegree;
        this.nameDegree = nameDegree;
    }

    public Integer getIdDegree() {
        return idDegree;
    }

    public void setIdDegree(Integer idDegree) {
        this.idDegree = idDegree;
    }

    public String getNameDegree() {
        return nameDegree;
    }

    public void setNameDegree(String nameDegree) {
        this.nameDegree = nameDegree;
    }
}
