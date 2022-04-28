package validators;

public class EmailValidator {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    public boolean validateEmail(String email){

        return email.matches(EMAIL_REGEX);

    }

}
