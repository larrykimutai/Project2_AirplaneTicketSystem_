import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Main {

  public static void main(String[] args){
    Ticket cust1 = new Ticket();
    GUI(cust1);
  }

  public static void GUI(Ticket customer){
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

    String[] seatClass = {"Basic Economy", "Main Business"};

    LocalDate now = LocalDate.now();
    DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    JTextField date = new JTextField(5);
    new TextPrompt(df.format(now), date);



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


    panel.add(Box.createVerticalStrut(20));
    final JComboBox<String> comboBox = new JComboBox<String>(seatClass);
    comboBox.setVisible(true);
    panel.add(comboBox);

    panel.add(Box.createVerticalStrut(20));
    panel.add(date);


    JOptionPane.showConfirmDialog(null, panel, "Reserve Ticket",
            JOptionPane.OK_CANCEL_OPTION);



    boolean snack = false;

    if(Objects.requireNonNull(comboBox.getSelectedItem()).toString().equals("Main Business")) {
      JPanel food = new JPanel();
      String[] snck = {"Cookies", "Peanuts"};
      final JComboBox<String> snckJCB = new JComboBox<>(snck);
      snckJCB.setVisible(true);

      food.add(snckJCB);

      JOptionPane.showConfirmDialog(null, food, "Pick a snack", JOptionPane.OK_CANCEL_OPTION);

      customer.setSnack(Objects.requireNonNull(snckJCB.getSelectedItem()).toString());

      snack = true;
    }

    customer.setFName(Fname.getText());
    customer.setLName(Lname.getText());
    customer.setCityDeparture(Objects.requireNonNull(cb.getSelectedItem()).toString());
    customer.setCityDestination(Objects.requireNonNull(c.getSelectedItem()).toString());
    if(date.getText().isEmpty()) customer.setDateDeparture(df.format(now));
    customer.setDateDeparture(date.getText());




    System.out.println(Fname.getText());
  }

}
