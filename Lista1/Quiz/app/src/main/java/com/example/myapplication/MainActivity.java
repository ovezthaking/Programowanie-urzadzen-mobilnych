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
        questions.add(new Question("AJaką właściwość ciała określa stosunek masy do objętości?",
                new String[]{"Prędkość", "Energia kinetyczna", "Gęstość", "Temperatura"}, 2));
        questions.add(new Question("BJaką właściwość ciała określa stosunek masy do objętości?",
                new String[]{"Prędkość", "Energia kinetyczna", "Gęstość", "Temperatura"}, 2));
        questions.add(new Question("CJaką właściwość ciała określa stosunek masy do objętości?",
                new String[]{"Prędkość", "Energia kinetyczna", "Gęstość", "Temperatura"}, 2));
        questions.add(new Question("DJaką właściwość ciała określa stosunek masy do objętości?",
                new String[]{"Prędkość", "Energia kinetyczna", "Gęstość", "Temperatura"}, 2));
        questions.add(new Question("EJaką właściwość ciała określa stosunek masy do objętości?",
                new String[]{"Prędkość", "Energia kinetyczna", "Gęstość", "Temperatura"}, 2));
        questions.add(new Question("FJaką właściwość ciała określa stosunek masy do objętości?",
                new String[]{"Prędkość", "Energia kinetyczna", "Gęstość", "Temperatura"}, 2));
        questions.add(new Question("GJaką właściwość ciała określa stosunek masy do objętości?",
                new String[]{"Prędkość", "Energia kinetyczna", "Gęstość", "Temperatura"}, 2));
        questions.add(new Question("HJaką właściwość ciała określa stosunek masy do objętości?",
                new String[]{"Prędkość", "Energia kinetyczna", "Gęstość", "Temperatura"}, 2));
        questions.add(new Question("Iaściwość ciała określa stosunek masy do objętości?",
                new String[]{"Prędkość", "Energia kinetyczna", "Gęstość", "Temperatura"}, 2));


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