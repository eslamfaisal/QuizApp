package com.example.android.quizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearQuestionOne;
    LinearLayout linearQuestionTwo;
    LinearLayout linearQuestionThree;
    LinearLayout linearQuestionFour;
    LinearLayout linearQuestionFive;
    LinearLayout linearQuestionSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //this method called when Submit button is clicked
    public void summary_goal(View v) {

        EditText name = (EditText) findViewById(R.id.name);
        String Name = name.getText().toString();

        //check if Right answer of question 1 is checked or no
        RadioButton answer_1_q_1 = (RadioButton) findViewById(R.id.answer_1_qestion_1_in_1995);
        boolean checked = answer_1_q_1.isChecked();

        //check if Right answer of question 2 is checked or no
        RadioButton answer_3_q_2 = (RadioButton) findViewById(R.id.answer_2_qusetion_2_by_sunmicrosystem);
        boolean checked2 = answer_3_q_2.isChecked();

        //check if the first Right answer of question 3 is checked or no
        CheckBox answer_2_q_3 = (CheckBox) findViewById(R.id.answer_2_qestion_3_james_gosling);
        boolean checked3 = answer_2_q_3.isChecked();

        //check if the first Right answer of question 4 is checked or no
        CheckBox answer_1_q_4 = (CheckBox) findViewById(R.id.answer_1_qestion_4_android);
        boolean checked5 = answer_1_q_4.isChecked();

        //check if the secound Right answer of question 4 is checked or no
        CheckBox answer_2_q_4 = (CheckBox) findViewById(R.id.answer_2_qestion_3_Desktop_Applicatio);
        boolean checked6 = answer_2_q_4.isChecked();

        //check if Right answer of question 5 is checked or no
        RadioButton answer_1_q_5 = (RadioButton) findViewById(R.id.answer_1_qestion_5_bill);
        boolean checked7 = answer_1_q_5.isChecked();

        //check if Right answer of question 4 is checked or no
        CheckBox answer_3_q_4 = (CheckBox) findViewById(R.id.answer_3_qestion_4_No_Thing);
        boolean Checked4 = answer_3_q_4.isChecked();

        //check if Right answer of question 3 is checked or no
        CheckBox answer_1_q_3 = (CheckBox) findViewById(R.id.answer_1_qestion_3_eslam_faisal);
        boolean Checked8 = answer_1_q_3.isChecked();

        //check if Right answer of question 3 is checked or no
        CheckBox answer_3_q_3 = (CheckBox) findViewById(R.id.answer_3_qestion_3_Steve_Jobs);
        boolean Checked9 = answer_3_q_3.isChecked();

        EditText answer = (EditText) findViewById(R.id.answer_text);
        String textAnswer = answer.getText().toString().trim().toLowerCase();

        //save  number Of Right Question  in a variable
        int numberOfRightQuestion = checkRightAnswer(textAnswer, checked, checked2, checked3, Checked4, checked5, checked6, checked7, Checked8, Checked9);

        //save  messageGoal  in a variable
        String messageGoal = creatSummaryGoal(numberOfRightQuestion, Name);

        //disblay the missage of summary goal
        displayMessage(messageGoal);
    }

    public int checkRightAnswer(String answer, boolean answer1, boolean answer2, boolean answer2_Of_Q3, boolean answer3_Of_Q4
            , boolean answer1_Of_Q4, boolean answer2_Of_Q4, boolean answer1_Of_Q5, boolean answer1_Of_Q3, boolean answer3_Of_Q3) {

        //set number of Right questions
        int numberOfRightQuestion = 0;

        //incres number Of Right Question by 1 if the right answer is checked
        if (answer1)
            numberOfRightQuestion++;

        //incres number Of Right Question by 1 if the right answer is checked
        if (answer2)
            numberOfRightQuestion++;

        //incres number Of Right Question by 1 if the two right answers is checked
        if (answer1_Of_Q4 && answer2_Of_Q4 && !answer3_Of_Q4)
            numberOfRightQuestion++;

        //incres number Of Right Question by 1 if the right answers is checked
        if (answer2_Of_Q3 && !answer1_Of_Q3 && !answer3_Of_Q3)
            numberOfRightQuestion++;

        //incres number Of Right Question by 1 if the right answers is checked
        if (answer1_Of_Q5)
            numberOfRightQuestion++;

        if (answer.equalsIgnoreCase("java")) {
            numberOfRightQuestion++;
        }
        return numberOfRightQuestion;
    }

    //this method set message and Toast of summary goal
    public String creatSummaryGoal(int numberOfRightQuestion, String name) {
        String message = getString(R.string.name) + name;
        message += "\n" + getString(R.string.rightAnswer) + " " + numberOfRightQuestion;

        Toast.makeText(MainActivity.this,
                getString(R.string.rightAnswer) + " " + numberOfRightQuestion, Toast.LENGTH_LONG).show();
        return message;
    }

    //this method display message  of summary goal
    public void displayMessage(String message) {
        TextView goalTextView = (TextView) findViewById(R.id.summary_text);
        goalTextView.setText(String.valueOf(message));
        goalTextView.setTextSize(20);
        goalTextView.setTextColor(Color.BLACK);
    }

    public void question_1(View view) {
        linearQuestionOne = (LinearLayout) findViewById(R.id.linear_question_one);
        visibility(linearQuestionOne);
    }

    public void question_2(View view) {
        linearQuestionTwo = (LinearLayout) findViewById(R.id.linear_question_two);
        visibility(linearQuestionTwo);
    }

    public void question_3(View view) {
        linearQuestionThree = (LinearLayout) findViewById(R.id.linear_question_three);
        visibility(linearQuestionThree);
    }

    public void question_4(View view) {
        linearQuestionFour = (LinearLayout) findViewById(R.id.linear_question_four);
        visibility(linearQuestionFour);
    }

    public void question_5(View view) {
        linearQuestionFive = (LinearLayout) findViewById(R.id.linear_question_five);
        visibility(linearQuestionFive);
    }

    public void question_6(View view) {
        linearQuestionSix = (LinearLayout) findViewById(R.id.linear_question_six);
        visibility(linearQuestionSix);
    }

    public void visibility(View linearLayout) {
        if (linearLayout.getVisibility() == View.GONE) {
            linearLayout.setVisibility(View.VISIBLE);
        } else {
            linearLayout.setVisibility(View.GONE);
        }
    }
}
