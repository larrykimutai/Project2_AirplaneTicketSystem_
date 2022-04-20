import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static boolean test = true;
    public static int NumSeatsEconomy = 20;

    public static void main(String[] args) {
        ArrayList<Ticket> Customers = new ArrayList<>();
        int cntr = 0;
        do {
            Customers.add(new Ticket());
            ReserveTicket(Customers.get(cntr));
            cntr++;
        } while (test);

        Customers.remove(Customers.size() - 1);
        for (Ticket customer : Customers) {
            printTicket(customer);
        }


    }

    public static void printTicket(Ticket customer) {
        System.out.println(customer.toString());
    }


    public static void ReserveTicket(Ticket customer) {
        UIManager.put("OptionPane.yesButtonText", "Reserve Ticket");
        UIManager.put("OptionPane.noButtonText", "Return Ticket");
        int in = JOptionPane.showConfirmDialog(null, "Buy or return ticket");
        if (in == JOptionPane.CANCEL_OPTION) System.exit(0);
        else if (in == JOptionPane.YES_OPTION) {

            JTextField Fname = new JTextField(5);
            new TextPrompt("First Name", Fname);
            JTextField Lname = new JTextField(5);
            new TextPrompt("Last Name", Lname);
            JTextField SrcCity = new JTextField(5);
            new TextPrompt("From", SrcCity);
            JTextField DstCity = new JTextField(5);
            new TextPrompt("To", DstCity);


            String[] flights = {"From", "Washington DC", "Greensboro"};
            String[] flight = {"To", "Greensboro", "Washington DC"};


            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(Fname);
            panel.add(Lname);

            panel.add(Box.createVerticalStrut(20));
            final JComboBox<String> cb = new JComboBox<>(flights);
            final JComboBox<String> c = new JComboBox<>(flight);
            cb.setVisible(true);
            panel.add(cb);
            panel.add(c);


            UIManager.put("OptionPane.okButtonText", "Next");
            UIManager.put("OptionPane.cancelButtonText", "Close");
            int input = JOptionPane.showConfirmDialog(null, panel, "Reserve Ticket",
                    JOptionPane.OK_CANCEL_OPTION);

            if (input == JOptionPane.CANCEL_OPTION) test = false;

            if (input == JOptionPane.OK_OPTION) {

                customer.setFName(Fname.getText());
                customer.setLName(Lname.getText());
                customer.setCityDeparture(Objects.requireNonNull(cb.getSelectedItem()).toString());
                customer.setCityDestination(Objects.requireNonNull(c.getSelectedItem()).toString());

                System.out.println(Fname.getText());

                if (input == JOptionPane.CANCEL_OPTION) {
                    test = false;
                    if (customer.getSeatClass().equals("Basic Economy")) {
                        Main.NumSeatsEconomy++;
                    }

                }
                if (Main.NumSeatsEconomy < 1) {
                    JOptionPane.showMessageDialog(null, "No more Economy cabin " +
                            "seats available on this flight");
                    int seat = JOptionPane.showConfirmDialog(null, "Would you like to upgrade to Business " +
                            "Class?");
                    if (seat == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "No available " +
                                "seats for class selection on this flight");
                    }
                    if (seat == JOptionPane.CANCEL_OPTION) {
                        System.exit(0);
                    }

                }

            }
        }
        else if (in == JOptionPane.NO_OPTION) {

            JTextField Fname = new JTextField(5);
            new TextPrompt("First Name", Fname);
            JTextField Lname = new JTextField(5);
            new TextPrompt("Last Name", Lname);
            JTextField SrcCity = new JTextField(5);
            new TextPrompt("From", SrcCity);
            JTextField DstCity = new JTextField(5);
            new TextPrompt("To", DstCity);


            String[] flights = {"From", "Washington DC", "Greensboro"};
            String[] flight = {"To", "Greensboro", "Washington DC"};


            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(Fname);
            panel.add(Lname);

            panel.add(Box.createVerticalStrut(20));
            final JComboBox<String> cb = new JComboBox<>(flights);
            final JComboBox<String> c = new JComboBox<>(flight);
            cb.setVisible(true);
            panel.add(cb);
            panel.add(c);


            UIManager.put("OptionPane.okButtonText", "Next");
            UIManager.put("OptionPane.cancelButtonText", "Close");
            int input = JOptionPane.showConfirmDialog(null, panel, "Reserve Ticket",
                    JOptionPane.OK_CANCEL_OPTION);

            if (input == JOptionPane.CANCEL_OPTION) test = false;

            if (input == JOptionPane.OK_OPTION) {

                customer.setFName(Fname.getText());
                customer.setLName(Lname.getText());
                customer.setCityDeparture(Objects.requireNonNull(cb.getSelectedItem()).toString());
                customer.setCityDestination(Objects.requireNonNull(c.getSelectedItem()).toString());

                System.out.println(Fname.getText());

                if (input == JOptionPane.CANCEL_OPTION) {
                    test = false;
                    if (customer.getSeatClass().equals("Basic Economy")) {
                        Main.NumSeatsEconomy++;
                    }

                }
                if (Main.NumSeatsEconomy < 1) {
                    JOptionPane.showMessageDialog(null, "No more Economy cabin " +
                            "seats available on this flight");
                    int seat = JOptionPane.showConfirmDialog(null, "Would you like to upgrade to Business " +
                            "Class?");
                    if (seat == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "No available " +
                                "seats for class selection on this flight");
                    }
                    if (seat == JOptionPane.CANCEL_OPTION) {
                        System.exit(0);
                    }

                }

            }
        }

        System.out.println(customer.getNumSeats());
    }
}
