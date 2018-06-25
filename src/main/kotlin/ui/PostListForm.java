package ui;

import business.PostBusiness;
import entity.PostEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PostListForm extends JFrame implements ListSelectionListener {
    private JTable tbPost;
    private JPanel pnRoot;
    private PostBusiness business = new PostBusiness();

    public PostListForm() {
        super();

        this.getAllPosts();

        this.setContentPane(pnRoot);
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setEvents();

    }

    private void setEvents() {
        tbPost.getSelectionModel().addListSelectionListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int id = 0;
        if (e.getValueIsAdjusting()){
            id = Integer.parseInt(tbPost.getValueAt(tbPost.getSelectedRow(),0).toString());
            new PostDetail(id);

        }

    }

    private void getAllPosts() {
        List<PostEntity> lst = business.getAllPosts();
        String[] columNames = {"id", "titulo"};
        DefaultTableModel model = new DefaultTableModel(
                new Object[0][0], columNames
        );

        for (PostEntity post : lst) {
            Object[] obj = new Object[2];
            obj[0] = post.getId();
            obj[1] = post.getTitle();
            model.addRow(obj);
        }

        tbPost.setModel(model);

    }


}
