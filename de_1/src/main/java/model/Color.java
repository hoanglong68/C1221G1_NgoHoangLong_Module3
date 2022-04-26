package model;

public class Color {
    Integer idColor;
    String nameColor;

    public Color() {
    }

    public Color(Integer idColor, String nameColor) {
        this.idColor = idColor;
        this.nameColor = nameColor;
    }

    public Integer getIdColor() {
        return idColor;
    }

    public void setIdColor(Integer idColor) {
        this.idColor = idColor;
    }

    public String getNameColor() {
        return nameColor;
    }

    public void setNameColor(String nameColor) {
        this.nameColor = nameColor;
    }
}
