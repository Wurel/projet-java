package simulation;

public abstract class Evenement{
  private long date;

  public Evenement(long date){

  }

  public long getDate(){
    return this.date;
  }

  public abstract void execute();

}
