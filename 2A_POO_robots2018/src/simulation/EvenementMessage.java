package simulation;

/**
  * Classe modelisant un Evenement qui envoit un message
  */
public class EvenementMessage extends Evenement {

    private String message;

    /**
      * @param date Date a laquelle le message sera affiche
      * @param message Message qui sera affiche
      */
    public EvenementMessage(long date, String message){
      super(date);
      this.message = message;
    }

    @Override
    public void execute(){
      System.out.println(this.getDate() + " : " + this.message);
    }



}
