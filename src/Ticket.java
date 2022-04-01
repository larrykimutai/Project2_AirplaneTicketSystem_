public class Ticket extends Airplane{

  private String FName, LName, Snack, SeatClass;
  private int Price;

  //default constructor
  public Ticket(){
    super();
    FName = null;
    LName = null;
    Snack = "Cookie";
    SeatClass = "Business";
    Price = 300;
  }

  //constructor
  public Ticket(String airline, String cityDeparture,
                String cityDestination, String dateDeparture,
                String timeDeparture, int flightNum, int numSeatsE, int numSeatsB){

      super(airline, cityDeparture, cityDestination,
              dateDeparture, timeDeparture, flightNum, numSeatsE, numSeatsB);
  }



  //mutators
  public void setFName(String fname){FName = fname;}
  public void setLName(String lname){LName = lname;}
  public void setSnack(String snack) {Snack = snack;}
  public void setSeatClass(String seatClass) {
    if(seatClass.equals("Main Business")) setNumSeatsBusiness();
    if(seatClass.equals("Basic Economy")) setNumSeatsEconomy();
    SeatClass = seatClass;
  }
  public void setPrice(int price){Price = price;}

  //accessors
  public String getFName(){return FName;}
  public String getLName(){return LName;}
  public String getSnack(){return Snack;}
  public String getSeatClass(){

    return SeatClass;
  }
  public int getPrice(){return Price;}

}
