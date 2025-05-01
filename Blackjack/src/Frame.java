import javax.swing.*;
import java.awt.*;

public class Frame {

    public static JLabel lblBalance;

    public static JLabel lblDealersCardCount;

    public static JPanel dealersCardPanel;

    public static JLabel lblFirstHandCount;

    public static JPanel playersFirstHandPanel;

    public static JLabel lblSecondHandCount;

    public static JPanel playersSecondHandPanel;

    public JPanel cntPane() {
        Font countFont = new Font("Roboto", Font.PLAIN, 18);
        JPanel mainPanel = new JPanel(null);

        lblBalance = new JLabel("Balance: " + Game.instance().player.balance + " PLN");
        lblBalance.setForeground(Color.white);
        lblBalance.setFont(countFont);
        lblBalance.setBounds(10, 204, 250, 25);

        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        optionsPanel.setOpaque(false);
        optionsPanel.setBounds(382, 182, 260, 68); // 14, 37

        JTextField tfBetAmount = new JTextField();
        tfBetAmount.setText("10");
        tfBetAmount.setPreferredSize(new Dimension(80, 25));

        JButton btnBet = new JButton("Place bet");

        JButton btnDouble = new JButton(new ImageIcon("resources/double.png"));
        btnDouble.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDouble.setBorder(BorderFactory.createEmptyBorder()); // No border
        btnDouble.setContentAreaFilled(false); // No background
        btnDouble.setVisible(false);

        JButton btnHit = new JButton(new ImageIcon("resources/hit.png"));
        btnHit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnHit.setBorder(BorderFactory.createEmptyBorder()); // No border
        btnHit.setContentAreaFilled(false); // No background
        btnHit.setVisible(false);

        JButton btnStand = new JButton(new ImageIcon("resources/stand.png"));
        btnStand.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnStand.setBorder(BorderFactory.createEmptyBorder()); // No border
        btnStand.setContentAreaFilled(false); // No background
        btnStand.setVisible(false);

        JButton btnSplit = new JButton(new ImageIcon("resources/split.png"));
        btnSplit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSplit.setBorder(BorderFactory.createEmptyBorder()); // No border
        btnSplit.setContentAreaFilled(false); // No background
        btnSplit.setVisible(false);

        JPanel dealersPanel = new JPanel(null);
        dealersPanel.setBackground(new Color(24,93,62,255));
        dealersPanel.setBounds(0, 0, 1010, 180);

        lblDealersCardCount = new JLabel("");
        lblDealersCardCount.setForeground(Color.white);
        lblDealersCardCount.setFont(countFont);
        lblDealersCardCount.setBounds(10, 80, 50, 20);

        dealersCardPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dealersCardPanel.setBackground(new Color(24,93,62,255));
        dealersCardPanel.setBounds(70, 0, 940, 180);

        JPanel playersPanel = new JPanel(null);
        playersPanel.setBackground(new Color(24,93,62,255));
        playersPanel.setBounds(0, 175,1010,468);

        JPanel mainPlayerPanel = new JPanel(null);
        mainPlayerPanel.setBackground(new Color(24,93,62,255));
        mainPlayerPanel.setBounds(0, 75, 1010, 197);

        lblFirstHandCount = new JLabel("");
        lblFirstHandCount.setForeground(Color.white);
        lblFirstHandCount.setFont(countFont);
        lblFirstHandCount.setBounds(10, 88, 50, 20);

        playersFirstHandPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        playersFirstHandPanel.setBackground(new Color(24,93,62,255)); // 24,93,152,255
        playersFirstHandPanel.setBounds(70, 0, 940, 197);

        JPanel secondPlayerPanel = new JPanel(null);
        secondPlayerPanel.setBackground(new Color(24,93,62,255));
        secondPlayerPanel.setBounds(0, 272, 1010, 196);

        lblSecondHandCount = new JLabel("");
        lblSecondHandCount.setForeground(Color.white);
        lblSecondHandCount.setFont(countFont);
        lblSecondHandCount.setBounds(10, 88, 50, 20);

        playersSecondHandPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        playersSecondHandPanel.setBackground(new Color(24,93,62,255));
        playersSecondHandPanel.setBounds(70, 0, 940, 196);

        btnBet.addActionListener(e -> {
            if (tfBetAmount.getText().isEmpty()) return;

            int betAmt = Integer.parseInt(tfBetAmount.getText());
//            tfBetAmount.setText("");

            Game.instance().player.setBetAmount(betAmt);
            Game.instance().player.setBalance(Game.instance().player.balance - betAmt);
            lblBalance.setText("Balance: " +  Game.instance().player.balance + " PLN");

            lblFirstHandCount.setText("0");
            lblSecondHandCount.setText("");
            lblDealersCardCount.setText("0");

            Game.instance().player.mainHand.clear();
            Game.instance().player.secondHand.clear();

            tfBetAmount.setVisible(false);
            btnBet.setVisible(false);

            btnDouble.setVisible(true);
            btnHit.setVisible(true);
            btnStand.setVisible(true);

            dealersCardPanel.removeAll();
            dealersCardPanel.revalidate();
            dealersCardPanel.repaint();

            playersFirstHandPanel.removeAll();
            playersFirstHandPanel.revalidate();
            playersFirstHandPanel.repaint();

            playersSecondHandPanel.removeAll();
            playersSecondHandPanel.revalidate();
            playersSecondHandPanel.repaint();

            Game.instance().startGame();

            if (Game.instance().player.mainHand.get(0).rank == Game.instance().player.mainHand.get(1).rank) {
                btnSplit.setVisible(true);
            }
        });

        btnDouble.addActionListener(e -> {
            btnDouble.setVisible(false);
            btnHit.setVisible(false);
            btnStand.setVisible(false);
            btnSplit.setVisible(false);

            Game.instance().player.setBetAmount(Game.instance().player.betAmount * 2);
            Game.instance().player.drawCard(Game.instance().deck);

            btnStand.doClick();
        });

        btnHit.addActionListener(e -> {
            btnDouble.setVisible(false);
            btnSplit.setVisible(false);

            Game.instance().player.drawCard(Game.instance().deck);
        });

        btnStand.addActionListener(e -> {
            btnDouble.setVisible(false);
            btnSplit.setVisible(false);

            if (Game.instance().player.isSplit) {
                Game.instance().player.isSplit = false;
                return;
            } else {
                btnHit.setVisible(false);
                btnStand.setVisible(false);
            }

            Game.instance().dealer.dealersTurn();

            tfBetAmount.setVisible(true);
            btnBet.setVisible(true);
        });

        btnSplit.addActionListener(e -> {
            int betAmt = Integer.parseInt(tfBetAmount.getText());

            Game.instance().player.setBetAmount(betAmt);
            Game.instance().player.setBalance(Game.instance().player.balance - betAmt);
            lblBalance.setText("Balance: " +  Game.instance().player.balance + " PLN");

            btnSplit.setVisible(false);

            Game.instance().player.splitCards();
        });

        mainPanel.add(lblBalance);

        mainPanel.add(optionsPanel);
        mainPanel.add(dealersPanel);
        mainPanel.add(playersPanel);

        optionsPanel.add(tfBetAmount);
        optionsPanel.add(btnBet);
        optionsPanel.add(btnDouble);
        optionsPanel.add(btnHit);
        optionsPanel.add(btnStand);
        optionsPanel.add(btnSplit);

        dealersPanel.add(lblDealersCardCount);
        dealersPanel.add(dealersCardPanel);

        playersPanel.add(mainPlayerPanel);

        mainPlayerPanel.add(lblFirstHandCount);
        mainPlayerPanel.add(playersFirstHandPanel);

        playersPanel.add(secondPlayerPanel);
        secondPlayerPanel.add(lblSecondHandCount);
        secondPlayerPanel.add(playersSecondHandPanel);

        return mainPanel;
    }
    public Frame(){
        JFrame wndw = new JFrame("Blackjack");
        wndw.setSize(1024, 680);
        wndw.setLocationRelativeTo(null);
        wndw.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        wndw.setResizable(false);
        wndw.setContentPane(cntPane());
        wndw.setVisible(true);
    }
}
