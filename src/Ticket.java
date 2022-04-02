public class Ticket extends Airplane{

  private String FName, LName, Snack, SeatClass;
  private String Price;

  //default constructor
  public Ticket(){
    super();
    FName = null;
    LName = null;
    Snack = "";
    SeatClass = "Business";
    Price = "$300";
  }

  //constructor
  public Ticket(String airline, String cityDeparture,
                String cityDestination, String dateDeparture,
                String timeDeparture, String flightNum){

      super(airline, cityDeparture, cityDestination,
              dateDeparture, timeDeparture, flightNum);
  }



  //mutators
  public void setFName(String fname){FName = fname;}
  public void setLName(String lname){LName = lname;}
  public void setSnack(String snack) {

    Snack = snack;}
  public void setSeatClass(String seatClass) {
    if(seatClass.equals("Main Business")){
      setNumSeatsBusiness();
      setFlightNum();
      setPrice("$450");
      SeatNumber(Main.NumSeatsBusiness);
    }
    if(seatClass.equals("Basic Economy")){
      setNumSeatsEconomy();
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
  public String getSnack(){return Snack;}
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

  public String snack(){
    if(!(Snack.isEmpty())) return this.getSnack();
    else return null;
  }


  public String toString(){
    return "-----------------------------------------------------------------------------------------------------"
            + "\n\nName: " + this.FName + " " + this.LName + "\n\nFlight Number: " + this.getFlightNum() +
            "\n\nDate: " + this.getDateDeparture() + "\nBoarding: " + this.getTimeDeparture() +
            "\n\nFrom: " + this.getCityDeparture() + "\nTo: " + this.getCityDestination() +
            "\n\nZone: " + this.getSeatClass() + "\nSeat: " +  getSeatNumber() + "\nSnack: " + snack() +
            "\n\nTotal: " + this.getPrice() +
            "\n\n-----------------------------------------------------------------------------------------------------";
  }

}
