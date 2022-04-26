package service;

import model.Color;
import repository.ColorRepositoryImpl;
import repository.IColorRepository;

import java.util.List;

public class ColorServiceImpl implements IColorService{
    IColorRepository colorRepository = new ColorRepositoryImpl();
    @Override
    public List<Color> displayColorList() {
        return colorRepository.displayColorList();
    }
}
