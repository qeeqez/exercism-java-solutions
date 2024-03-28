import java.util.*;

class School {

    Map<Integer, List<String>> students = new HashMap<>();

    boolean add(String student, int grade) {
        List<String> current = new ArrayList<>(students.getOrDefault(grade, new ArrayList<>()));
        if (current.contains(student)) return false;
        if (roster().contains(student)) return false;

        current.add(student);
        students.put(grade, current.stream().sorted().toList());

        return true;
    }

    List<String> roster() {
        return students.values().stream().flatMap(Collection::stream).toList();
    }

    List<String> grade(int grade) {
        return students.getOrDefault(grade, new ArrayList<>());
    }

}
