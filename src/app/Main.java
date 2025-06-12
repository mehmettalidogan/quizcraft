package app;

import wiew.QuizGUI;
import model.*;
import utils.QuestionFetcher;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Fetch questions from the API
        List<Question> questions = QuestionFetcher.fetchQuestions();

        Quiz quiz = new Quiz(questions);

        QuizGUI.setLookAndFeel();
        new QuizGUI(quiz);
    }
}
