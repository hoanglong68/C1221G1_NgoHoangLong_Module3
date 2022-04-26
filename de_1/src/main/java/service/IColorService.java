package service;

import model.Color;
import java.util.List;

public interface IColorService extends IService{
    List<Color> displayColorList();
}
