package model;

import java.util.List;

public class Question {
    private String questiontext;
    private List<String> choices;
    private int correctAnswerIndex;
    private String category;

    public Question(String questiontext, List<String> choices, int correctAnswerIndex, String category) {
        this.questiontext = questiontext;
        this.choices = choices;
        this.correctAnswerIndex = correctAnswerIndex;
        this.category = category;
    }

    public String getQuestiontext() {
        return questiontext;
    }

    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isCorrect(int index) {
        return index == correctAnswerIndex;
    }
}
