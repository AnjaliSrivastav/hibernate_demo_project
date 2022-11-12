package com.mapping.oneToMany;


import javax.persistence.*;

@Entity
public class ManyAnswer {
    @Id
    @Column(name = "answer_id")
    private int answerId;

    public ManyAnswer(int answerId, String answer, OneQuestion question) {
        super();
        this.answerId = answerId;
        this.answer = answer;
        this.question = question;
    }

    private String answer;

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public OneQuestion getQuestion() {
        return question;
    }

    public void setQuestion(OneQuestion question) {
        this.question = question;
    }

    public ManyAnswer() {
        super();
    }

    @ManyToOne
    private OneQuestion question;
}
