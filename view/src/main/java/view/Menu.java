package view;

import contract.LevelObserve;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Menu extends JFrame {
    int choice = 0;
    List<LevelObserve> observators = new ArrayList<>();


    public List<LevelObserve> getObservators(){
        return observators;
    }

    public void setObservators(List<LevelObserve> observators){
        this.observators = observators;
    }

    public Menu(){
        setSize(new Dimension(350, 75));
        this.setTitle("BoulderDash Exia A1 G2");
        setLayout(new BorderLayout());
        JPanel butonPane = new JPanel();
        JButton buton2 = new JButton("Choose level");
        JButton buton3 = new JButton("EXIT");
        JButton buton4 = new JButton("Help");

        buton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] level = {"Level 1", "Level 2", "Level 3", "Level 4", "Level 5"};
                JOptionPane jop = new JOptionPane();
                String name = (String) jop.showInputDialog(null, "Choose a level :", "Level choice", JOptionPane.QUESTION_MESSAGE, null, level, level[0]);
                if(name == "Level 1"){
                    choice = 1;
                }
                if(name == "Level 2"){
                    choice = 2;
                }
                if(name == "Level 3"){
                    choice = 3;
                }
                if(name == "Level 4"){
                    choice = 4;
                }
                if(name == "Level 5"){
                    choice = 5;
                }
                for (LevelObserve observator : observators){
                    observator.selectedLevel(choice);
                }
            }
        });

        buton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fermer();
            }
        });

        buton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Ajouter de l'aide");
            }
        });
        butonPane.add(buton2);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(butonPane, BorderLayout.SOUTH);
        this.setVisible(true);
        butonPane.add(buton3);
        butonPane.add(buton4);
    }

    public void fermer(){
        dispose();
    }

    public int getChoice(){
        return choice;
    }
}
