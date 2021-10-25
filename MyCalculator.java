import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyCalculator extends JFrame implements ActionListener {
    JTextField txtNum1,txtNum2,txtResult;
    JLabel lblHeading,lblNum1,lblNum2,lblOperation,lblResult;
    JComboBox<String> comboBox;
    JButton btn_Calculate;
    MyCalculator(){
        this.setLayout(new GridLayout(5,2,10,10));
        lblHeading=new JLabel("My Calculator");
        lblNum1=new JLabel("Enter First Number:");
        lblNum2=new JLabel("Enter Second Number:");
        lblResult=new JLabel("Result:");
        lblOperation=new JLabel("Operation");
        txtNum1=new JTextField(12);
        txtNum2=new JTextField(12);
        txtResult=new JTextField(12);
        btn_Calculate=new JButton("Calculate");
        String[] operation={"Addition","Subtraction","Multiplication","Division"};
        comboBox=new JComboBox<>(operation);

        GridBagLayout lay_out = new GridBagLayout();
        Container container = getContentPane();
        container.setLayout(lay_out);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 100, 5, 100);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth=2;
        container.add(lblHeading, gbc);
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth=1;
        container.add(lblNum1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth=1;
        container.add(txtNum1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth=1;
        container.add(lblNum2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth=1;
        container.add(txtNum2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth=1;
        container.add(lblOperation, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth=1;
        container.add(comboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth=1;
        container.add(lblResult, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth=1;
        container.add(txtResult, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth=1;
        gbc.insets = new Insets(5, 5, 5, 50);
        container.add(btn_Calculate, gbc);
        pack();
        setVisible(true);
        btn_Calculate.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        float num1,num2,result=0.f;
        int op;
        if(txtNum1.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Enter First Number");
        }
        else if(txtNum2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Enter second Number");
        }
        else {
            num1 = Float.parseFloat(txtNum1.getText());
            num2 = Float.parseFloat(txtNum2.getText());
            op = comboBox.getSelectedIndex();
            switch (op) {
                case 0:
                    result = num1 + num2;
                    break;
                case 1:
                    result = num1 - num2;
                    break;
                case 2:
                    result = num1 * num2;
                    break;
                case 3:
                    result = num1 / num2;
                    break;
            }
            txtResult.setText("" + result);
        }
    }

    public static void main(String[] args) {
        new MyCalculator();
    }
}
