class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        int index = 10;
        int count = 0;
        stringToVerify = stringToVerify.replace("-", "");

        if(stringToVerify.length() != 10) return false;

        for (int i = 0; i < stringToVerify.length(); i++) {
            char c = stringToVerify.charAt(i);
            if (i == stringToVerify.length() - 1 && c == 'X') count += index * 10;
            else if (!Character.isDigit(c) || index < 1) return false;

            count += index * Character.getNumericValue(c);
            index--;
        }
        return count % 11 == 0;
    }

}
