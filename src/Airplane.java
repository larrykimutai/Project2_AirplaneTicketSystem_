import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Airplane {

  // variables
  private String Airline, CityDeparture,
          CityDestination, DateDeparture,
          FlightNum, TimeDeparture;
  private int NumSeatsF1;
  private static int instanceNumSeatsF1;

  private int NumSeatsF2;
  private static int instanceNumSeatsF2;

  LocalDate now = LocalDate.now();
  DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
  String d = df.format(now);


  //default constructor
  public Airplane(){

    this("Delta Airlines", null,
            null, "12/06/2022",
            null, null, 20);
  }

  //constructors
  public Airplane(String airline, String cityDeparture,
                  String cityDestination, String dateDeparture,
                  String timeDeparture, String flightNum, int numSeats){

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
  public void setCityDestination(String cityDestination)  {CityDestination = cityDestination;
    setFlightNum();}
  public void setTimeDeparture(String timeDeparture)      {TimeDeparture = timeDeparture;}
  public void setDateDeparture(String dateDeparture)      {DateDeparture = dateDeparture;}
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

  public void setNumSeatsF1(){
    instanceNumSeatsF1--;
    NumSeatsF1 = instanceNumSeatsF1;
  }

  public int getNumSeatsF1(){
    return NumSeatsF1;
  }




  //accessors
  public String getAirline()          {return Airline;}
  public String getCityDeparture()    {return CityDeparture;}
  public String getCityDestination()  {return CityDestination;}
  public String getDateDeparture()    {return DateDeparture;}
  public String getTimeDeparture()    {return TimeDeparture;}
  public String getFlightNum()           {return FlightNum;}

}


