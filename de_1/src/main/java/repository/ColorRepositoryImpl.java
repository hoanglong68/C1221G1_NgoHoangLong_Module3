package repository;

import model.Color;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorRepositoryImpl implements IColorRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Color> displayColorList() {
        List<Color> colorList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        Color color;
        try {
            preparedStatement = baseRepository.getConnection().prepareStatement
                    ("select * from color");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                color = new Color();
                color.setIdColor(resultSet.getInt("id_color"));
                color.setNameColor(resultSet.getString("name_color"));
                colorList.add(color);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return colorList;
    }
}
