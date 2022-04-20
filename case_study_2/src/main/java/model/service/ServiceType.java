package model.service;

public class ServiceType {
    Integer idServiceType;
    String nameServiceType;

    public ServiceType() {
    }

    public ServiceType(Integer idServiceType, String nameServiceType) {
        this.idServiceType = idServiceType;
        this.nameServiceType = nameServiceType;
    }

    public Integer getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(Integer idServiceType) {
        this.idServiceType = idServiceType;
    }

    public String getNameServiceType() {
        return nameServiceType;
    }

    public void setNameServiceType(String nameServiceType) {
        this.nameServiceType = nameServiceType;
    }
}
