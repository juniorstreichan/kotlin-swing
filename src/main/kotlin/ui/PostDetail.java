package ui;

import javax.swing.*;

public class PostDetail extends JDialog {
    private JPanel rootPanel;
    private JLabel lbTitulo;
    private JLabel lbDescricao;
    private JButton buttonOK;

    public PostDetail(int id) {
        super();

        this.setContentPane(rootPanel);
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

}
