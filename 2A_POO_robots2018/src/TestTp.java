import io.LecteurDonnees;
import donnees.*;
import simulation.*;
import creer_date.*;

import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;
import java.awt.image.ImageObserver;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gui.GUISimulator;
import gui.Rectangle;
import gui.ImageElement;
import gui.Simulable;
import gui.Text;



import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gui.GUISimulator;
import gui.Rectangle;
import gui.ImageElement;

public class TestTp{
  public static void main(String[] args) {
      // crée la fenêtre graphique dans laquelle dessiner
      // GUISimulator gui = new GUISimulator(800, 600, Color.BLACK);
      // crée l'invader, en l'associant à la fenêtre graphique précédente
      Jeu jeu = new Jeu(args[0]);
      Simulateur simul = new Simulateur();
      jeu.setSimulateur(simul);

      ChefPompierElementaire totoLePompier = new ChefPompierElementaire(simul, jeu.getDonnees());
      totoLePompier.ordres();
      jeu.setChefPompierElementaire(totoLePompier);

      jeu.setSimulateur(simul);
  }
}

class Jeu implements Simulable{

  /** L'interface graphique associée */
  private GUISimulator gui;
  private DonneesSimulation donnees;
  private String fichier;
  private int nombrePixels;
  private Simulateur simul;
  private ChefPompierElementaire totoLePompier;

  public Jeu(String fichier){
    this.nombrePixels = 50;
  try {

    this.donnees = new DonneesSimulation();
    this.donnees = LecteurDonnees.creeDonnees(fichier);
    this.fichier = fichier;
    this.gui = new GUISimulator( this.donnees.getCarte().getNbLignes()*this.nombrePixels+60 + 800,
    this.donnees.getCarte().getNbColonnes()*this.nombrePixels+40, Color.BLACK);
    gui.setSimulable(this);				// association a la gui!

    draw();


  } catch (FileNotFoundException e) {
      System.out.println("fichier " + fichier + " inconnu ou illisible");
  } catch (DataFormatException e) {
      System.out.println("\n\t**format du fichier " + fichier + " invalide: " + e.getMessage());
  }


  }

  public DonneesSimulation getDonnees(){
    return this.donnees;
  }

  public void setSimulateur(Simulateur simul){
    this.simul = simul;
  }

  public Simulateur getSimulateur(){
    return this.simul;
  }

  public void setChefPompierElementaire(ChefPompierElementaire totoLePompier){
    this.totoLePompier = totoLePompier;
  }

  @Override
  public void next() {
    if (this.simul.getDate()%200 == 0) {
      this.totoLePompier.ordres();
    }
      if (!this.simul.simulationTerminee()){
        for (Evenement event : this.simul.getEvenements()) {
          if (event.getDate() == this.simul.getDate()) {
            event.execute();
            draw();
          }
        }
        this.simul.incrementeDate();
        System.out.println(this.simul.getDate());
      }
      else{
        this.simul.incrementeDate();

      }
  }


  @Override
  public void restart() {
    try {
      this.donnees = new DonneesSimulation();
      this.donnees = LecteurDonnees.creeDonnees(this.fichier);
      Simulateur simul = new Simulateur();
      this.setSimulateur(simul);
      ChefPompierElementaire totoLePompier = new ChefPompierElementaire(this.simul, this.getDonnees());
      this.totoLePompier = totoLePompier;
      this.totoLePompier.ordres();

      this.simul = simul;

    } catch (FileNotFoundException e) {
        System.out.println("fichier " + fichier + " inconnu ou illisible");
    } catch (DataFormatException e) {
        System.out.println("\n\t**format du fichier " + fichier + " invalide: " + e.getMessage());
    }
    draw();
  }


  void draw(){
    gui.reset();	// clear the window

    for (int i = 0; i < this.donnees.getCarte().getNbLignes(); i++) {
      for (int j = 0; j < this.donnees.getCarte().getNbColonnes(); j++) {
        gui.addGraphicalElement(new Rectangle(60+j*this.nombrePixels, 40+i*this.nombrePixels,
          Color.decode(this.donnees.getCarte().getCase(i,j).getCouleur()),
          Color.decode(this.donnees.getCarte().getCase(i,j).getCouleur()),
           this.nombrePixels));
      }

    }

    int compteur = 0;
    for (Incendie incend : this.donnees.getIncendies() ) {
      if (incend.getEauNecessaire() != 0){
        gui.addGraphicalElement(new Rectangle(60+incend.getColonne()*this.nombrePixels,
         40+incend.getLigne()*this.nombrePixels,
          Color.decode("#FE1B00"),
          Color.decode("#FE1B00"),
           this.nombrePixels/2));
        gui.addGraphicalElement(new Text(60+incend.getColonne()*this.nombrePixels,
         40+incend.getLigne()*this.nombrePixels, Color.decode("#A89874"),
         new Integer(incend.getEauNecessaire()).toString()));
         gui.addGraphicalElement(new Text( this.donnees.getCarte().getNbLignes()*this.nombrePixels+200,
         compteur*20 + 40,
          Color.decode("#FFFFFF"),
          incend.toString()));
        compteur ++;
      }

    }

    int compteur_robot = compteur;
    for (Robot robot : this.donnees.getRobots() ) {
      gui.addGraphicalElement(new Rectangle(60+robot.getPosition().getColonne()*this.nombrePixels,
       40+robot.getPosition().getLigne()*this.nombrePixels,
        Color.decode("#A22C29"),
        Color.decode("#A22C29"),
         this.nombrePixels/2));
      gui.addGraphicalElement(new Text(60+robot.getPosition().getColonne()*this.nombrePixels,
       40+robot.getPosition().getLigne()*this.nombrePixels, Color.decode("#A89874"),
       robot.getType()));
     gui.addGraphicalElement(new Text(60+robot.getPosition().getColonne()*this.nombrePixels,
      60+robot.getPosition().getLigne()*this.nombrePixels, Color.decode("#A89874"),
      new Integer(robot.getReservoirEau()).toString()));
      gui.addGraphicalElement(new Text( this.donnees.getCarte().getNbLignes()*this.nombrePixels+240,
       compteur_robot*20 + 40,
        Color.decode("#FFFFFF"),
        robot.toString()));
      compteur_robot ++;

    }

  }
}
