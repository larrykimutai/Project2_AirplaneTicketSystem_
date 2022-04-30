public abstract class Airplane {


  // variables
  private String CityDeparture,
          CityDestination, DateDeparture,
          FlightNum, TimeDeparture;

  //used static variables in order to keep track of seats with each new object creation
  public static int plane1seatsStat = 20;
  public int plane1seats;
  public static int plane2seatsStat = 20;
  public int plane2seats;

  //default constructor
  public Airplane(){

    this( "Greensboro",
            "Washington DC", null,
            null, null);
  }

  //constructors
  public Airplane(String cityDeparture,
                  String cityDestination, String dateDeparture,
                  String timeDeparture, String flightNum){


    CityDeparture = cityDeparture;
    CityDestination = cityDestination;
    DateDeparture = dateDeparture;
    TimeDeparture = timeDeparture;
    FlightNum = flightNum;

  }



  //accessor
  public int returnNumSeats1(){
    return plane1seats;
  }
  public int returnNumSeats2(){
    return plane2seats;
  }

  //mutator
  public void setSeat(int x){
    if(x == 0){
      plane1seats = plane1seatsStat;
      plane1seatsStat--;
    }
    if(x == 1){
      plane2seats = plane2seatsStat;
      plane2seatsStat--;
    }
  }

  public void setCityDeparture(String cityDeparture)      {
    CityDeparture = cityDeparture;
    if(cityDeparture.equals("Greensboro")){
      setTimeDeparture("6:00 AM");
      setDateDeparture("12/06/2022");
      setCityDestination("Washington DC");
      setFlightNum("001");
    }else if(cityDeparture.equals("Washington DC")){
      setTimeDeparture("5:30 PM");
      setDateDeparture("12/06/2022");
      setCityDestination("Greensboro");
      setFlightNum("002");
    }
  }

  public void setCityDestination(String cityDestination)  {CityDestination = cityDestination;}
  public void setDateDeparture(String dateDeparture)      {DateDeparture = dateDeparture;}
  public void setTimeDeparture(String timeDeparture)      {TimeDeparture = timeDeparture;}
  public void setFlightNum(String flightNum)              {FlightNum = flightNum;}


  //accessors
  public String getCityDeparture()    {return CityDeparture;}
  public String getCityDestination()  {return CityDestination;}
  public String getDateDeparture()    {return DateDeparture;}
  public String getTimeDeparture()    {return TimeDeparture;}
  public String getFlightNum()           {return FlightNum;}


}


