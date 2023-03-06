import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

public class Sniadanie {
    private final ArrayList<MenuOption> menu = new ArrayList<>();
    private final HashSet<MenuOption> selected = new HashSet<>();
    private JFrame frame;

    private JTextField selectedField;
    private JTextField priceField;

    Sniadanie(){
        menu.add(new MenuOption("Gofry", 2.5));
        menu.add(new MenuOption("Jajecznica", 3.0));
        menu.add(new MenuOption("Kawa", 5.2));
        menu.add(new MenuOption("Ciastko", 14.0));

        this.prepareFrame();
    }

    void prepareFrame(){
        this.frame = new JFrame("Śniadanie");

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(450,300);

        this.prepareElements();

        this.frame.setVisible(true);
    }
    void prepareElements(){
        // LEFT PANEL
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        JLabel leftLabel = new JLabel("Menu");
        leftPanel.add(leftLabel);

        for(MenuOption s : this.menu){
            JCheckBox el = new JCheckBox(s.toString());
            el.addActionListener(s);
            leftPanel.add(el);
        }

        JButton acceptButton = new JButton("Akceptuj");
        acceptButton.addActionListener(new AcceptActionListener());
        leftPanel.add(acceptButton);

        // RIGHT PANEL
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));

        JLabel selectedLabel = new JLabel("Moje śniadanie");
        this.selectedField = new JTextField();
        this.selectedField.setEditable(false);

        JLabel priceLabel = new JLabel("Kwota do zapłaty");
        this.priceField = new JTextField();
        this.priceField.setEditable(false);

        rightPanel.add(selectedLabel);
        rightPanel.add(this.selectedField);

        rightPanel.add(priceLabel);
        rightPanel.add(this.priceField);

        // SPLIT
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);

        this.frame.add(splitPane);
    }

    void refreshSelected(){
        StringBuilder newContentBuilder = new StringBuilder();
        double summedPrice = 0;

        for (MenuOption el : this.selected){
            newContentBuilder.append(el.getName());
            newContentBuilder.append(" ");

            summedPrice += el.getPrice();
        }

        String newContent = newContentBuilder.toString().trim();
        newContent = newContent.replace(" ", ", ");

        this.selectedField.setText(newContent);
        this.priceField.setText(String.format("%.2f", summedPrice).replace("," ,"."));
    }

    private class MenuOption implements ActionListener {
        private final String name;
        private final double price;

        MenuOption(String name, double price){
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("%s - %.2f zł", this.name, this.price).replace(",", ".");
        }

        public String getName() {
            return this.name;
        }

        public double getPrice() {
            return this.price;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Sniadanie.this.selected.contains(this))
                Sniadanie.this.selected.remove(this);
            else
                Sniadanie.this.selected.add(this);

            // Sniadanie.this.refreshSelected();
        }
    }

    class AcceptActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Sniadanie.this.refreshSelected();
        }
    }
}
