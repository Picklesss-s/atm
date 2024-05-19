import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.util.Random;
import javax.swing.text.MaskFormatter;

public class atmDraft extends JFrame {
	
	private enum State {
        READY, PIN_ENTRY, WITHDRAWAL, WITHDRAWALN
    }
	private State currentState = State.READY;

    private JPanel contentPane;
    private JTextField txtCard;
    private JPasswordField txtInput;
    private JLabel txtMain, lblAmount,lblReceipt;
    private JPanel panel2;
    private JPanel cardPanel;
    private JButton btnWithReceipt, btnBal,btnWithoutReceipt, btnCancel;
    private List<Integer> cardIds; 
    private List<Integer> cardPins; 
    private List<Integer> cardBalances;
    

    
    public atmDraft() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 709, 558);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        cardIds = new ArrayList<>();
        cardPins = new ArrayList<>();
        cardBalances = new ArrayList<>();
        addCardData();
        setupMainPanel();
        setupCardPanel();
        setupNumberPanel();
        setupSidePanel();
        setupReceiptPanel();
    }

    private void addCardData() {
        cardIds.add(123123123); cardPins.add(1111); cardBalances.add(10000);
        cardIds.add(456456456); cardPins.add(2222); cardBalances.add(1900);
        cardIds.add(789789789); cardPins.add(3333); cardBalances.add(2906);
        cardIds.add(121212122); cardPins.add(4444); cardBalances.add(4000);
    }

    private void setupReceiptPanel() {
        JPanel receiptPanel = new JPanel();
        receiptPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        receiptPanel.setBounds(501, 11, 171, 336);
        contentPane.add(receiptPanel);
        receiptPanel.setLayout(new GridLayout(1, 1));
        
        lblReceipt = new JLabel("<html><div style='text-align: center;'>No transaction yet.</div></html>");
        lblReceipt.setVerticalAlignment(SwingConstants.TOP);
        lblReceipt.setHorizontalAlignment(SwingConstants.CENTER);
        receiptPanel.add(lblReceipt);
    }
    
    private void setupMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        mainPanel.setBounds(44, 11, 443, 336);
        contentPane.add(mainPanel);
        mainPanel.setLayout(null);

        panel2 = new JPanel();
        panel2.setBounds(10, 41, 423, 278);
        mainPanel.add(panel2);
        panel2.setLayout(null);
        panel2.setVisible(false);

        txtInput = new JPasswordField();
        txtInput.setBounds(145, 93, 124, 50);
        panel2.add(txtInput);
        
        btnWithReceipt = new JButton("With Receipt");
        btnWithReceipt.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblAmount.setVisible(true); 
                txtInput.setVisible(true); 
                btnCancel.setVisible(true);
                txtInput.setText("");       
                currentState = State.WITHDRAWAL;
                btnWithReceipt.setVisible(false);
                btnWithoutReceipt.setVisible(false);
                btnBal.setVisible(false);
            }
        });
        
        btnWithReceipt.setBounds(282, 153, 117, 50);
        btnWithReceipt.setVisible(false);
        panel2.add(btnWithReceipt);
        
        btnBal = new JButton("CHECK BALANCE");
        btnBal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                int index = cardIds.indexOf(Integer.parseInt(txtCard.getText()));
                JOptionPane.showMessageDialog(null, "Your current balance is: $" + cardBalances.get(index));
                btnWithReceipt.setVisible(true);
                btnBal.setVisible(true);
            }
        });
        
        btnBal.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnBal.setBounds(282, 93, 117, 50);
        btnBal.setVisible(false);
        panel2.add(btnBal);
        
        lblAmount = new JLabel("Enter Amount");
        lblAmount.setBounds(171, 68, 82, 14);
        lblAmount.setVisible(false);
        panel2.add(lblAmount);       
        
        btnWithoutReceipt = new JButton("Without Receipt");
        btnWithoutReceipt.setVisible(false);
        btnWithoutReceipt.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		currentState = State.WITHDRAWALN;
        		lblAmount.setVisible(true); 
                txtInput.setVisible(true); 
                btnCancel.setVisible(true);
                txtInput.setText("");       
                btnWithReceipt.setVisible(false);
                btnWithoutReceipt.setVisible(false);
                btnBal.setVisible(false);
        	}
        });
        
        btnWithoutReceipt.setBounds(282, 214, 117, 53);
        panel2.add(btnWithoutReceipt);
        
        btnCancel = new JButton("Cancel");
        btnCancel.setVisible(false);
        btnCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnBal.setVisible(true);
        		btnWithReceipt.setVisible(true);
        		btnWithoutReceipt.setVisible(true);
        		txtInput.setVisible(false);
        		lblAmount.setVisible(false);
        		btnCancel.setVisible(false);
        	}
        });
        btnCancel.setBounds(10, 244, 89, 23);
        panel2.add(btnCancel);
                
        txtMain = new JLabel("PLEASE ENTER YOUR CARD ID NUMBER");
        txtMain.setBounds(10, 11, 300, 19);
        mainPanel.add(txtMain);
        txtMain.setFont(new Font("Tahoma", Font.BOLD, 10));
    }

    private void setupNumberPanel() {
        JPanel numPanel = new JPanel();
        numPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        numPanel.setBounds(70, 377, 189, 113);
        contentPane.add(numPanel);
        numPanel.setLayout(new GridLayout(4, 3, 0, 0));

        ActionListener numListener = e -> {
            String number = e.getActionCommand();
            if (!number.isEmpty()) {
                txtInput.setText(txtInput.getText() + number);
            }
        };

        String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "", "0", ""};
        for (String num : nums) {
            JButton btn = new JButton(num);
            if (!num.isEmpty()) {
                btn.addActionListener(numListener);
            } else {
                btn.setEnabled(false);
            }
            numPanel.add(btn);
        }
    }

    private void setupCardPanel() {
        cardPanel = new JPanel();
        cardPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        cardPanel.setBounds(434, 361, 238, 147);
        contentPane.add(cardPanel);
        cardPanel.setLayout(null);

        

        txtCard = new JTextField();
        txtCard.setBounds(19, 55, 206, 26);
        cardPanel.add(txtCard);

        JLabel lblCardId = new JLabel("CARD ID NUMBER");
        lblCardId.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCardId.setBounds(70, 36, 110, 14);
        cardPanel.add(lblCardId);

        JButton btnConfirm = new JButton("CONFIRM");
        btnConfirm.addActionListener(e -> {
            try {
                int idNum = Integer.parseInt(txtCard.getText());
                int index = cardIds.indexOf(idNum);
                if (index != -1) {
                    currentState = State.PIN_ENTRY;
                    txtMain.setText("ENTER PIN");
                    txtInput.setVisible(true);
                    panel2.setVisible(true);
                    cardPanel.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Card Invalid");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number");
            }
        });
        btnConfirm.setBounds(70, 86, 89, 23);
        cardPanel.add(btnConfirm);
    }
   
    @SuppressWarnings("deprecation")
	private void setupSidePanel() {
        JPanel sidePanel = new JPanel();
        sidePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        sidePanel.setBounds(267, 377, 128, 113);
        contentPane.add(sidePanel);
        sidePanel.setLayout(new GridLayout(4, 1, 0, 0));

        JButton btnCorrection = new JButton("CORRECTION");
        btnCorrection.addActionListener(e -> txtInput.setText(txtInput.getText().substring(0, txtInput.getText().length() - 1)));
        sidePanel.add(btnCorrection);

        JButton btnC = new JButton("CLEAR");
        btnC.addActionListener(e -> txtInput.setText(""));
        sidePanel.add(btnC);

        JButton btnEject = new JButton("EJECT");
        btnEject.addActionListener(e -> {
            txtCard.setEditable(true);
            txtCard.setText("");
            txtMain.setText("PLEASE ENTER YOUR CARD ID NUMBER");
            txtInput.setText("");
            btnWithReceipt.setVisible(false);
            btnBal.setVisible(false);
            panel2.setVisible(false);
            cardPanel.setVisible(true);
            currentState = State.READY;
            lblAmount.setVisible(false);
        });
        sidePanel.add(btnEject);    
        
        JButton btnEnter = new JButton("ENTER");
        btnEnter.addActionListener(e -> {
        	Random rand = new Random();
        	int r = rand.nextInt(1000);
            int index = cardIds.indexOf(Integer.parseInt(txtCard.getText()));
            
            switch (currentState) {
                case PIN_ENTRY:
                	
                	txtInput.setEchoChar((char)0);
                	if (index != -1 && Integer.parseInt(txtInput.getText()) == cardPins.get(index)) {
                        txtMain.setText("WELCOME, USER " + txtCard.getText());
                        currentState = State.READY;
                        panel2.setVisible(true);
                        txtInput.setText("");
                        txtInput.setVisible(false);
                        btnBal.setVisible(true);
                        btnWithReceipt.setVisible(true);
                		btnWithoutReceipt.setVisible(true);
                      
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid PIN");
                        txtInput.setText("");
                    }
	                    
                    break;
                case WITHDRAWAL:
                	
               
                    try {
                        int amount = Integer.parseInt(txtInput.getText());
                        if (amount <= cardBalances.get(index)) {
                            cardBalances.set(index, cardBalances.get(index) - amount);
                            JOptionPane.showMessageDialog(null, "Withdrawal successful!\nNew balance: $" + cardBalances.get(index));
                            lblReceipt.setText("<html>Card Number: "+ cardIds.get(index) + "<br>Transaction no. " + r +"<br>Withdrawal: $" 
                            + amount + "<br>New Balance: $" + cardBalances.get(index) + "<br><br></html>");

                            txtInput.setText("");
                            txtInput.setVisible(false);
                            lblAmount.setVisible(false);
                            btnWithReceipt.setVisible(true);
                            btnWithoutReceipt.setVisible(true);
                            btnBal.setVisible(true);
                            currentState = State.READY;
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient funds! Please enter a different amount or cancel.");
                            txtInput.setText("");
                            txtInput.requestFocus();
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid amount entered. Please enter a numeric value.");
                        txtInput.setText("");
                    }
                    break;
                case WITHDRAWALN:
                	try {
                        int amount = Integer.parseInt(txtInput.getText());
                        if (amount <= cardBalances.get(index)) {
                            cardBalances.set(index, cardBalances.get(index) - amount);
                            JOptionPane.showMessageDialog(null, "Withdrawal successful!\nNew balance: $" + cardBalances.get(index));
                            lblReceipt.setText("<html>No transactions yet or"+ "<br>No receipt option is chosen</html>");
                            txtInput.setText("");
                            txtInput.setVisible(false);
                            lblAmount.setVisible(false);
                            btnWithReceipt.setVisible(true);
                            btnWithoutReceipt.setVisible(true);
                            btnBal.setVisible(true);
                            currentState = State.READY;
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient funds! Please enter a different amount or cancel.");
                            txtInput.setText("");
                            txtInput.requestFocus();
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid amount entered. Please enter a numeric value.");
                        txtInput.setText("");
                    }
                	break;
                default:
                    break;
            }
        });
        
        btnEnter.setFont(new Font("Tahoma", Font.BOLD, 13));
        sidePanel.add(btnEnter);
        
        JPanel receiptPanel = new JPanel();
        receiptPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        receiptPanel.setBounds(100, 11, 171, 100);
        contentPane.add(receiptPanel);
        receiptPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblR = new JLabel("Reciept");
        lblR.setFont(new Font("Tahoma", Font.PLAIN, 12));
        receiptPanel.add(lblR);
        
        JLabel lblReceipt = new JLabel("");
        lblReceipt.setHorizontalAlignment(SwingConstants.LEFT);
        receiptPanel.add(lblReceipt);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new atmDraft().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}