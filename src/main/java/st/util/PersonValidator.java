package st.util;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import st.dao.PersonDAO;
import st.models.Person;

@Component
@AllArgsConstructor
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        if (personDAO.show(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "", "This email address is already in use by another person");
        }
    }
}