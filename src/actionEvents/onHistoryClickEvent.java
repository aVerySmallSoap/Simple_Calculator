package actionEvents;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class onHistoryClickEvent {
    private static ArrayList<String> storedStatements = new ArrayList<>();
    private JPanel pane = new JPanel();

    public void refreshPanel(){
        pane.repaint();
        pane.revalidate();
    }

    public ArrayList<String> getArray(){
        return storedStatements;
    }

    public void getHistory(JTextField text){
        JFrame historyFrame = new JFrame();
        DefaultListModel<String> model = new DefaultListModel<>();

        JScrollPane pan = new JScrollPane(pane);

        historyFrame.setVisible(true);
        historyFrame.setResizable(false);
        historyFrame.add(pan);
        historyFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        historyFrame.setSize(new Dimension(300,300));
        pan.setPreferredSize(new Dimension(300,300));
        pan.setMaximumSize(new Dimension(300,300));
        pane.setLayout(new BorderLayout());
        pan.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        for (int i = 0; i<storedStatements.size();i++) {
            model.addElement(storedStatements.get(i));
        }
        JList<String> list = new JList<>();
        list.setModel(model);
        list.addListSelectionListener(e -> setTextOnParent(text, list.getSelectedValue()));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        list.setPreferredSize(new Dimension(pane.getWidth(), historyFrame.getHeight()));
        list.setFont(new Font("Courier New", Font.PLAIN, 36));
        pane.add(list, BorderLayout.CENTER);
        pane.repaint();
        pane.revalidate();
        historyFrame.pack();
    }

    private void setTextOnParent(JTextField Component, String s){
        Component.setText(s);
    }
}
