class Triangle {

    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(double side1, double side2, double side3) throws TriangleException {
        if (!hasCorrectSides(side1, side2, side3)) throw new TriangleException();
        if (!couldCreateTriangle(side1, side2, side3)) throw new TriangleException();

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    private boolean hasCorrectSides(double side1, double side2, double side3) {
        return side1 > 0 && side2 > 0 && side3 > 0;
    }

    private boolean couldCreateTriangle(double side1, double side2, double side3) {
        return side1 + side2 > side3
                && side1 + side3 > side2
                && side2 + side3 > side1;
    }

    public boolean isEquilateral() {
        return side1 == side2 && side2 == side3;
    }

    public boolean isIsosceles() {
        return side1 == side2 || side1 == side3 || side2 == side3;
    }

    public boolean isScalene() {
        return side1 != side2 && side1 != side3 && side2 != side3;
    }

}
