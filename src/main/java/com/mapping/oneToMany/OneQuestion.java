package com.mapping.oneToMany;



import javax.persistence.*;
import java.util.List;

@Entity
public class OneQuestion {
    @Id
    @Column(name="question_Id")
    private int questionId;

    public OneQuestion() {
        super();
    }

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

    public List<ManyAnswer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<ManyAnswer> answer) {
        this.answer = answer;
    }

    public OneQuestion(int questionId, String question, List<ManyAnswer> answer) {
        super();
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    private String question;

    @OneToMany(mappedBy = "question")
    private List<ManyAnswer> answer;
}
