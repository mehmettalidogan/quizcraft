package model;
import java.util.List;
public class Quiz {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;
    public Quiz(List<Question> questions) {
     this.questions = questions;
     this.currentQuestionIndex = 0;
     this.score = 0;
    }
    public Question getCurrentQuestion() {
        if(currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        }
        return null;
    }
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public void submitAnswer(int selectedIndex) {
        Question current = questions.get(currentQuestionIndex);
        if (current.isCorrect(selectedIndex)) {
            score++;
        }
        currentQuestionIndex++;
    }
    // Oyunun bittiğini kontrol eder.
    public boolean isFinished() {
        return currentQuestionIndex >= questions.size();
    }
   // skoru döndürelim
    public int getScore() {
        return score;
    }

}
