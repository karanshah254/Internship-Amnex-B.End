import java.util.HashMap;

public class hashmaps {
    public static void main(String[] args) {
        HashMap<String, Integer> exam_scores = new HashMap<String, Integer>();

        // adding key-value pairs to hashmap
        exam_scores.put("math", 95);
        exam_scores.put("english", 94);
        exam_scores.put("science", 90);

        // to get full hashmap
        System.out.println("Exam scores are: " + exam_scores.toString());

        // to get single value from hashmap
        System.out.println("Math score is: " + exam_scores.get("math"));

        // check if key exists and if not then add it to hashmap
        exam_scores.putIfAbsent("computer", 98);

        System.out.println("After adding new key -> " + exam_scores.toString());

        exam_scores.putIfAbsent("computer", 98);

        // again adding same key to the hashmap
        System.out.println(exam_scores.toString());

        // using getOrDefault method
        System.out.println("Using get or default method so value is " + exam_scores.getOrDefault("Games", 89));

        // to clear hashmap
        // exam_scores.clear();

        // size of hashmap
        System.out.println("Size of hashmap is " + exam_scores.size());

        // check if key exists
        System.out.println("Contains maths -> " + exam_scores.containsKey("math"));

        // check if any value exists or not
        System.out.println("Contains value 95 -> " + exam_scores.containsValue(95));

        // check if hashmap is empty
        // exam_scores.clear(); // to clear hashmap
        System.out.println("Is hashmap empty ? " + exam_scores.isEmpty());

        // to iterate over hashmap and print the key-value pairs
        System.out.println("Using for-ech loop to iterate over hashmap");
        exam_scores.forEach((subject, score) -> {
            System.out.println("Subject: " + subject + " Score: " + score);
        });
    }
}
