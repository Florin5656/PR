import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ChatGUI extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String msg = "";
	/**
     * Creates new form ChatGUI
     */
    public ChatGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ChatsGUI:...");
        
        JLabel lblNewLabel = new JLabel("Florin Rosca [TI-173]");
        
        chat = new JTextPane();
        chat.setEditable(false);
      
        textInput = new JTextField();
        textInput.setColumns(10);
        textInput.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 msg = textInput.getText();
      		   	textInput.setText("");
        	}
        });
        
   
        JButton btnNewButton = new JButton("Set");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		   msg = textInput.getText();
        		   textInput.setText("");
        		 // msg = "test";
        		//return msg ;
        	}
        	//return msg ;
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        					.addComponent(textInput, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
        					.addGroup(layout.createSequentialGroup()
        						.addComponent(jLabel1)
        						.addPreferredGap(ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
        						.addComponent(lblNewLabel)
        						.addGap(33))
        					.addGroup(layout.createSequentialGroup()
        						.addComponent(chat, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        						.addContainerGap()))
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
        					.addGap(140))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(lblNewLabel))
        			.addGap(18)
        			.addComponent(chat, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(textInput, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnNewButton)
        			.addContainerGap(21, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);
       
        pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private static javax.swing.JLabel jLabel1;
    private static  JTextPane chat;
    private static JTextField textInput;
    // End of variables declaration

    public static void seterTexte(String s ) { // the setter method to set text of "jTextField1"
        //s = "test";
    	chat.setText(s);
    }
    
    public static String geterTexte() { // the setter method to set text of "jTextField1"        
        //String text = "";
       
       //text =  textField.getText();
        
       // seterTexte( msg );
    	return msg;
    }
    
    public static void setLabel(String s ) { // the setter method to set text of "jTextField1"
        jLabel1.setText(s);
    }
}