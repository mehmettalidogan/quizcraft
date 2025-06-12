package wiew;

import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class QuizGUI extends JFrame {
    private Quiz quiz;
    private JLabel questionLabel;
    private JRadioButton[] choiceButtons;
    private ButtonGroup buttonGroup;
    private JButton nextButton;
    private JPanel panel;

    public QuizGUI(Quiz quiz) {
        this.quiz = quiz;
        setTitle("Quiz Uygulaması");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // ortala

        initComponents();
        loadQuestion();

        setVisible(true);
    }

    private void initComponents() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(240, 240, 240)); // Set panel background color

        questionLabel = new JLabel("Soru gelecek");
        questionLabel.setForeground(new Color(60, 60, 60)); // Set label text color
        panel.add(questionLabel, BorderLayout.NORTH);

        JPanel choicesPanel = new JPanel(new GridLayout(4, 1));
        choicesPanel.setBackground(new Color(240, 240, 240)); // Set choices panel background color
        choiceButtons = new JRadioButton[4];
        buttonGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            choiceButtons[i] = new JRadioButton("Seçenek " + (i + 1));
            choiceButtons[i].setBackground(new Color(240, 240, 240)); // Set button background color
            choiceButtons[i].setForeground(new Color(60, 60, 60)); // Set button text color
            buttonGroup.add(choiceButtons[i]);
            choicesPanel.add(choiceButtons[i]);
        }

        panel.add(choicesPanel, BorderLayout.CENTER);

        nextButton = new JButton("Sonraki");
        nextButton.setBackground(new Color(100, 150, 200)); // Set button background color
        nextButton.setForeground(Color.WHITE); // Set button text color
        nextButton.setFocusPainted(false);
        nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextButton.setBackground(new Color(120, 170, 220)); // Change color on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextButton.setBackground(new Color(100, 150, 200)); // Revert color on exit
            }
        });
        panel.add(nextButton, BorderLayout.SOUTH);

        add(panel);

        nextButton.addActionListener(e -> handleNext());
    }

    private void loadQuestion() {
        Question q = quiz.getCurrentQuestion();
        if (q == null) {
            showResult();
            return;
        }

        questionLabel.setText(q.getQuestiontext());
        List<String> choices = q.getChoices();

        for (int i = 0; i < choiceButtons.length; i++) {
            choiceButtons[i].setText(choices.get(i));
            choiceButtons[i].setSelected(false);
        }
    }

    private void handleNext() {
        int selectedIndex = -1;
        for (int i = 0; i < choiceButtons.length; i++) {
            if (choiceButtons[i].isSelected()) {
                selectedIndex = i;
                break;
            }
        }

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Lütfen bir seçenek seçin!");
            return;
        }

        quiz.submitAnswer(selectedIndex);
        if (quiz.isFinished()) {
            showResult();
        } else {
            loadQuestion();
        }
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "Quiz bitti! Skorunuz: " + quiz.getScore());
        System.exit(0);
    }

    public static void setLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Handle exception silently
        }
    }
}
