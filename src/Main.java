import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

  public static boolean test = true;


  public static void main(String[] args) {

    //create array of Customer objects to store multiple customers
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

  //Print out each customer receipt
  public static void printTicket(Ticket customer) {
    System.out.println(customer.toString());
    JOptionPane.showMessageDialog(null, customer.toString());
  }


  //This method displays a UI that is used to input customer information that is stored in each respective Customer object
  public static void ReserveTicket(Ticket customer) {
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


    //if the user closes the pane, exit out of the loop
    if (input == JOptionPane.CLOSED_OPTION) {
      test = false;
    }

    //if the user selects on cancel, exit out of the loop
    if (input == JOptionPane.CANCEL_OPTION) {
      test = false;
    }

    //if user selects okay after entering information, update object with corresponding data
    if (input == JOptionPane.OK_OPTION) {
      customer.setFName(Fname.getText());
      customer.setLName(Lname.getText());
      customer.setCityDeparture(Objects.requireNonNull(cb.getSelectedItem()).toString());
      try {
        if (customer.getFlightNum().equals("001")) {
          customer.setSeat(0);
        } else if (customer.getFlightNum().equals("002")) {
          customer.setSeat(1);
        }
      }catch (NullPointerException npe){System.out.println("Missing information");}

      //custom exception that throws "allTicketSold" exception when seat capacity is reached on either plane
      try {
        int setNum = customer.getSeatNumber();
        if (setNum <= 0) {
          throw new allTicketSold();
        }
      } catch (allTicketSold aTS) {
        JOptionPane.showMessageDialog(null,
                "No more tickets available for customer: " + customer);
      }

    }
  }

}


/******************************************************************************
 * Information of airplane capacity based on Bombardier CRJ-700
 *
 * https://www.delta.com/us/en/aircraft/bombardier/crj-700
 * ***************************************************************************/
