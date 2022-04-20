package model.service;

public class Service {
    Integer idService;
    String name;
    Integer area;
    Double price;
    Integer capacity;
    Integer idRentType;
    Integer idServiceType;
    String standardRoom;
    String convenient;
    Double poolArea;
    Integer floors;

    public Service() {
    }

    public Service(Integer idService, String name, Integer area, Double price, Integer capacity, Integer idRentType,
                   Integer idServiceType, String standardRoom, String convenient, Double poolArea, Integer floors) {
        this.idService = idService;
        this.name = name;
        this.area = area;
        this.price = price;
        this.capacity = capacity;
        this.idRentType = idRentType;
        this.idServiceType = idServiceType;
        this.standardRoom = standardRoom;
        this.convenient = convenient;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public Service(String name, Integer area, Double price, Integer capacity, Integer idRentType, Integer idServiceType,
                   String standardRoom, String convenient, Double poolArea, Integer floors) {
        this.name = name;
        this.area = area;
        this.price = price;
        this.capacity = capacity;
        this.idRentType = idRentType;
        this.idServiceType = idServiceType;
        this.standardRoom = standardRoom;
        this.convenient = convenient;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getIdRentType() {
        return idRentType;
    }

    public void setIdRentType(Integer idRentType) {
        this.idRentType = idRentType;
    }

    public Integer getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(Integer idServiceType) {
        this.idServiceType = idServiceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getConvenient() {
        return convenient;
    }

    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }
}
