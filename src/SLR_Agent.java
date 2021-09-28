
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SLR_Agent extends JFrame {
    private OneShotAgent myAgent;
    private JTextField x_value;

    public SLR_Agent(OneShotAgent a) {
        super(a.getLocalName());
        myAgent = a;

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 2));
        p.add(new JLabel(""));
        x_value = new JTextField(15);
        p.add(x_value);
        getContentPane().add(p, BorderLayout.CENTER);

        JButton addButton = new JButton("Calculate");
        addButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    int y = Integer.parseInt(x_value.getText());
                    myAgent.actionAgent(y);
                    x_value.setText("");
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(SLR_Agent.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } );
            p = new JPanel();
            p.add(addButton);
            getContentPane().add(p, BorderLayout.SOUTH);

            addWindowListener(new    WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    myAgent.doDelete();
                }
            } );

        addWindowListener(new	WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                myAgent.doDelete();
            }
        } );

            //setResizable(false);
        }

        public void showGui() {
            pack();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int centerX = (int)screenSize.getWidth() / 2;
            int centerY = (int)screenSize.getHeight() / 2;
            setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
            super.setVisible(true);
        }
    }

