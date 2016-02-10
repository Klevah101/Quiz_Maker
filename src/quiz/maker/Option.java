/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.maker;

/**
 *
 * @author Chuck
 */
public class Option {

    int x;
    int y;
    boolean checked;
    int width;
    int height;
    String answer;
    boolean rgtAns;

    public Option() {

    }

    public Option(String ans, boolean correct) {
        checked=false;
        answer = ans;
        rgtAns = correct;
        width = 10;
        height = 10;
    }

    public void setX(int xx) {
        x = xx;
    }

    public void setY(int yy) {
        y = yy;
    }

    public boolean isChecked() {
        return checked;
    }

    public boolean isRgtAns() {
        return rgtAns;
    }

    public void clickBox() {
        if (checked) {
            checked = false;
        } else {
            checked = true;
        }
        //System.out.println(checked);
    }

    public String getAnswer() {
        return answer;
    }
}
