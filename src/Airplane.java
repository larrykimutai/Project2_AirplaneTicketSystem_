public abstract class Airplane {

  // variables
  private String Airline, CityDeparture,
          CityDestination, DateDeparture,
          TimeDeparture;
  private int FlightNum;
  private int NumSeatsEconomy;
  private int NumSeatsBusiness;


  //default constructor
  public Airplane(){
    this("Delta Airlines", null,
            null, null,
            null, 0, 44, 25);
  }

  //constructors
  public Airplane(String airline, String cityDeparture,
                  String cityDestination, String dateDeparture,
                  String timeDeparture, int flightNum, int numSeatsEconomy, int numSeatsBusiness){

    Airline = airline;
    CityDeparture = cityDeparture;
    CityDestination = cityDestination;
    DateDeparture = dateDeparture;
    TimeDeparture = timeDeparture;
    FlightNum = flightNum;
    NumSeatsEconomy = numSeatsEconomy;
    NumSeatsBusiness = numSeatsBusiness;
  }



  //mutators
  public void setAirline(String airline)                  {Airline = airline;}
  public void setCityDeparture(String cityDeparture)      {CityDeparture = cityDeparture;}
  public void setCityDestination(String cityDestination)  {CityDestination = cityDestination;}
  public void setDateDeparture(String dateDeparture)      {DateDeparture = dateDeparture;}
  public void setTimeDeparture(String timeDeparture)      {TimeDeparture = timeDeparture;}
  public void setFlightNum(int flightNum)                 {FlightNum = flightNum;}
  public void setNumSeatsEconomy(int numSeatsEconomy)     {NumSeatsEconomy = numSeatsEconomy;}
  public void setNumSeatsBusiness(int numSeatsBusiness)   {NumSeatsBusiness = numSeatsBusiness;}



  //accessors
  public String getAirline()          {return Airline;}
  public String getCityDeparture()    {return CityDeparture;}
  public String getCityDestination()  {return CityDestination;}
  public String getDateDeparture()    {return DateDeparture;}
  public String getTimeDeparture()    {return TimeDeparture;}
  public int getFlightNum()           {return FlightNum;}
  public int getNumSeatsEconomy()     {return NumSeatsEconomy;}
  public int getNumSeatsBusiness()    {return NumSeatsBusiness;}
}


/******************************************************************************
 * Information of airplane capacity based on Bombardier CRJ-700
 *
 * https://www.delta.com/us/en/aircraft/bombardier/crj-700
 * ***************************************************************************/