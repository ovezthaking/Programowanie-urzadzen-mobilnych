package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView pytanie, pytania;
    private ProgressBar progressBar;
    private RadioGroup odpowiedzi;
    private Button nastepne;

    private List<Question> questionList;
    private int currentQuestionIndex;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        pytania = findViewById(R.id.pytania);
        pytanie = findViewById(R.id.pytanie);
        progressBar = findViewById(R.id.progressBar);
        odpowiedzi = findViewById(R.id.odpowiedzi);
        questionList = generateQuestions();
        displayQuestion();
        nastepne = findViewById(R.id.nastepne);

        nastepne.setOnClickListener(v -> {
                checkAnswer();
                currentQuestionIndex++;
                if (currentQuestionIndex < questionList.size()) {
                    displayQuestion();
                } else {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                    finish();
                }

        });


    }


    private List<Question> generateQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Jaką właściwość ciała określa stosunek masy do objętości?",
                new String[]{"Prędkość", "Energia kinetyczna", "Gęstość", "Temperatura"}, 2));
        questions.add(new Question("Jaką funkcję pełni mitochondrium w komórce?",
                new String[]{"Produkcja energii", "Przemieszczanie komórki", "Replikacja DNA", "Synteza białek"}, 0));
        questions.add(new Question("Jaki jest chemiczny symbol wody?",
                new String[]{"H2", "O2", "H2O", "CO2"}, 2));
        questions.add(new Question("Które z poniższych jest planetą?",
                new String[]{"Księżyc", "Słońce", "Mars", "Betelgeza"}, 2));
        questions.add(new Question("Który pierwiastek chemiczny ma symbol 'O'?",
                new String[]{"Wodór", "Tlen", "Azot", "Hel"}, 1));
        questions.add(new Question("Która z poniższych jednostek jest jednostką mocy?",
                new String[]{"Joule", "Wat", "Niuton", "Kelwin"}, 1));
        questions.add(new Question("Co mierzy termometr?",
                new String[]{"Ciśnienie", "Temperaturę", "Prędkość", "Czas"}, 1));
        questions.add(new Question("Jaka jest funkcja układu krwionośnego?",
                new String[]{"Trawienie pokarmu", "Dostarczanie tlenu i substancji odżywczych", "Regulacja temperatury", "Wydalanie odpadów"}, 1));
        questions.add(new Question("Która planeta jest najbliższa Słońcu?",
                new String[]{"Ziemia", "Mars", "Merkury", "Wenus"}, 2));
        questions.add(new Question("Który pierwiastek chemiczny jest najlżejszy?",
                new String[]{"Tlen", "Hel", "Wodór", "Azot"}, 2));


        return questions;
    }
    private void displayQuestion() {
        Question currentQuestion = questionList.get(currentQuestionIndex);
        pytania.setText("Pytanie " + (currentQuestionIndex + 1) + "/10");
        pytanie.setText(currentQuestion.getQuestionText());
        RadioButton odpowiedz1 = findViewById(R.id.odpowiedz1);
        RadioButton odpowiedz2 = findViewById(R.id.odpowiedz2);
        RadioButton odpowiedz3 = findViewById(R.id.odpowiedz3);
        RadioButton odpowiedz4 = findViewById(R.id.odpowiedz4);
        odpowiedz1.setText(currentQuestion.getOptions()[0]);
        odpowiedz2.setText(currentQuestion.getOptions()[1]);
        odpowiedz3.setText(currentQuestion.getOptions()[2]);
        odpowiedz4.setText(currentQuestion.getOptions()[3]);
        progressBar.setProgress((currentQuestionIndex + 1) * 10);
        odpowiedzi.clearCheck();
    }

    private void checkAnswer() {
        int selectedRadioButtonId = odpowiedzi.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            int selectedAnswerIndex = odpowiedzi.indexOfChild(findViewById(selectedRadioButtonId));
            if (selectedAnswerIndex == questionList.get(currentQuestionIndex).getCorrectAnswerIndex()) {
                score += 10;
            }
        }
    }


}