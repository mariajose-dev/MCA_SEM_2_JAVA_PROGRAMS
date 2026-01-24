import java.util.Scanner;

// User-defined exception for password validation
class PassValidationException extends Exception {
    public PassValidationException(String message) {
        super(message);
    }
}

public class PasswordValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	boolean valid = false;
	while(!valid){
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        try {
            validatePassword(pass);
	    valid = true;
            System.out.println("Password is valid: " + pass);
        } catch (PassValidationException e) {
            System.out.println("Password validation failed: " + e.getMessage());
        }
	}

        sc.close();
    }

    // Method to validate password
    static void validatePassword(String pass) throws PassValidationException {
        if (pass.length() < 8)
            throw new PassValidationException("Minimum length is altleast 8 characters.");

        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        String specialChars = "@*!{}()[]&";

        for (int i = 0; i < pass.length(); i++) {
            char ch = pass.charAt(i);

            // Check consecutive repetition
            if (i > 0 && pass.charAt(i) == pass.charAt(i - 1))
                throw new PassValidationException("No consecutive repeating characters.");

            // Check uppercase, lowercase, digit
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;

            // Check special character
            if (specialChars.indexOf(ch) != -1) hasSpecial = true;
        }

        // Final checks
        if (!hasUpper) throw new PassValidationException("At least one uppercase letter.");
        if (!hasLower) throw new PassValidationException("At least one lowercase letter.");
        if (!hasDigit) throw new PassValidationException("At least one digit.");
        if (!hasSpecial) throw new PassValidationException("At least one special character \n (@, *, !, {, }, (, ), [, ], &).");
    }
}
