package ui;

import business.PostBusiness;
import entity.PostEntity;

import javax.swing.*;

public class PostDetail extends JDialog {
    private JPanel rootPanel;
    private JLabel lbTitulo;
    private JLabel lbDescricao;

    private PostBusiness business = new PostBusiness();

    public PostDetail(int id) {
        super();
        loadPost(id);
        setModal(true);
        this.setContentPane(rootPanel);
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    private void loadPost(int id) {
        PostEntity entity = business.getSinglePosts(id);
        lbTitulo.setText(entity.getTitle());
        lbDescricao.setText("<html>"+entity.getBody()+"</html>");
    }

}
