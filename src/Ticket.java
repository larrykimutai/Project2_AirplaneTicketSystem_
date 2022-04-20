public class Ticket extends Airplane{

  private String FName, LName, SeatClass;
  private String Price;

  //default constructor
  public Ticket(){
    super();
    FName = null;
    LName = null;
    SeatClass = "Basic Economy";
    Price = "$300";
  }

  //constructor
  public Ticket(String airline, String cityDeparture,
                String cityDestination, String dateDeparture,
                String timeDeparture, String flightNum, int numSeats){

      super(airline, cityDeparture, cityDestination,
              dateDeparture, timeDeparture, flightNum, numSeats);

  }



  //mutators
  public void setFName(String fname){FName = fname;}
  public void setLName(String lname){LName = lname;}

  public void setNumSeats(String seatClass) {
    if(getFlightNum().equals("001")){
      setNumSeatsF1();
      setFlightNum();
      setPrice("$300");
      SeatNumber(Main.NumSeatsEconomy);
    }
    SeatClass = seatClass;
  }
  public void setPrice(String price){Price = price;}

  //accessors
  public String getFName(){return FName;}
  public String getLName(){return LName;}
  public String getSeatClass(){

    return SeatClass;
  }
  public String getPrice(){return Price;}

  private int Num;
  public void SeatNumber(int num){
    Num = num;
  }
  public int getSeatNumber(){
    return Num;
  }
  public int getNumSeats(){
    if(getFlightNum().equals("001")) getNumSeatsF1();
    return 0;
  }



  public String toString(){
    return "-----------------------------------------------------------------------------------------------------"
            + "\n\nName: " + this.FName + " " + this.LName + "\n\nFlight Number: " + this.getFlightNum() +
            "\n\nDate: " + this.getDateDeparture() + "\nBoarding: " + this.getTimeDeparture() +
            "\n\nFrom: " + this.getCityDeparture() + "\nTo: " + this.getCityDestination() +
            "\n\nZone: " + this.getSeatClass() + "\nSeat: " +  getSeatNumber() +
            "\n\nTotal: " + this.getPrice() +
            "\n\n-----------------------------------------------------------------------------------------------------";
  }

}
