package model.employee;

public class EmployeeDivision {
    Integer idDivision;
    String nameDivision;

    public EmployeeDivision() {
    }

    public EmployeeDivision(Integer idDivision, String nameDivision) {
        this.idDivision = idDivision;
        this.nameDivision = nameDivision;
    }

    public Integer getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(Integer idDivision) {
        this.idDivision = idDivision;
    }

    public String getNameDivision() {
        return nameDivision;
    }

    public void setNameDivision(String nameDivision) {
        this.nameDivision = nameDivision;
    }
}
