package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;




public class OrderView extends JPanel {

    private JTextField nameInput;
    private JComboBox<String> breadInput;
    private JButton confirmNameButton, back, confirmButton;

    private ArrayList<String> breadOptions = new ArrayList<>();
    private ArrayList<String> meatOptions = new ArrayList<>();
    private ArrayList<String> veggieOptions = new ArrayList<>();
    private ArrayList<String> sauceOptions = new ArrayList<>();

    private ArrayList<JButton> meatButtons = new ArrayList<>();
    private ArrayList<JButton> veggieButtons = new ArrayList<>();
    private ArrayList<JButton> sauceButtons = new ArrayList<>();


    private JLabel nameLabel, meatLabel, veggieChoices, sauceChoices;

    public OrderView(List<String> breadOptions, List<String> meatOptions, List<String> veggieOption, List<String> sauceOptions){
        this.breadOptions.addAll(breadOptions);
        this.meatOptions.addAll(meatOptions);
        this.veggieOptions.addAll(veggieOption);
        this.sauceOptions.addAll(sauceOptions);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(Color.decode("#006400"));


        //Add back button
        back = new JButton("Back");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        add(back, gbc);

    
        //TODO: Fill Name Component with a text input field and a label.

        
        
        JPanel nameComponent = new JPanel();
        nameComponent.setLayout(new BorderLayout());
        nameComponent.add(nameLabel, BorderLayout.NORTH);
        nameComponent.add(nameInput, BorderLayout.CENTER);
        nameComponent.add(confirmNameButton, BorderLayout.SOUTH);
        nameComponent.setBackground(Color.white);
        gbc.gridy = 1;//Experiment with this
        gbc.gridheight = 2;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc. weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
    
        add(nameComponent, gbc);

        //add dropdown for bread type
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel breadLabel  = new JLabel("Choose your Bread");
        breadInput = new JComboBox<String>(breadOptions.toArray(new String[0]));
        breadInput.setBackground(Color.WHITE);
        breadInput.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        breadInput.setAlignmentX(CENTER_ALIGNMENT);
        JPanel breadComponent = new JPanel();
        breadComponent.setLayout(new BorderLayout());
        breadComponent.setBackground(Color.decode("#FFFFE0"));
        breadComponent.add(breadLabel, BorderLayout.NORTH);
        breadComponent.add(breadInput);
        gbc.weightx = 1.0;
        gbc. weighty = 1.0;
        gbc.gridy = 3; 
        add(breadComponent, gbc);



        JLabel veggieLabel = new JLabel("Veggies: ");
        JPanel veggieButtonsPanel = new JPanel();
        veggieButtonsPanel.setLayout(new GridLayout(veggieOptions.size(),1));
        for(String veggie : veggieOptions){
            JButton btn = new JButton(veggie);
            veggieButtons.add(btn);
            veggieButtonsPanel.add(btn);
        }
        JPanel veggieComponent = new JPanel();
        veggieComponent.setLayout(new BorderLayout());
        veggieComponent.add(veggieLabel, BorderLayout.NORTH);
        veggieComponent.add(veggieButtonsPanel, BorderLayout.CENTER);
        gbc.weightx = 0.5;
        gbc.gridwidth = 1;
        gbc.gridy= 16;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(veggieComponent, gbc);

        JLabel sauceLabel = new JLabel("Sauces: ");
        JPanel saucePanel = new JPanel();
        saucePanel.setLayout(new GridLayout(1, sauceOptions.size()));
        for(String sauce : sauceOptions){
            JButton btn = new JButton(sauce);
            sauceButtons.add(btn);
            saucePanel.add(btn);
        }
        JPanel sauceComponent = new JPanel();
        sauceComponent.setLayout(new BorderLayout());
        sauceComponent.add(sauceLabel, BorderLayout.NORTH);
        sauceComponent.add(saucePanel, BorderLayout.CENTER);
        gbc.gridy = 16;
        gbc.gridx = 1;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(sauceComponent, gbc);

        //TODO: ADD JLabel to show which veggies are selected



        //TODO: ADD JLabel to show which sauces are selected.


        gbc.gridheight=1;
        gbc.gridy=27;
        add(veggieChoices, gbc);
        gbc.gridy=28;
        add(sauceChoices, gbc);



        //TODO: ADD Confirm Button
        confirmButton = new JButton("Confirm Order");
        gbc.weighty = 0.0;
        gbc.gridy = 30;
        gbc.gridheight= 2;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(confirmButton, gbc);

    }

    //TODO: Complete the function
    public String getCustomerName(){
        return "";
    }


    public String getBreadName(){
        return (String) breadInput.getSelectedItem();
    }

    public void setNameLabel(String name){
        nameLabel.setText("Customer Name: " + name);
    }

    public void setMeatChoice(String choice){
        meatLabel.setText("Meat: " + choice);
        
    }

    public void setVeggieChoice(String choice){
        veggieChoices.setText("Veggies: " + choice);
    }

    public void setSauceChoice(String choice){
        sauceChoices.setText("Sauces: " + choice);
    }

    public void setMeatActions(ArrayList<ActionListener> a){
        if(meatButtons.size() == 0){
            return;
        }
        for(int i = 0; i < a.size(); i++){

            meatButtons.get(i).addActionListener(a.get(i));
        }
    }

    public void setVeggieActions(ArrayList<ActionListener> a){
        if(veggieButtons.size() == 0){
            return;
        }
        for(int i = 0; i < a.size(); i++){
            veggieButtons.get(i).addActionListener(a.get(i));
        }
    }

    public void setSauceActions(ArrayList<ActionListener> a){
        if(sauceButtons.size() == 0){
            return;
        }
        for(int i = 0; i < a.size(); i++){
            sauceButtons.get(i).addActionListener(a.get(i));
        }
    }

    public void setNameInputAction(ActionListener a){
        confirmNameButton.addActionListener(a);
    }

    public void setBackButtonAction(ActionListener a){
        back.addActionListener(a);
    }

    public void setConfirmButtonAction(ActionListener a){
        confirmButton.addActionListener(a);
    }

}
