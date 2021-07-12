package viewer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;

public class SQLiteViewer extends JFrame {

    private static String query;
    private static String fileName;
    private static JComboBox<java.io.Serializable> jComboBox;
    private static JTextArea jTextArea;
    private static JTable table;
    private static DefaultTableModel model;
    private static JButton executeButton;



    public SQLiteViewer() {
        super("SQLite Viewer");


        JPanel jPanel1 = new JPanel();
        jPanel1.setSize(1000,120);
        jPanel1.setBackground(Color.GRAY);
        jPanel1.setLayout(null);

        JTextField textField = new JTextField();
        textField.setName("FileNameTextField");
        textField.setBounds(50,50,800,20);
        textField.setVisible(true);
        jPanel1.add(textField);

        JButton openButton = new JButton("Open");
        openButton.setName("OpenFileButton");
        openButton.addActionListener(e -> {
            jTextArea.setText("");
            query = "";
            fileName = textField.getText();
            File file = new File("\\SQLite Viewer\\" + fileName);
            if (!file.exists()) {
                JOptionPane.showMessageDialog(new Frame(), "File doesn't exist!");
            } else  {
                model = (DefaultTableModel) table.getModel();
                model.setColumnCount(0);
                model.getDataVector().removeAllElements();
                jComboBox.removeAllItems();
                SqlConnection.connect();
                executeButton.setEnabled(true);
                jTextArea.setEnabled(true);
            }
        });
        openButton.setBounds(865, 50,100,20);

        jComboBox = new JComboBox<>();
        jComboBox.setName("TablesComboBox");
        jComboBox.setBounds(50,80,200,20);
        jComboBox.addItemListener(e -> {
            jTextArea.setText("SELECT * FROM " + jComboBox.getSelectedItem() + ";");
            executeButton.setEnabled(true);
            jTextArea.setEnabled(true);
        });

        jPanel1.add(openButton);

        JPanel jPanel2 = new JPanel();
        jPanel2.setBounds(0,120,1000,480);
        jPanel2.setBackground(Color.GRAY);
        jPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));

        jTextArea = new JTextArea(5,70);
        jTextArea.setName("QueryTextArea");
        jTextArea.setEnabled(false);
        jPanel1.add(jComboBox);
        jPanel2.add(jTextArea);

        executeButton = new JButton("Execute");
        executeButton.setName("ExecuteQueryButton");
        executeButton.setEnabled(false);
        executeButton.addActionListener(e -> {
            query = jTextArea.getText();
            if(query.equalsIgnoreCase("SELECT * FROM " + jComboBox.getSelectedItem() + ";")) {
                model = (DefaultTableModel) table.getModel();
                model.setColumnCount(0);
                model.getDataVector().removeAllElements();
                revalidate();
                DataService.getData();
                executeButton.setEnabled(false);
                jTextArea.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(new Frame("SQL error message"), "SQL error message");
            }
        });
        jPanel2.add(executeButton);

        table = new JTable();
        table.setName("Table");
        table.setPreferredScrollableViewportSize(new Dimension(963, 335));

        JScrollPane sp = new JScrollPane(table);

        JPanel jPanel3 = new JPanel();
        jPanel3.setBounds(5,210,975,345);
        jPanel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPanel3.setBackground(Color.WHITE);
        jPanel3.add(sp);

        add(jPanel3);
        add(jPanel2);
        add(jPanel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1000,600);
        setLocationRelativeTo(null);
        setName("SQLite Viewer");
        setResizable(false);
        setVisible(true);

    }

    public static String getFileName() {
        return fileName;
    }

    public static JComboBox<java.io.Serializable> getjComboBox() {
        return jComboBox;
    }

    public static String getQuery() {
        return query;
    }

    public static DefaultTableModel getModel() {
        return model;
    }

}
