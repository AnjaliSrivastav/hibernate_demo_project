package com.mapping.oneToOne;

import javax.persistence.*;

@Entity
public class Question {
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Id
    @Column(name="question_Id")
    private int questionId;

    public Question() {
        super();
    }

    public Question(int questionId, String question, Answer answer) {
        super();
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    private String question;

    @OneToOne
    @JoinColumn(name="ans_id")
    private Answer answer;
}
