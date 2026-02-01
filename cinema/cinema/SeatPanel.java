package cinema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeatPanel extends JPanel {
    private JButton[][] seatButtons;
    private int ticketQuantity;
    private ArrayList<String> selectedSeats;

    public SeatPanel(int rows, int cols, int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
        selectedSeats = new ArrayList<>();

        setLayout(new GridLayout(rows, cols, 5, 5));
        seatButtons = new JButton[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seatButtons[i][j] = new JButton(Character.toString((char) ('A' + i)) + (j + 1));
                seatButtons[i][j].setFont(new Font("Arial", Font.PLAIN, 14));
                seatButtons[i][j].setPreferredSize(new Dimension(60, 40));
                seatButtons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton button = (JButton) e.getSource();
                        String seat = button.getText();

                        if (selectedSeats.contains(seat)) {
                            selectedSeats.remove(seat);
                            button.setBackground(null);
                        } else {
                            if (selectedSeats.size() < ticketQuantity) {
                                selectedSeats.add(seat);
                                button.setBackground(Color.GREEN);
                            }
                        }
                    }
                });
                add(seatButtons[i][j]);
            }
        }
    }

    public ArrayList<String> getSelectedSeats() {
        return selectedSeats;
    }
}
