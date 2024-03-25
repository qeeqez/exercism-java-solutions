import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class KindergartenGarden {

    private final List<String> garden;

    KindergartenGarden(String garden) {
        this.garden = Arrays.stream(garden.split("\n")).toList();
    }

    List<Plant> getPlantsOfStudent(String student) {
        List<Plant> output = new ArrayList<>();

        int studentIndex = Student.getStudentIndex(student);
        int studentPlantIndex = studentIndex * 2;

        garden.forEach(line -> {
            output.add(Plant.getPlant(line.charAt(studentPlantIndex)));
            output.add(Plant.getPlant(line.charAt(studentPlantIndex + 1)));
        });

        return output;
    }

}
