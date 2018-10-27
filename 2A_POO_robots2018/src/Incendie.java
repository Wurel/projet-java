public class Incendie{
  private Case position;
  private int eauNecessaire;

  public Incendie(Case position, int eauNecessaire){
    this.position = position;
    this.eauNecessaire = eauNecessaire;
  }

  public Case getPosition(){
    return this.position;
  }

  public void setPosition(Case nv_case){
    this.position = nv_case;
  }

  public int getEauNecessaire(){
    return this.eauNecessaire;
  }

  public void setEauNecessaire(int eauNecessaire){
    this.eauNecessaire = eauNecessaire;
  }

}
