package model.employee;

public class Employee {
    Integer idEmployee;
    String name;
    String dateOfBirth;
    String idCard;
    Double salary;
    String phone;
    String email;
    String address;
    Integer idPosition;
    Integer idDegree;
    Integer idDivision;

    public Employee() {
    }

    public Employee(String name, String dateOfBirth, String idCard, Double salary, String phone, String email, String address, Integer idPosition, Integer idDegree, Integer idDivision) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.idPosition = idPosition;
        this.idDegree = idDegree;
        this.idDivision = idDivision;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    public Integer getIdDegree() {
        return idDegree;
    }

    public void setIdDegree(Integer idDegree) {
        this.idDegree = idDegree;
    }

    public Integer getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(Integer idDivision) {
        this.idDivision = idDivision;
    }
}
