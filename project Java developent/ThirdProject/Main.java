package MySecondProject.JavaThirdProject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public QuizQuestion(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;

    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

class Quiz {
    private List<QuizQuestion> questions;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;

    public Quiz(List<QuizQuestion> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public void start() {
        if (currentQuestionIndex < questions.size()) {
            displayQuestion();
        } else {
            endQuiz();
        }
    }

    private void displayQuestion() {
        QuizQuestion question = questions.get(currentQuestionIndex);
        System.out.println("Question: " + question.getQuestion());
        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        startTimer();
    }

    private void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                checkAnswer(-1);
            }
        }, 15000); // 15 seconds timer

    }

    public void submitAnswer(int selectedOptionIndex) {
        timer.cancel();
        checkAnswer(selectedOptionIndex);
    }

    private void checkAnswer(int selectedOptionIndex) {
        QuizQuestion question = questions.get(currentQuestionIndex);
        int correctOptionIndex = question.getCorrectOptionIndex();

        if (selectedOptionIndex == correctOptionIndex) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer was option " + (correctOptionIndex +1));
        }

        currentQuestionIndex++;
        start();
    }

    private void endQuiz() {
        System.out.println("Quiz ended. Your score: " + score + "/" + questions.size());
    }
}

public class Main {
    public static void main(String[] args) {
        List<QuizQuestion> questions = new ArrayList<>();
        // Add Question for Quiz
        
        questions.add(new QuizQuestion("Who invented Java programing?",
                List.of("Guido Van Rossum", "Jame Gosling", "Dennis Ritchie", "Bjarne Stroustrup"), 1));
        
                
        
        questions.add(new QuizQuestion("Which one of the following is not a java feature?",
                  List.of("Object-oriented", "use of pointer", "Portable", "Dynamic and Extensible"), 1)); 
                
        
         questions.add(new QuizQuestion("Which of these cannot be used for a variable name in java?",
                  List.of("identifier & keyword", "identifier", "keyword", "none of the mentioned"), 3));        
        Quiz quiz = new Quiz(questions);

        Scanner scanner = new Scanner(System.in);
        while (quiz != null) {
            quiz.start();
            System.out.print("Enter your answer (1-4, -1 to skip): ");
            int selectedOptionIndex = scanner.nextInt();
            quiz.submitAnswer(selectedOptionIndex - 1); 
        }
    }
}
