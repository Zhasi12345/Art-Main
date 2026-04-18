package ui;
import model.*;
import service.*;
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private ArtworkService service = new ArtworkService();
    private JLabel bottomStatus;

    public GUI() {

        String u = JOptionPane.showInputDialog("Login:");
        String p = JOptionPane.showInputDialog("Password:");

        User user = AuthService.login(u, p);

        if (user == null) {
            JOptionPane.showMessageDialog(null, "Wrong login");
            System.exit(0);
        }

        setTitle("Artwork Inventory Manager");
        setSize(800, 500);
        setLayout(new BorderLayout());


        JLabel header = new JLabel("ARTWORK MANAGER SYSTEM", JLabel.CENTER);
        header.setFont(new Font("Ariel", Font.BOLD, 18));

        JLabel author = new JLabel("by Sydygaalieva Zhasmin", JLabel.CENTER);
        author.setFont(new Font("Arial", Font.PLAIN, 12));

        JPanel top = new JPanel(new GridLayout(2, 1));
        top.add(header);
        top.add(author);


        JTextField id = new JTextField(10);
        JTextField title = new JTextField(10);
        JTextField artist = new JTextField(10);
        JTextField date = new JTextField(10);
        JTextField location = new JTextField(10);

        String[] types = {"Painting", "Sculpture"};
        JComboBox<String> typeBox = new JComboBox<>(types);


        JTextArea output = new JTextArea();
        output.setBackground(Color.WHITE);
        output.setEditable(false);
        JScrollPane scroll = new JScrollPane(output);


        JButton add = new JButton("Add");
        JButton view = new JButton("View");
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");
        JButton exportBtn = new JButton("Export");
        JButton importBtn = new JButton("Import");

        Dimension size = new Dimension(90, 22);

        JButton[] main = {add, view, update, delete};

        for (JButton b : main) {
            b.setPreferredSize(size);
            b.setFont(new Font("Arial", Font.PLAIN, 11));
        }

        exportBtn.setPreferredSize(new Dimension(90, 22));
        importBtn.setPreferredSize(new Dimension(90, 22));

        bottomStatus = new JLabel("Ready", JLabel.CENTER);

        if (user.getRole().equals("USER")) {
            add.setEnabled(false);
            delete.setEnabled(false);
            update.setEnabled(false);
            importBtn.setEnabled(false);
        }

        add.addActionListener(e -> {
            try {
                int parsedId = Integer.parseInt(id.getText());

                Artwork a;

                if (typeBox.getSelectedItem().equals("Painting")) {
                    a = new Painting(parsedId, title.getText(), artist.getText(), date.getText(), location.getText());
                } else {
                    a = new Sculpture(parsedId, title.getText(), artist.getText(), date.getText(), location.getText());
                }

                service.add(a);
                bottomStatus.setText("Added");

            } catch (Exception ex) {
                bottomStatus.setText("Invalid input");
            }
        });

        view.addActionListener(e -> {
            output.setText("");

            for (Artwork a : service.getAll()) {

                String type = (a instanceof Painting) ? "Painting" : "Sculpture";

                output.append(
                        a.getId() + " | " +
                                a.getTitle() + " | " +
                                a.getArtist() + " | " +
                                a.getDate() + " | " +
                                a.getLocation() + " | " +
                                type + "\n"
                );
            }

            bottomStatus.setText("Loaded");
        });
        update.addActionListener(e -> {
            try {
                service.update(
                        Integer.parseInt(id.getText()),
                        title.getText(),
                        artist.getText(),
                        date.getText(),location.getText()
                );
                bottomStatus.setText("Updated");
            } catch (Exception ex) {
                bottomStatus.setText("Error");
            }
        });

        delete.addActionListener(e -> {
            try {
                service.delete(Integer.parseInt(id.getText()));
                bottomStatus.setText("Deleted");
            } catch (Exception ex) {
                bottomStatus.setText("Error");
            }
        });

        exportBtn.addActionListener(e -> {
            service.exportData();
            bottomStatus.setText("Exported");
        });

        importBtn.addActionListener(e -> {
            service.importData();
            bottomStatus.setText("Imported");
        });

        JPanel form = new JPanel(new GridLayout(6, 2, 3, 3));
        form.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        form.add(new JLabel("ID:")); form.add(id);
        form.add(new JLabel("Title:")); form.add(title);
        form.add(new JLabel("Artist:")); form.add(artist);
        form.add(new JLabel("Year:")); form.add(date);
        form.add(new JLabel("Location:")); form.add(location);
        form.add(new JLabel("Type:")); form.add(typeBox);

        JPanel buttons = new JPanel(new GridLayout(4, 1, 5, 5));
        buttons.add(add);
        buttons.add(view);
        buttons.add(update);
        buttons.add(delete);

        JPanel file = new JPanel();
        file.add(exportBtn);
        file.add(importBtn);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(file, BorderLayout.NORTH);
        bottom.add(bottomStatus, BorderLayout.SOUTH);

        add(top, BorderLayout.NORTH);
        add(form, BorderLayout.WEST);
        add(scroll, BorderLayout.CENTER);
        add(buttons, BorderLayout.EAST);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }
}