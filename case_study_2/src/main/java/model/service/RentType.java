package model.service;

public class RentType {
    Integer idRentType;
    String nameRentType;

    public RentType() {
    }

    public RentType(Integer idRentType, String nameRentType) {
        this.idRentType = idRentType;
        this.nameRentType = nameRentType;
    }

    public Integer getIdRentType() {
        return idRentType;
    }

    public void setIdRentType(Integer idRentType) {
        this.idRentType = idRentType;
    }

    public String getNameRentType() {
        return nameRentType;
    }

    public void setNameRentType(String nameRentType) {
        this.nameRentType = nameRentType;
    }
}
