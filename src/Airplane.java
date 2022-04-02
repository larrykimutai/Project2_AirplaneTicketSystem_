import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Airplane {

  // variables
  private String Airline, CityDeparture,
          CityDestination, DateDeparture,
          FlightNum, TimeDeparture;;

  LocalDate now = LocalDate.now();
  DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
  String d = df.format(now);


  //default constructor
  public Airplane(){

    this("Delta Airlines", null,
            null, null,
            null, null);
  }

  //constructors
  public Airplane(String airline, String cityDeparture,
                  String cityDestination, String dateDeparture,
                  String timeDeparture, String flightNum){

    Airline = airline;
    CityDeparture = cityDeparture;
    CityDestination = cityDestination;
    DateDeparture = dateDeparture;
    TimeDeparture = timeDeparture;
    FlightNum = flightNum;

  }



  //mutators
  public void setAirline(String airline)                  {Airline = airline;}
  public void setCityDeparture(String cityDeparture)      {CityDeparture = cityDeparture;}
  public void setCityDestination(String cityDestination)  {CityDestination = cityDestination;}
  public void setDateDeparture(String dateDeparture)      {
    //if(dateDeparture)
    DateDeparture = dateDeparture;}
  public void setTimeDeparture(String timeDeparture)      {TimeDeparture = timeDeparture;}
  public void setFlightNum()                 {
    if(CityDeparture.equals("Greensboro") && CityDestination.equals("Washington DC")){
      FlightNum = "001";
      setTimeDeparture("6:00 AM");
      setAirline("Delta Airlines");
    }
    if(CityDestination.equals("Greensboro") && CityDeparture.equals("Washington DC")){
      FlightNum = "200";
      setTimeDeparture("5:30 PM");
      setAirline("Delta Airlines");
    }
  }
  public void setNumSeatsEconomy(){
   Main.NumSeatsEconomy--;

  }
  public void setNumSeatsBusiness(){
    Main.NumSeatsBusiness--;
  }



  //accessors
  public String getAirline()          {return Airline;}
  public String getCityDeparture()    {return CityDeparture;}
  public String getCityDestination()  {return CityDestination;}
  public String getDateDeparture()    {return DateDeparture;}
  public String getTimeDeparture()    {return TimeDeparture;}
  public String getFlightNum()           {return FlightNum;}
  public int getNumSeatsEconomy()     {return Main.NumSeatsEconomy;}
  public int getNumSeatsBusiness()    {return Main.NumSeatsBusiness;}

  public static void numSeats(){

  }
}


/******************************************************************************
 * Information of airplane capacity based on Bombardier CRJ-700
 *
 * https://www.delta.com/us/en/aircraft/bombardier/crj-700
 * ***************************************************************************/