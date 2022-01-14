package aug.mvcapp.DAO;

import aug.mvcapp.models.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContentDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ContentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Content> index() {
        return jdbcTemplate.query("SELECT * FROM Content", new ContentMapper());
    }

    public Content show(int id){
        return jdbcTemplate.query("SELECT * FROM Content WHERE id=?", new Object[]{id}, new ContentMapper())
                .stream().findAny().orElse(null);
    }

    public void save(Content content){
        jdbcTemplate.update("INSERT INTO Content VALUES((SELECT count(id) from content) + 1, ?, ?)", content.getContentName(), content.getInfo());
    }

    public void update(int id, Content updatedContent){
        jdbcTemplate.update("UPDATE Content SET name=?, info=? WHERE id=?", updatedContent.getContentName(),
                updatedContent.getInfo(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Content WHERE id=?", id);
    }

}
