package view;

import model.*;

import javax.swing.*;
import java.awt.*;
public class ReceiptView extends JFrame {
    public ReceiptView(Sandwich sandwich) {
        setTitle("Receipt");
        setSize(300, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea receiptArea = new JTextArea();
        receiptArea.setFont(new Font("Monospaced", Font.BOLD, 16));
        receiptArea.setEditable(false);

        StringBuilder receiptText = new StringBuilder();
        receiptText.append("===============================\n");
        receiptText.append("       Welcome to Subway!       \n");
        receiptText.append("===============================\n");
        receiptText.append(String.format("Customer: %s\n", sandwich.getCustomerName()));
        receiptText.append("--------------------------------\n");

        receiptText.append(String.format("%-10s %15s\n", "Bread:", sandwich.getBread().getName()));
        receiptText.append(String.format("%-10s %15.2f\n", "", sandwich.getBread().getPrice()));

        receiptText.append(String.format("%-10s %15s\n", "Meat:", sandwich.getMeat().getName()));
        receiptText.append(String.format("%-10s %15.2f\n", "", sandwich.getMeat().getPrice()));

        for (Veggie veggie : sandwich.getVeggies()) {
            receiptText.append(String.format("%-10s %15s\n", "Veggie:", veggie.getName()));
            receiptText.append(String.format("%-10s %15.2f\n", "", veggie.getPrice()));
        }

        for (Sauce sauce : sandwich.getSauces()) {
            receiptText.append(String.format("%-10s %15s\n", "Sauce:", sauce.getName()));
            receiptText.append(String.format("%-10s %15.2f\n", "", sauce.getPrice()));
        }

        receiptText.append("--------------------------------\n");
        receiptText.append(String.format("%-10s %15.2f\n", "Total Price:", sandwich.getPrice()));
        receiptText.append("===============================\n");
        receiptText.append("  Thank you for your order!   \n");
        receiptText.append("===============================\n");

        receiptArea.setText(receiptText.toString());

        add(new JScrollPane(receiptArea));
        setVisible(true);
    }
}