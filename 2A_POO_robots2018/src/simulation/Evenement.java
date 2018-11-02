package simulation;

public abstract class Evenement{
  private long date;

  public Evenement(long date){
    this.date = date;
  }

  public long getDate(){
    return this.date;
  }

  public void setDate(long date){
    this.date = date;
  }

  public abstract void execute();

}
