class RaindropConverter {

    String convert(int number) {
        StringBuilder sb = new StringBuilder();

        boolean factor3 = number % 3 == 0;
        boolean factor5 = number % 5 == 0;
        boolean factor7 = number % 7 == 0;

        if (factor3) sb.append("Pling");
        if (factor5) sb.append("Plang");
        if (factor7) sb.append("Plong");

        boolean hasFactor = factor3 || factor5 || factor7;

        if(!hasFactor) sb.append(number);

        return sb.toString();
    }

}
