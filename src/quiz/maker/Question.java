/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.maker;

import java.util.LinkedList;

/**
 *
 * @author Chuck
 */
public class Question {

    public static int quesID;
    int number;
    LinkedList<Option> options;
    String question;

    public Question() {

    }

    public Question(String ques, int n) {
        number = ++quesID;
        question = ques;
        options = new LinkedList<>();
    }

    public void addOption(String ans, boolean isRgtAns) {

        options.add(new Option(ans, isRgtAns));

    }

    public String getQuestionText() {
        return question;
    }

    public String getOptionText(int i) {
        return options.get(i).getAnswer();
    }

    public int pollAnswer() {
        boolean errors = false;
        int count = 0;
        for (Option o : options) {
            if (o.isChecked()) {
                count++;
                if (!o.isRgtAns()) {
                    errors = true;
                }
            }
        }
        if (count == 0) {
            errors = true;
        }

        if (errors) {
            return 0;
        } else {
            return 1;
        }
    }
}
