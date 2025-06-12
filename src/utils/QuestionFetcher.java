package utils;

import model.Question;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class QuestionFetcher {
    private static final String API_URL = "https://opentdb.com/api.php?amount=5&type=multiple";

    public static List<Question> fetchQuestions() {
        List<Question> questions = new ArrayList<>();
        try {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            JSONObject json = new JSONObject(content.toString());
            JSONArray results = json.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {
                JSONObject obj = results.getJSONObject(i);
                String questionText = obj.getString("question");
                JSONArray incorrectAnswers = obj.getJSONArray("incorrect_answers");
                List<String> choices = new ArrayList<>();
                for (int j = 0; j < incorrectAnswers.length(); j++) {
                    choices.add(incorrectAnswers.getString(j));
                }
                String correctAnswer = obj.getString("correct_answer");
                choices.add(correctAnswer);
                // Shuffle choices to randomize their order
                java.util.Collections.shuffle(choices);
                int correctIndex = choices.indexOf(correctAnswer);

                questions.add(new Question(questionText, choices, correctIndex, null));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }
} 