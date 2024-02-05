package st.util;

import org.springframework.jdbc.core.RowMapper;
import st.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Бесполезная реализация т.к. есть аналог BeanPropertyRowMapper<>(Person.class));
 */
public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();

        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setAge(resultSet.getInt("age"));
        person.setEmail(resultSet.getString("email"));

        return person;
    }
}