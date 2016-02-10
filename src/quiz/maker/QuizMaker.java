/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.maker;

import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author Chuck
 */
public class QuizMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame jf = new JFrame();
        QuizScreen qs = new QuizScreen();
        jf.add(qs);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
        jf.setSize(450, 325);

    }

}
