class ResistorColorTrio {

    private int getResistorValue(String color) {
        return ResistorColor.valueOf(color.toUpperCase()).getValue();
    }

    private String getUnitPrefix(int zeroCount) {
        if (zeroCount >= 9) return "giga";
        if (zeroCount >= 6) return "mega";
        if (zeroCount >= 3) return "kilo";
        return "";
    }

    private String getOhmsPrefix(int zeroCount) {
        return getUnitPrefix(zeroCount) + "ohms";
    }

    private String getOhmsString(int zeroCount) {
        String prefix = " " + getOhmsPrefix(zeroCount);

        if (zeroCount >= 9) return "0".repeat(zeroCount - 9) + prefix;
        if (zeroCount >= 6) return "0".repeat(zeroCount - 6) + prefix;
        if (zeroCount >= 3) return "0".repeat(zeroCount - 3) + prefix;
        if (zeroCount > 0) return "0".repeat(zeroCount) + prefix;
        return prefix;
    }

    private String label(int resistorValue1, int resistorValue2, int zeroCount) {
        if (resistorValue1 == 0 && resistorValue2 == 0) return "0" + getOhmsString(0);
        if (resistorValue1 == 0) return resistorValue2 + getOhmsString(zeroCount);
        if (resistorValue2 == 0) return resistorValue1 + getOhmsString(zeroCount + 1);

        return resistorValue1 + "" + resistorValue2 + getOhmsString(zeroCount);
    }

    String label(String[] colors) {
        return label(getResistorValue(colors[0]), getResistorValue(colors[1]), getResistorValue(colors[2]));
    }
}
