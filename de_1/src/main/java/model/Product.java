package model;

public class Product {
    Integer id;
    String name;
    Double price;
    Integer quantity;
    Integer idColor;
    Integer idCategory;

    public Product() {
    }

    public Product(String name, Double price, Integer quantity, Integer idColor, Integer idCategory) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.idColor = idColor;
        this.idCategory = idCategory;
    }

    public Product(Integer id, String name, Double price, Integer quantity, Integer idColor, Integer idCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.idColor = idColor;
        this.idCategory = idCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIdColor() {
        return idColor;
    }

    public void setIdColor(Integer idColor) {
        this.idColor = idColor;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }
}
