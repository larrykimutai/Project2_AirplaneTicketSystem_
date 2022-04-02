import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
  public static boolean test = true;
  public static int NumSeatsEconomy = 44;
  public static int NumSeatsBusiness = 25;

  public static void main(String[] args){
    ArrayList<Ticket> Customers = new ArrayList<>();
    int cntr = 0;
    do{
      Customers.add(new Ticket());
      ReserveTicket(Customers.get(cntr));
      cntr++;
    }while(test);

    Customers.remove(Customers.size() - 1);
    for (Ticket customer : Customers) {
      printTicket(customer);
    }

  }

  public static void printTicket(Ticket customer){
    System.out.println(customer.toString());
  }



  public static void ReserveTicket(Ticket customer){
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
    final JComboBox<String> comboBox = new JComboBox<>(seatClass);
    comboBox.setVisible(true);
    panel.add(comboBox);

    panel.add(Box.createVerticalStrut(20));
    panel.add(date);

    UIManager.put("OptionPane.okButtonText", "Next");
    UIManager.put("OptionPane.cancelButtonText", "Close");
    int input = JOptionPane.showConfirmDialog(null, panel, "Reserve Ticket",
            JOptionPane.OK_CANCEL_OPTION);

    if(input == JOptionPane.CANCEL_OPTION) test = false;

    if(input == JOptionPane.OK_OPTION){
      if (Objects.requireNonNull(comboBox.getSelectedItem()).toString().equals("Main Business")) {
        JPanel food = new JPanel();
        String[] snck = {"Cookies", "Peanuts"};
        final JComboBox<String> snckJCB = new JComboBox<>(snck);
        snckJCB.setVisible(true);

        food.add(snckJCB);

        JOptionPane.showConfirmDialog(null, food, "Pick a snack", JOptionPane.OK_CANCEL_OPTION);

        customer.setSnack(Objects.requireNonNull(snckJCB.getSelectedItem()).toString());

      }else if(Objects.requireNonNull(comboBox.getSelectedItem()).toString().equals("Basic Economy")){
        customer.setSnack("Unavailable");
      }

      customer.setFName(Fname.getText());
      customer.setLName(Lname.getText());
      customer.setCityDeparture(Objects.requireNonNull(cb.getSelectedItem()).toString());
      customer.setCityDestination(Objects.requireNonNull(c.getSelectedItem()).toString());
      if (date.getText().isEmpty()) customer.setDateDeparture(df.format(now));
      else customer.setDateDeparture(date.getText());
      customer.setSeatClass(Objects.requireNonNull(comboBox.getSelectedItem().toString()));


      System.out.println(Fname.getText());

      if (input == JOptionPane.CANCEL_OPTION) {
        test = false;
        if (customer.getSeatClass().equals("Basic Economy")) {
          Main.NumSeatsEconomy++;
        }
        if (customer.getSeatClass().equals("Main Business")) {
          Main.NumSeatsBusiness++;
        }
      }
      if (Main.NumSeatsEconomy < 1) {
        JOptionPane.showMessageDialog(null, "No more Economy cabin " +
                "seats available on this flight");
        int seat = JOptionPane.showConfirmDialog(null, "Would you like to upgrade to Business " +
                "Class?");
        if (seat == JOptionPane.OK_OPTION) {
          customer.setSeatClass("Main Business");
        }
        if (seat == JOptionPane.NO_OPTION) {
          JOptionPane.showMessageDialog(null, "No available " +
                  "seats for class selection on this flight");
        }
        if (seat == JOptionPane.CANCEL_OPTION) {
          System.exit(0);
        }
        if (Main.NumSeatsBusiness < 1) {
          JOptionPane.showMessageDialog(null, "No available seats on this flight");
          System.exit(0);
        }
      }

      if (Main.NumSeatsBusiness < 1) {
        JOptionPane.showMessageDialog(null, "No more Business cabin " +
                "seats available on this flight");
        int seat = JOptionPane.showConfirmDialog(null, "Would you like to downgrade to Economy " +
                "Class?");
        if (seat == JOptionPane.OK_OPTION) {
          customer.setSeatClass("Basic Economy");
        }

        if (seat == JOptionPane.NO_OPTION) {
          JOptionPane.showMessageDialog(null, "No available " +
                  "seats for class selection on this flight");
        }
        if (seat == JOptionPane.CANCEL_OPTION) {
          System.exit(0);
          if (Main.NumSeatsEconomy < 1) {
            JOptionPane.showMessageDialog(null, "No available seats on this flight");
            System.exit(0);
          }
        }
      }
    }

  }
}


/******************************************************************************
 * Information of airplane capacity based on Bombardier CRJ-700
 *
 * https://www.delta.com/us/en/aircraft/bombardier/crj-700
 * ***************************************************************************/
