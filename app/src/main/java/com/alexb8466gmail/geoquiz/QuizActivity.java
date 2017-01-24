package com.alexb8466gmail.geoquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
private Button mFalseButton;
    private Button mTrueButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
private Button mPrevButton;
    private Question[] mQuestionBank=new Question[]
            {
                    new Question(R.string.question_africa, true),
                    new Question(R.string.question_asia, true),
                    new Question(R.string.question_mideast,false),
                    new Question(R.string.question_ocean, true),
                    new Question(R.string.question_america, true)

            };

    private int mCurrentIndex=0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mFalseButton=(Button)findViewById(R.id.false_button);
        mTrueButton=(Button)findViewById(R.id.true_button);
        mQuestionTextView=(TextView)findViewById(R.id.question_text_view);
mPrevButton=(Button)findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex=(mCurrentIndex-1)%mQuestionBank.length;
updateQuestion();
            }
        });


        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
checkAnsware(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
checkAnsware(false);
            }
        });
        mNextButton=(Button)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
                updateQuestion();
            }
        });
        updateQuestion();
    }

    private void updateQuestion() {

        int question=mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);

    }
    private void checkAnsware(boolean userPressedTrue)
    {
boolean answareIsTrue=mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId=0;
        if(userPressedTrue==answareIsTrue)
        {
            messageResId=R.string.correct_toast;

        }
        else {

            messageResId=R.string.incorrect_toast;
        }
        Toast.makeText(QuizActivity.this, messageResId, Toast.LENGTH_LONG).show();


    }

}
