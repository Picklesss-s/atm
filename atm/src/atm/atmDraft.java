package atm;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.util.Random;
import java.awt.Component;
import java.awt.Panel;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.Canvas;
import java.awt.BorderLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Label;
import java.awt.SystemColor;

public class atmDraft extends JFrame {

    private enum State {
        READY, PIN_ENTRY, WITHDRAWAL, WITHDRAWALN
    }

    private State currentState = State.READY;
    private JPanel contentPane;
    private JTextField txtCard;
    private JPasswordField txtInput;
    private JLabel txtMain, lblAmount, lblReceipt;
    private JPanel panel2;
    private JPanel cardPanel;
    private JButton btnWithReceipt, btnBal, btnWithoutReceipt, btnCancel;
    private List<Account> accounts;

    public atmDraft() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 725, 610);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(60, 43, 66));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        accounts = new ArrayList<>();
        addCardData();
        setupMainPanel();
        setupCardPanel();
        setupNumberPanel();
        setupSidePanel();
        setupReceiptPanel();
    }

    private void addCardData() {
        accounts.add(new Account(123123123, 1111, 10000));
        accounts.add(new Account(456456456, 2222, 1900));
        accounts.add(new Account(789789789, 3333, 2906));
        accounts.add(new Account(121212122, 4444, 4000));
    }

    private void setupReceiptPanel() {
        JPanel receiptPanel = new JPanel();
        receiptPanel.setBackground(new Color(208, 206, 194));
        receiptPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        receiptPanel.setBounds(497, 11, 171, 336);
        contentPane.add(receiptPanel);
        receiptPanel.setLayout(new GridLayout(1, 1));
        
                lblReceipt = new JLabel("<html><div style='text-align: center;'>No transaction yet.</div></html>");
                receiptPanel.add(lblReceipt);
                lblReceipt.setVerticalAlignment(SwingConstants.TOP);
                lblReceipt.setHorizontalAlignment(SwingConstants.CENTER);
        
        Panel panel_1 = new Panel();
        panel_1.setBackground(new Color(208, 206, 194));
        panel_1.setBounds(497, 353, 171, 60);
        contentPane.add(panel_1);
        
        JButton btnNewButton_2_1 = new JButton("");
        btnNewButton_2_1.setBackground(Color.DARK_GRAY);
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
        			.addGap(25)
        			.addComponent(btnNewButton_2_1, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        			.addGap(24))
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
        			.addContainerGap(28, Short.MAX_VALUE)
        			.addComponent(btnNewButton_2_1)
        			.addGap(23))
        );
        panel_1.setLayout(gl_panel_1);
        
        Label label_1 = new Label("Insert Card Here");
        label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
        label_1.setBackground(new Color(208, 206, 194));
        label_1.setAlignment(Label.CENTER);
        label_1.setBounds(545, 429, 74, 18);
        contentPane.add(label_1);
        
        Panel panel_1_1 = new Panel();
        panel_1_1.setBackground(new Color(208, 206, 194));
        panel_1_1.setBounds(497, 429, 171, 67);
        contentPane.add(panel_1_1);
        
        JButton btnNewButton_2_1_1 = new JButton("");
        btnNewButton_2_1_1.setBackground(Color.DARK_GRAY);
        GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
        gl_panel_1_1.setHorizontalGroup(
        	gl_panel_1_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1_1.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(btnNewButton_2_1_1, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_panel_1_1.setVerticalGroup(
        	gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_1_1.createSequentialGroup()
        			.addContainerGap(45, Short.MAX_VALUE)
        			.addComponent(btnNewButton_2_1_1)
        			.addGap(22))
        );
        panel_1_1.setLayout(gl_panel_1_1);
        
        Panel panel_1_2 = new Panel();
        panel_1_2.setBackground(new Color(208, 206, 194));
        panel_1_2.setBounds(44, 353, 443, 60);
        contentPane.add(panel_1_2);
        
        JButton btnNewButton_2_1_2 = new JButton("");
        btnNewButton_2_1_2.setBackground(Color.DARK_GRAY);
        GroupLayout gl_panel_1_2 = new GroupLayout(panel_1_2);
        gl_panel_1_2.setHorizontalGroup(
        	gl_panel_1_2.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_panel_1_2.createSequentialGroup()
        			.addContainerGap(52, Short.MAX_VALUE)
        			.addComponent(btnNewButton_2_1_2, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
        			.addGap(44))
        );
        gl_panel_1_2.setVerticalGroup(
        	gl_panel_1_2.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_1_2.createSequentialGroup()
        			.addContainerGap(21, Short.MAX_VALUE)
        			.addComponent(btnNewButton_2_1_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        			.addGap(19))
        );
        panel_1_2.setLayout(gl_panel_1_2);
    }

    private void setupMainPanel() {
        cardPanel = new JPanel();
        cardPanel.setBounds(314, 429, 173, 113);
        contentPane.add(cardPanel);
        cardPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        cardPanel.setLayout(null);
        
        
        txtCard = new JTextField();
        txtCard.setBounds(10, 36, 155, 26);
        cardPanel.add(txtCard);
        
        JLabel lblCardId = new JLabel("CARD ID NUMBER");
        lblCardId.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardId.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCardId.setBounds(40, 11, 96, 14);
        cardPanel.add(lblCardId);
        
        JButton btnConfirm = new JButton("CONFIRM");
        btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 8));
        

        btnConfirm.addActionListener(e -> {
            try {
                int cardId = Integer.parseInt(txtCard.getText()); // Move this line inside the ActionListener
                Account account = findAccountByCardId(cardId);
               
                if (account != null) {
                    currentState = State.PIN_ENTRY;
                    txtMain.setText("ENTER PIN");
                    txtInput.setVisible(true);
                    panel2.setVisible(true);
                    txtInput.setEchoChar((char) '*');
                   
                    
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Card Invalid");
                }
             
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number");
               
            }
           
        });
        btnConfirm.setBounds(46, 73, 79, 23);
        cardPanel.add(btnConfirm);
        
        Label label_1_1 = new Label("Cash");
        label_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
        label_1_1.setBackground(new Color(208, 206, 194));
        label_1_1.setAlignment(Label.CENTER);
        label_1_1.setBounds(218, 353, 93, 13);
        contentPane.add(label_1_1);
        
        Label label_1 = new Label("Receipt");
        label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 8));
        label_1.setBackground(new Color(208, 206, 194));
        label_1.setAlignment(Label.CENTER);
        label_1.setBounds(564, 353, 42, 18);
        contentPane.add(label_1);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(208, 206, 194));
        mainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        mainPanel.setBounds(44, 11, 443, 336);
        contentPane.add(mainPanel);
        mainPanel.setLayout(null);

        panel2 = new JPanel();
        panel2.setBackground(new Color(218, 238, 225));
        panel2.setBounds(10, 41, 423, 278);
        mainPanel.add(panel2);
        panel2.setLayout(null);
        panel2.setVisible(false);

        txtInput = new JPasswordField();
        txtInput.setHorizontalAlignment(SwingConstants.CENTER);
        txtInput.setBounds(145, 126, 117, 36);
        panel2.add(txtInput);

        btnWithReceipt = new JButton("WITH RECEIPT");
        btnWithReceipt.setFont(new Font("Tahoma", Font.PLAIN, 10));
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

        btnWithReceipt.setBounds(145, 119, 117, 50);
        btnWithReceipt.setVisible(false);
        panel2.add(btnWithReceipt);

        btnBal = new JButton("CHECK BALANCE");
        btnBal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int cardId = Integer.parseInt(txtCard.getText());
                Account account = findAccountByCardId(cardId);
                if (account != null) {
                    JOptionPane.showMessageDialog(null, "Your current balance is: $" + account.getBalance());
                    btnWithReceipt.setVisible(true);
                    btnBal.setVisible(true);
                }
            }
        });

        btnBal.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnBal.setBounds(145, 52, 117, 50);
        btnBal.setVisible(false);
        panel2.add(btnBal);

        lblAmount = new JLabel("Enter Amount");
        lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
        lblAmount.setBounds(157, 101, 91, 14);
        lblAmount.setVisible(false);
        panel2.add(lblAmount);

        btnWithoutReceipt = new JButton("WITHOUT RECEIPT");
        btnWithoutReceipt.setFont(new Font("Tahoma", Font.PLAIN, 8));
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

        btnWithoutReceipt.setBounds(145, 187, 117, 53);
        panel2.add(btnWithoutReceipt);

        btnCancel = new JButton("CANCEL");
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
        numPanel.setBackground(new Color(208, 206, 194));
        numPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        numPanel.setBounds(44, 429, 135, 113);
        contentPane.add(numPanel);
        numPanel.setLayout(new GridLayout(4, 3, 3, 3));

        ActionListener numListener = e -> {
            String number = e.getActionCommand();
            if (!number.isEmpty()) {
                txtInput.setText(txtInput.getText() + number);
            }
        };

        String[] nums = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "", "0", "" };
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
    }

    private Account findAccountByCardId(int cardId) {
        for (Account account : accounts) {
            if (account.getCardId() == cardId) {
                return account;
            }
        }
        return null;
    }

    @SuppressWarnings("deprecation")
	private void setupSidePanel() {
        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(new Color(208, 206, 194));
        sidePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        sidePanel.setBounds(189, 429, 115, 113);
        contentPane.add(sidePanel);
        sidePanel.setLayout(new GridLayout(4, 1, 3, 3));

        JButton btnCorrection = new JButton("CORRECTION");
        btnCorrection.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnCorrection.addActionListener(e -> txtInput.setText(txtInput.getText().substring(0, txtInput.getText().length() - 1)));
        sidePanel.add(btnCorrection);

        JButton btnC = new JButton("CANCEL");
        btnC.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnC.addActionListener(e -> txtInput.setText(""));
        sidePanel.add(btnC);

        JButton btnEject = new JButton("EJECT");
        btnEject.addActionListener(e -> {
            txtCard.setEditable(true);
            txtCard.setText("");
            txtInput.setEchoChar((char) '*');
            txtMain.setText("PLEASE ENTER YOUR CARD ID NUMBER");
            lblReceipt.setText("<html><div style='text-align: center;'>No transaction yet.</div></html>");
            txtInput.setText("");
            btnWithReceipt.setVisible(false);
            btnWithoutReceipt.setVisible(false);
            btnBal.setVisible(false);
            panel2.setVisible(false);
            currentState = State.READY;
            lblAmount.setVisible(false);
        });
        sidePanel.add(btnEject);

        JButton btnEnter = new JButton("ENTER");
        btnEnter.addActionListener(e -> {
            Random rand = new Random();
            int r = rand.nextInt(1000);
            int cardId = Integer.parseInt(txtCard.getText());
            Account account = findAccountByCardId(cardId);

            switch (currentState) {
                case PIN_ENTRY:
                	try {
                		txtInput.setEchoChar((char) '*');
                    if (account != null && account.validatePin(Integer.parseInt(txtInput.getText()))) {
                        txtMain.setText("WELCOME, USER " + txtCard.getText());
                        currentState = State.READY;
                        panel2.setVisible(true);
                        txtInput.setText("");
                        txtInput.setVisible(false);
                        btnBal.setVisible(true);
                        btnWithReceipt.setVisible(true);
                        btnWithoutReceipt.setVisible(true);
                        txtInput.setEchoChar((char) 0);
                        
                    } else {
                    	
                        JOptionPane.showMessageDialog(null, "Invalid PIN");
                        txtInput.setText("");
                    	
                    }}
                	 catch (NumberFormatException ex){
                		 JOptionPane.showMessageDialog(null, "Enter PIN first.");
                		 txtInput.setEchoChar((char)'*');
                	}
                    break;
                case WITHDRAWAL:
                    try {
                        int amount = Integer.parseInt(txtInput.getText());
                        if (account.withdraw(amount)) {
                            JOptionPane.showMessageDialog(null, "Withdrawal successful!\nNew balance: $" + account.getBalance());
                            lblReceipt.setText("<html>Card Number: " + account.getCardId() + "<br>Transaction no. " + r + "<br>Withdrawal: $" 
                            + amount + "<br>New Balance: $" + account.getBalance() + "<br><br></html>");
                            txtInput.setText("");
                            txtInput.setVisible(false);
                            lblAmount.setVisible(false);
                            btnWithReceipt.setVisible(true);
                            btnWithoutReceipt.setVisible(true);
                            btnCancel.setVisible(false);
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
                        if (account.withdraw(amount)) {
                            JOptionPane.showMessageDialog(null, "Withdrawal successful!\nNew balance: $" + account.getBalance());
                            lblReceipt.setText("<html>No transactions yet or" + "<br>No receipt option is chosen</html>");
                            txtInput.setText("");
                            txtInput.setVisible(false);
                            lblAmount.setVisible(false);
                            btnWithReceipt.setVisible(true);
                            btnWithoutReceipt.setVisible(true);
                            btnCancel.setVisible(false);
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
