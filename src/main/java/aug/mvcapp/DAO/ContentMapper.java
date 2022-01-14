package aug.mvcapp.DAO;

import aug.mvcapp.models.Content;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContentMapper implements RowMapper<Content> {
    @Override
    public Content mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Content content = new Content();

        content.setId(resultSet.getInt("id"));

        content.setContentName(resultSet.getString("name"));

        content.setInfo(resultSet.getString("info"));

        return content;
    }
}
