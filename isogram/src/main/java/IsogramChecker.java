class IsogramChecker {

    boolean isIsogram(String phrase) {
        int[] chars = new int[256];

        for (char c : phrase.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                int index = c - 'a';
                chars[index]++;
                if (chars[index] > 1) return false;
            }
        }

        return true;
    }

}
