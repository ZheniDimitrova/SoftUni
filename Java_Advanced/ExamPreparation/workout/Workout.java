package workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Workout {


    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {

        if (exerciseCount > exercises.size()) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return exercises.removeIf(e -> e.getName().equals(name) && e.getMuscle().equals(muscle));
    }

    public Exercise getExercise(String name, String muscle) {
        return exercises.stream()
                .filter(e -> e.getName().equals(name) && e.getMuscle().equals(muscle))
                .findAny()
                .orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return Collections.max(exercises, Comparator.comparing(Exercise::getBurnedCalories));
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public String getStatistics() {

        StringBuilder output = new StringBuilder();
        output.append(String.format("Workout type: %s", this.type));

        for (Exercise exercise : exercises) {
            output.append(System.lineSeparator())
                    .append(exercise);
        }
        return output.toString();
    }

}

