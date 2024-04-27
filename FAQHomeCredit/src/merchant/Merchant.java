package merchant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;


public class Merchant extends JFrame {
    private JComboBox<String> faqDropdown;
    private String[] faqQuestions = {"How can I become a merchant partner with HomeCredit?",
    		"What are the benefits of partnering with HomeCredit?",
    		"What types of products can customers finance through HomeCredit?",
    		"How long does the financing approval process take for customers?",
    		"What support does HomeCredit provide to its merchant partners?"};
    private String[] faqAnswers = {  		
    	
        "Explore partnership opportunities by contacting our business development team through our website or \n"
        + "directly. We'll guide you through the process and discuss requirements and benefits.",
        
    	"Increase sales and customer base by offering convenient financing options. \n"
    	+ "Offer financing for various products such as electronics, appliances, \n"
    	+ "furniture, gadgets, sporting goods, etc. Cater to diverse customer needs and preferences..",
    	
        "Offer financing for various products such as electronics, appliances, furniture, \n"
        + "gadgets, sporting goods, etc. Cater to diverse customer needs and preferences.",
        
        "Customers receive instant decisions on loan applications, ensuring a seamless shopping experience. \n"
        + "Approval typically takes minutes, allowing them to proceed with their purchases promptly.",
        
        "Benefit from training sessions, marketing materials, and ongoing assistance to integrate \n"
        + "financing solutions smoothly. Access to a secure online portal for tracking applications, \n"
        + "payments, and transaction history in real-time."
    };

    public Merchant() {
        setTitle("FAQ Dropdown");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 134, 764, 316);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 0, 0));
        panel.setLayout(null);
        panel.add(scrollPane);
        
                faqDropdown = new JComboBox<>(faqQuestions);
                scrollPane.setColumnHeaderView(faqDropdown);
                faqDropdown.setFont(new Font("Dialog", Font.BOLD, 15));
                faqDropdown.setModel(new DefaultComboBoxModel(new String[] {"How can I become a merchant partner with HomeCredit?",
                		"What are the benefits of partnering with HomeCredit?",
                		"What types of products can customers finance through HomeCredit?",
                		"How long does the financing approval process take for customers?",
                		"What support does HomeCredit provide to its merchant partners?"}));
                
                JTextArea answerTextArea = new JTextArea();
                answerTextArea.setFont(new Font("Dialog", Font.PLAIN, 17));
                scrollPane.setViewportView(answerTextArea);
                answerTextArea.setEditable(false);
                
                        faqDropdown.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent n) {
                                int selectedIndex = faqDropdown.getSelectedIndex();
                                if (selectedIndex >= 0 && selectedIndex < faqAnswers.length) {
                                    answerTextArea.setText(faqAnswers[selectedIndex]);
                                }
                            }
                        });

        getContentPane().add(panel);
        
        JLabel label = new JLabel("");
        label.setBackground(new Color(128, 0, 0));
        Image img = new ImageIcon(this.getClass().getResource("/FAQimg.png")).getImage();
        label.setIcon(new ImageIcon(img));
        label.setBounds(48, 11, 685, 112);
        panel.add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Merchant faqDropdown = new Merchant();
                faqDropdown.setVisible(true);
            }
        });
    }
}