public class allTicketSold extends Exception{


  //Exception class created to catch and respond accordingly to seat capacity exception in main class
  public allTicketSold(){
    super("Apologies, All tickets sold");
  }

  public allTicketSold(String string){
    super(string);
  }
}
