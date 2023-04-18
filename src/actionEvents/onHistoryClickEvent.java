package actionEvents;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@SuppressWarnings("FieldMayBeFinal")
public class onHistoryClickEvent {
    private static ArrayList<String> storedStatements = new ArrayList<>();
    private JPanel pane = new JPanel();
    private JList<String> list;
    private JScrollPane pan;
    private JFrame historyFrame = new JFrame();


    public ArrayList<String> getArray(){
        return storedStatements;
    }

    public void getHistory(JTextField text){
        DefaultListModel<String> model = new DefaultListModel<>();
        pan = new JScrollPane(pane);

        historyFrame.setVisible(true);
        historyFrame.setResizable(false);
        historyFrame.add(pan);
        historyFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        historyFrame.setSize(new Dimension(300,300));
        pan.setPreferredSize(new Dimension(300,300));
        pane.setLayout(new BorderLayout());
        pan.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pan.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        for (String storedStatement : storedStatements) {
            model.addElement(storedStatement);
        }
        list = new JList<>();
        list.setModel(model);
        list.addListSelectionListener(e -> setTextOnParent(text, list.getSelectedValue()));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        list.setPreferredSize(new Dimension(pane.getWidth(), historyFrame.getHeight()));
        list.setFont(new Font("Courier New", Font.PLAIN, 36));
        pane.add(list, BorderLayout.CENTER);
    }

    public void refreshPanel(){
        if(list != null){
            pane.repaint();
            pane.revalidate();
            list.repaint();
            list.revalidate();
            pan.repaint();
            pan.revalidate();
        }
    }

    private void setTextOnParent(JTextField Component, String s){
        Component.setText(s);
    }
}
