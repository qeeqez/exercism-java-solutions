@SuppressWarnings("unused")
enum Student {
    ALICE,
    BOB,
    CHARLIE,
    DAVID,
    EVE,
    FRED,
    GINNY,
    HARRIET,
    ILEANA,
    JOSEPH,
    KINCAID,
    LARRY;

    static int getStudentIndex(String student) {
        return valueOf(student.toUpperCase()).ordinal();
    }
}
