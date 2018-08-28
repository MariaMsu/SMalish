package oneBigPakage.DAO;

import oneBigPakage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements oneBigPakage.DAO.UserDao {
    public JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addNewUser(User user) {
        jdbcTemplate.update("INSERT INTO user (name, email) VALUES (?,?)", user.getName(), user.getEmail());
    }
}
