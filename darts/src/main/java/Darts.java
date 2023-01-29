class Darts {

    public static int OUTER_CIRCLE_RADIUS = 10;
    public static int MIDDLE_CIRCLE_RADIUS = 5;
    public static int INNER_CIRCLE_RADIUS = 1;

    int score(double xOfDart, double yOfDart) {
        double radius = Math.sqrt(Math.pow(xOfDart,2) + Math.pow(yOfDart,2));

        if(radius > OUTER_CIRCLE_RADIUS) return 0;
        if(radius > MIDDLE_CIRCLE_RADIUS) return 1;
        if(radius > INNER_CIRCLE_RADIUS) return 5;
        return 10;
    }
}
