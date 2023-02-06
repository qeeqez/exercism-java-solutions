import java.util.List;

public class PhoneNumber {

    private String phoneNumber;

    PhoneNumber(String phoneNumber) {
        cleanPhoneNumber(phoneNumber);
    }

    public String getNumber() {
        return phoneNumber;
    }

    private void cleanPhoneNumber(String phoneNumber) {
        List<Character> punctuationChars = List.of('@', ':', '!');

        phoneNumber = phoneNumber.chars()
                .peek(c -> {
                    if (Character.isLetter(c)) {
                        throw new IllegalArgumentException("letters not permitted");
                    } else if (punctuationChars.contains((char) c)) {
                        throw new IllegalArgumentException("punctuations not permitted");
                    }
                })
                .filter(Character::isDigit)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        if (phoneNumber.length() > 11) {
            throw new IllegalArgumentException("more than 11 digits");
        }

        if (phoneNumber.length() == 11) {
            if (isPhoneNumberHasCountryCode(phoneNumber)) {
                phoneNumber = phoneNumber.substring(1);
            } else {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
        }

        if (phoneNumber.length() == 10) {
            if (phoneNumber.charAt(0) == '0') throw new IllegalArgumentException("area code cannot start with zero");
            if (phoneNumber.charAt(0) == '1') throw new IllegalArgumentException("area code cannot start with one");
            if (phoneNumber.charAt(3) == '0')
                throw new IllegalArgumentException("exchange code cannot start with zero");
            if (phoneNumber.charAt(3) == '1') throw new IllegalArgumentException("exchange code cannot start with one");

            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("incorrect number of digits");
        }
    }

    private boolean isPhoneNumberHasCountryCode(String phoneNumber) {
        return phoneNumber.charAt(0) == '1';
    }
}