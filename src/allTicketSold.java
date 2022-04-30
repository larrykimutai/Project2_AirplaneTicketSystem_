public class allTicketSold extends Exception{

  public allTicketSold(){
    super("Apologies, All tickets sold");
  }

  public allTicketSold(String string){
    super(string);
  }
}
