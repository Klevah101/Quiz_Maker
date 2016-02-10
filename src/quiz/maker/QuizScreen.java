/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.maker;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author Chuck
 */
class Button {

    int width;
    int height;
    int x;
    int y;
    int amt;

    public Button(int i, int xx, int yy) {
        amt = i;
        width = 50;
        height = 20;
        x = xx;
        y = yy;
    }
}

public class QuizScreen extends JPanel implements MouseListener {

    boolean showScore = false;
    int[] score;
    LinkedList<Question> questions;
    int currQues;
    Button next = new Button(1, 65, 250);
    Button prev = new Button(-1, 0, 250);
    Button endTest = new Button(0, 250, 250);
    boolean nextClicked;
    boolean prevClicked;

    public QuizScreen() {
        super();
        addMouseListener(this);
        currQues = 0;
        questions = new LinkedList<>();
        addQuestions();
        testQuestion();

    }

    public void testQuestion() {
        System.out.println(getQuestion(currQues));
        for (Option o : questions.get(currQues).options) {

            System.out.println(o.getAnswer());
        }

    }

    public String getQuestion(int i) {
        return questions.get(i).getQuestionText();
    }

    public String getOptionText(int ques, int opt) {
        return questions.get(ques).getOptionText(opt);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 300);
        drawQuestions(g);
        drawButtons(g);
        showScore(g);
        resetButtons();

        g.dispose();
    }

    private void clsnCheck(int x, int y) {
        if (x > next.x && x < next.x + next.width) {
            if (y > next.y && y < next.y + next.height) {
                // nextClicked = true;
                //  System.out.println("Next Button Clicked");
                System.out.println(questions.get(currQues).pollAnswer());
                score[currQues] = questions.get(currQues).pollAnswer();
                currQues++;
                if (currQues > questions.size() - 1) {
                    currQues = questions.size() - 1;
                } else {

                }

            }
        }
        if (x > prev.x && x < prev.x + prev.width) {
            if (y > prev.y && y < prev.y + prev.height) {
                // prevClicked = true;
                //  System.out.println("Prev Button Clicked"); 
                score[currQues] = questions.get(currQues).pollAnswer();
                currQues--;
                if (currQues < 0) {
                    currQues = 0;
                } else {

                }
                System.out.println(questions.get(currQues).pollAnswer());
            }
        }

        if (x > endTest.x && x < endTest.x + endTest.width) {
            score[currQues] = questions.get(currQues).pollAnswer();
            if (y > endTest.y && y < endTest.y + endTest.height) {
                if (showScore) {
                    showScore = false;
                } else {
                    showScore = true;
                }
            }

        }
        for (Option o : questions.get(currQues).options) {
            if (x > o.x && x < o.x + o.width) {
                if (y > o.y && y < o.y + o.height) {
                    o.clickBox();
                }
            }
        }
        //  System.out.println(currQues);
        repaint();
    }

    public void resetButtons() {
        nextClicked = false;
        prevClicked = false;
    }

    private void drawButtons(Graphics g) {
        g.fillRect(next.x, next.y, next.width, next.height);
        g.fillRect(prev.x, prev.y, prev.width, prev.height);
        g.fillRect(endTest.x, endTest.y, endTest.width, endTest.height);
    }

    private void drawQuestions(Graphics g) {
        int x, y;
        x = 0;
        y = 20;
        g.setColor(Color.white);

        g.drawString(questions.get(currQues).number + ")  " + questions.get(currQues).getQuestionText(), x, y);
        y += 5;
        g.drawLine(x, y, x + 300, y);
        y += 15;
        for (Option o : questions.get(currQues).options) {
            if (o.getAnswer() != null) {
                o.setY(y - o.height);
                if (o.isChecked()) {
                    g.setColor(Color.green);
                } else {
                    g.setColor(Color.red);
                }
                g.fillRect(o.x, o.y, o.width, o.height);
                g.setColor(Color.white);
                g.drawString(o.getAnswer(), x + o.width + 5, y);
                y += 15;
            }
        }
    }

    public void addQuestions() {
        int quesID = 0;
        questions.add(new Question("Why did the chicken cross the road?", quesID));
        questions.get(quesID).addOption("To get to the other side.", true);
        questions.get(quesID).addOption("He was running form the cops.", false);
        questions.get(quesID).addOption("He forgot his wallet and had to go back home", false);
        questions.get(quesID).addOption("Aliens!!", false);
        quesID++;
        questions.add(new Question("Red + blue make which color?", quesID));
        questions.get(quesID).addOption("Green.", false);
        questions.get(quesID).addOption("Purple.", true);
        quesID++;
        questions.add(new Question("Question 3", quesID));
        quesID++;
        questions.add(new Question("Question 4", quesID));

        score = new int[questions.size()];
    }

    public void showScore(Graphics g) {
        if (showScore) {
            int s = 0;
            for (int i : score) {
                s += i;
            }
            g.drawString(Integer.toString(s), 400, 265);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        clsnCheck(e.getX(), e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
