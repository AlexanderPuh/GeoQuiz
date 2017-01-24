package com.alexb8466gmail.geoquiz;

/**
 * Created by User on 23.01.2017.
 */

public class Question {

    private int mTextResId;
    private boolean mAnswerTrue;
    public Question(int TextResId, boolean AnswerTrue)
    {
mTextResId=TextResId;
        mAnswerTrue=AnswerTrue;

    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
