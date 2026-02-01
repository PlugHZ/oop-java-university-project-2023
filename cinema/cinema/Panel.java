package cinema;



import cinema.Cinema;
import cinema.Movie;
import cinema.Food;
import cinema.Theater;
import cinema.Order;
import cinema.Payment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Panel extends JPanel {
    private JComboBox<Cinema> cinemaComboBox;
    private JComboBox<Theater> theaterComboBox;
    private JComboBox<Movie> movieComboBox;
    private JComboBox<Food> foodComboBox;
    private JComboBox<String> ticketQuantityComboBox;
    private JTextField nameField;
    private JComboBox<String> paymentMComboBox;
    private JButton submitButton;
    private SeatPanel seatPanel;

    public Panel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);

        //  name
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(new JLabel("Enter Name"), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        nameField = new JTextField(10);
        add(nameField, gridBagConstraints);

        //  cinema 
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(new JLabel("Cinema"), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        cinemaComboBox = new JComboBox<>();
        cinemaComboBox.addItem(new Cinema("-- Select Cinema --", "-"));
        cinemaComboBox.addItem(new Cinema("Sriracha Cineplex", "Central Sriracha Shopping Center Building, No. 8 Sukhumvit Road, Sriracha Subdistrict, Sriracha District, Chonburi Province 20110"));
        cinemaComboBox.addItem(new Cinema("EGV Sriracha", "90,90/1 3rd floor Pacific Park Sriracha, Sukhumvit Km.118 Road , Si Racha District, Chon Buri 20110"));
        add(cinemaComboBox, gridBagConstraints);

        // Theater
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(new JLabel("Theater"), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        theaterComboBox = new JComboBox<>();
        theaterComboBox.addItem(new Theater("-- Select TheaterClass --", 0));
        theaterComboBox.addItem(new Theater("Standard", 160));
        theaterComboBox.addItem(new Theater("Honeymoon",200));
        theaterComboBox.addItem(new Theater("IMAX", 300));
        theaterComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Theater) {
                    Theater theater = (Theater) value;
                    if (theater.getPrice() == 0) {
                        value = theater.getName();
                    } else{
                    value = theater.getName() + " (THB " + theater.getPrice() + ")";
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
                return list;
            }
        });
        add(theaterComboBox, gridBagConstraints);


        // Movie
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        add(new JLabel("Movie"), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        movieComboBox = new JComboBox<>();
        movieComboBox.addItem(new Movie("-- Select Movie --", "-"));
        movieComboBox.addItem(new Movie("Godzilla x Kong The New Empire", "Action , Adventure"));
        movieComboBox.addItem(new Movie("Exhuma", "Horror , Thriller"));
        movieComboBox.addItem(new Movie("Dune Part Two", "Action , Adventure , Drama , Fantasy , Sci-Fi"));
        movieComboBox.addItem(new Movie("Kung Fu Panda 4", "Action , Adventure , Animation"));
        movieComboBox.addItem(new Movie("Detective Conan vs Kid the Phantom", "Action , Animation , Crime"));
        add(movieComboBox, gridBagConstraints);

        //  Ticket Quantityจำนวนตั๋ว
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        add(new JLabel("Ticket Quantity"), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        ticketQuantityComboBox = new JComboBox<>();
        ticketQuantityComboBox.addItem("-- Select Ticket Quantity --");
        for (int i = 1; i <= 5; i++) {
            ticketQuantityComboBox.addItem(Integer.toString(i));
        }
        add(ticketQuantityComboBox, gridBagConstraints);

        //  Food
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        add(new JLabel("Food"), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        foodComboBox = new JComboBox<>();
        foodComboBox.addItem(new Food("-- Select Food --", 0));
        foodComboBox.addItem(new Food("Popcorn", 100));
        foodComboBox.addItem(new Food("Pepsi", 80));
        foodComboBox.addItem(new Food("Set A", 150));
        foodComboBox.addItem(new Food("Set B", 250));
        foodComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Food) {
                    Food food = (Food) value;
                    // หากราคาเป็น 0 ให้แสดงเฉพาะชื่ออาหาร
                    if
                    (food.getPrice() == 0){

                     value = food.getName();
                    }else{
                    value = food.getName() + " (THB " + food.getPrice() + ")";
                    }
                    
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
        add(foodComboBox, gridBagConstraints);


        //  payment
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        add(new JLabel("Payment"), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        paymentMComboBox = new JComboBox<>();
        paymentMComboBox.addItem("-- Select Payment --");
        paymentMComboBox.addItem("Cash");
        paymentMComboBox.addItem("Credit Card");
        add(paymentMComboBox, gridBagConstraints);

        // Seat
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        seatPanel = new SeatPanel(5, 5, 1);
        add(seatPanel, gridBagConstraints);

        // เพิ่ม "Screen" โดยมีตัวเขียนอยู่ตรงกลางและมีเส้นขอบสี่เหลี่ยม 
        JLabel layarLabel = new JLabel("Screen");
        layarLabel.setHorizontalAlignment(JLabel.CENTER);
        layarLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        add(layarLabel, gridBagConstraints);

        // Submit Button
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        submitButton = new JButton("Submit");
        add(submitButton, gridBagConstraints);

        //totalprice
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        add(new JLabel("Total Price: "), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        JLabel totalPriceLabel = new JLabel("THB 0");
        add(totalPriceLabel, gridBagConstraints);

        ticketQuantityComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTotalPrice(totalPriceLabel);
            }
        });

        theaterComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTotalPrice(totalPriceLabel);
            }
        });

        foodComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTotalPrice(totalPriceLabel);
            }
        });

        paymentMComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTotalPrice(totalPriceLabel);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });


        ticketQuantityComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                int ticketQuantity = Integer.parseInt((String) comboBox.getSelectedItem());
                seatPanel.removeAll();
                seatPanel.setLayout(new GridLayout(5, 5, 5, 5));
                seatPanel.revalidate();
                seatPanel.repaint();
                seatPanel = new SeatPanel(5, 5, ticketQuantity);
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 7;
                gridBagConstraints.gridwidth = 2;
                gridBagConstraints.anchor = GridBagConstraints.NORTH;
                add(seatPanel, gridBagConstraints);
                revalidate();
                repaint();
            }
        });
    }

    private void updateTotalPrice(JLabel totalPriceLabel) {
        try {
            Theater theater = (Theater) theaterComboBox.getSelectedItem();
            int ticketQuantity = Integer.parseInt((String) ticketQuantityComboBox.getSelectedItem());
            Food food = (Food) foodComboBox.getSelectedItem();

            Order order = new Order(null, ticketQuantity, food, null, theater);
            DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
            double totalPrice = order.getTotalPrice();

            totalPriceLabel.setText("THB " + decimalFormat.format(totalPrice));
        } catch (NumberFormatException ex) {
            totalPriceLabel.setText("THB 0");
        }
    }

    private void submitForm() {

        String name = nameField.getText();

        try {
            // ตรวจสอบว่าผู้ใช้ป้อนชื่อโดยใช้ตัวอักษรและช่องว่างที่ถูกต้อง
            if (!name.matches("[a-zA-Z\\s]+")) {
                throw new IllegalArgumentException("Please input your name using correct letters and spaces!");
            }
            // ตรวจสอบว่าผู้ใช้เลือกโรงภาพยนตร์
            else if (cinemaComboBox.getSelectedIndex() == 0) {
                throw new IllegalArgumentException("You haven't selected a cinema!");
            }
            // ตรวจสอบว่าผู้ใช้เลือกโรงภาพยนตร์ theater
            else if (theaterComboBox.getSelectedIndex() == 0) {
                throw new IllegalArgumentException("You haven't selected a theater class!");
            }
            // ตรวจสอบว่าผู้ใช้เลือกภาพยนตร์ Movie
            else if (movieComboBox.getSelectedIndex() == 0) {
                throw new IllegalArgumentException("You haven't selected a movie!");
            }
            // ตรวจสอบว่าผู้ใช้เลือกจำนวนตั๋ว
            else if (ticketQuantityComboBox.getSelectedIndex() == 0) {
                throw new IllegalArgumentException("You haven't selected the ticket quantity!");
            }
            // ตรวจสอบว่าผู้ใช้เลือกวิธีการชำระเงิน
            else if (paymentMComboBox.getSelectedIndex() == 0) {
                throw new IllegalArgumentException("You haven't selected the payment method!");
            }
            // ตรวจสอบว่าผู้ใช้เลือกที่นั่ง
            else if (seatPanel.getSelectedSeats().size() == 0) {
                throw new IllegalArgumentException("You haven't selected the seats!");
            }
            // ตรวจสอบว่าผู้ใช้เลือกที่นั่งตามจำนวนตั๋ว
            else if (seatPanel.getSelectedSeats().size() != Integer.parseInt((String) ticketQuantityComboBox.getSelectedItem())) {
                throw new IllegalArgumentException("You must select seats equal to the ticket quantity!");
            }

            Cinema cinema = (Cinema) cinemaComboBox.getSelectedItem();
            Theater theater = (Theater) theaterComboBox.getSelectedItem();
            Movie movie = (Movie) movieComboBox.getSelectedItem();
            int ticketQuantity = Integer.parseInt((String) ticketQuantityComboBox.getSelectedItem());
            Food food = (Food) foodComboBox.getSelectedItem();
            String payment = (String) paymentMComboBox.getSelectedItem();
            ArrayList<String> selectSeats = seatPanel.getSelectedSeats();

            Order order = new Order(movie, ticketQuantity, food, cinema, theater);
            Payment paymentM = new Payment(payment);

            DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
            double totalPrice = order.getTotalPrice();

            String selectedSeatsText = "Seat No.: ";
            for (String seat : selectSeats) {
                selectedSeatsText += seat + ", ";
            }
            if (selectedSeatsText.endsWith(", ")) {
                selectedSeatsText = selectedSeatsText.substring(0, selectedSeatsText.length() - 2);
            }

            // หากไม่ได้เลือกอาหาร แสดงว่าตอนสรุปผลลัพจะไม่มีอาหาร


            String summary = "Name: " + name + "\n" +
            "Cinema: " + cinema.getName() + " (" + cinema.getAddress() + ")\n" +
            "Theater: " + theater.getName() + " - THB " + decimalFormat.format(theater.getPrice()) + "\n" +
            "Movie: " + movie.getTitle() + " (" + movie.getType() + ")\n" +
            "Ticket Quantity: " + ticketQuantity + "\n" +
            printFood() +
            "Payment: " + payment + "\n" +
            selectedSeatsText + "\n" +
            "Total Price: THB " + decimalFormat.format(totalPrice);

            JOptionPane.showMessageDialog(Panel.this, summary, "Order Summary", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ticket Quantity must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    // แสดงผลลัพอาหาร
    private String printFood() {
        String foodText = "";
        if (foodComboBox.getSelectedIndex() == 0) {
            foodText = "food: -\n";
        } else {
            Food food = (Food) foodComboBox.getSelectedItem();
            foodText = "food: " + food.getName() + " - THB " + food.getPrice() + "\n";
        }
        return foodText;
    }
}
