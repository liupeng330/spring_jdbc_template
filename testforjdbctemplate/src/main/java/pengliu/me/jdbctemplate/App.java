package pengliu.me.jdbctemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.context.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws SQLException
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("DBConnection.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("template");

        String sqlInsert = "INSERT INTO contact (name, email, address, telephone)"
                + " VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sqlInsert, "Tom", "tomea@mail.com", "USA", "12345");

        String sqlUpdate = "UPDATE contact set email=? where name=?";
        jdbcTemplate.update(sqlUpdate, "tomee@mail.com", "Tom");

        String sqlSelect = "SELECT * FROM contact";
        List<Contact> listContact = jdbcTemplate.query(sqlSelect, new RowMapper<Contact>() {

            public Contact mapRow(ResultSet result, int rowNum) throws SQLException {
                Contact contact = new Contact();
                contact.setName(result.getString("name"));
                contact.setEmail(result.getString("email"));
                contact.setAddress(result.getString("address"));
                contact.setPhone(result.getString("telephone"));

                return contact;
            }

        });

        for (Contact aContact : listContact) {
            System.out.println(aContact);
        }

        String sqlDelete = "DELETE FROM contact where name=?";
        jdbcTemplate.update(sqlDelete, "Tom");
    }
}
