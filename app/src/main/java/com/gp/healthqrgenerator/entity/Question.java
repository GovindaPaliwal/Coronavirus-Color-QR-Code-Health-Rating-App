package com.gp.healthqrgenerator.entity;

public class Question {

    private String que;

    private boolean answer;

    private int poins;

    public Question(String que, boolean answer, int poins) {
        this.que = que;
        this.answer = answer;
        this.poins = poins;
    }

    public int getPoins() {
        return poins;
    }

    public String getQue() {
        return que;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public void setPoins(int poins) {
        this.poins = poins;
    }

    public void setQue(String que) {
        this.que = que;
    }
}

