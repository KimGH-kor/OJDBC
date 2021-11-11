package window;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class P1 extends JFrame {

   private JPanel contentPane;
   private JTextField textField;
   private JTextField textField_1;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               P1 frame = new P1();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public P1() {
      setTitle("로그인");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel label = new JLabel("아이디");
      label.setFont(label.getFont().deriveFont(label.getFont().getStyle() | Font.BOLD));
      label.setBounds(116, 112, 57, 15);
      contentPane.add(label);
      
      JLabel lblNewLabel = new JLabel("비밀번호");
      lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.BOLD));
      lblNewLabel.setBounds(116, 137, 57, 15);
      contentPane.add(lblNewLabel);
      
      textField = new JTextField();
      textField.setBounds(206, 109, 116, 21);
      contentPane.add(textField);
      textField.setColumns(10);
      
      textField_1 = new JTextField();
      textField_1.setBounds(206, 134, 116, 21);
      contentPane.add(textField_1);
      textField_1.setColumns(10);
      
      JButton btnNewButton = new JButton("로그인");
      btnNewButton.setFont(btnNewButton.getFont().deriveFont(btnNewButton.getFont().getStyle() | Font.BOLD));
      btnNewButton.setBounds(116, 188, 97, 23);
      contentPane.add(btnNewButton);
      
      JButton btnNewButton_1 = new JButton("회원가입");
      btnNewButton_1.setFont(btnNewButton_1.getFont().deriveFont(btnNewButton_1.getFont().getStyle() | Font.BOLD));
      btnNewButton_1.setBounds(225, 188, 97, 23);
      contentPane.add(btnNewButton_1);
      
      JButton btnNewButton_2 = new JButton("ID/비밀번호 찾기");
      btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 11));
      btnNewButton_2.setBounds(116, 221, 206, 23);
      contentPane.add(btnNewButton_2);
      
      JLabel lbImage = new JLabel("");
      lbImage.setBounds(12, 10, 410, 67);
      contentPane.add(lbImage);
      
      Image im = Toolkit.getDefaultToolkit().getImage("KCE.jpg");
      im = im.getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_SMOOTH);
      ImageIcon img = new ImageIcon(im);
      lbImage.setIcon(img);//버튼에 넣으면 버튼 이미지로 간다.
            
   }
}