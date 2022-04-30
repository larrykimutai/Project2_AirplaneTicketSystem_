public class Ticket extends Airplane{

  private String FName, LName;
  private String Price;

  //default constructor
  public Ticket(){
    super();
    FName = null;
    LName = null;
    Price = "$300";
  }

  //constructor
  public Ticket(String cityDeparture,
                String cityDestination, String dateDeparture,
                String timeDeparture, String flightNum){

      super(cityDeparture, cityDestination,
              dateDeparture, timeDeparture, flightNum);
  }



  //mutators
  public void setFName(String fname){FName = fname;}
  public void setLName(String lname){LName = lname;}

  //accessors
  public String getPrice(){return Price;}

  public int getSeatNumber(){
    if(this.getFlightNum().equals("001")) return this.returnNumSeats1();
    if(this.getFlightNum().equals("002")) return this.returnNumSeats2();
    return 0;
  }



//toString method to display all customers information
  public String toString(){
    return "-----------------------------------------------------------------------------------------------------"
            + "\n\nName: " + this.FName + " " + this.LName + "\n\nFlight Number: " + this.getFlightNum() +
            "\n\nDate: " + this.getDateDeparture() + "\nBoarding: " + this.getTimeDeparture() +
            "\n\nFrom: " + this.getCityDeparture() + "\nTo: " + this.getCityDestination() +
             "\nSeat: " +  getSeatNumber()  +
            "\n\nTotal: " + this.getPrice() +
            "\n\n-----------------------------------------------------------------------------------------------------";
  }

}
