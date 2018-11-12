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
import java.util.Scanner;

import gui.GUISimulator;
import gui.Rectangle;
import gui.ImageElement;

/**
  * Classe contenant un main permettant de tester les differentes fonctionnalites
  */
public class TestTp{

  /**
    * @param args Prend en argument le chemin vers la carte
    */
  public static void main(String[] args) {
      // crée la fenêtre graphique dans laquelle dessiner
      // GUISimulator gui = new GUISimulator(800, 600, Color.BLACK);
      // crée l'invader, en l'associant à la fenêtre graphique précédente
      Jeu jeu = new Jeu(args[0]);
      Simulateur simul = new Simulateur();
      jeu.setSimulateur(simul);

      ChefPompierEvolue totoLePompier = new ChefPompierEvolue(simul, jeu.getDonnees());
      totoLePompier.ordres();
      jeu.setChefPompierEvolue(totoLePompier);

      jeu.setSimulateur(simul);
  }
}

/**
  * Classe representant le jeu
  */
class Jeu implements Simulable{

  /** L'interface graphique associée */
  private GUISimulator gui;
  private DonneesSimulation donnees;
  private String fichier;
  private int nombrePixels;
  private Simulateur simul;
  private ChefPompierEvolue totoLePompier;

  /**
    * Initialise le jeu
    */
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

  /**
    * @return Renvoie les donnees du pobleme
    */
  public DonneesSimulation getDonnees(){
    return this.donnees;
  }

  /**
    * @simul Set le Simulateur
    */
  public void setSimulateur(Simulateur simul){
    this.simul = simul;
  }

  /**
    * @return Renvoie le simulateur
    */
  public Simulateur getSimulateur(){
    return this.simul;
  }

  /**
    * @param totoLePompier Set le chef pompier
    */
  public void setChefPompierEvolue(ChefPompierEvolue totoLePompier){
    this.totoLePompier = totoLePompier;
  }

  /**
    * Permet de passer a l'etape suivante dans la simulation
    */
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
    }
    else{
      this.simul.incrementeDate();
    }
  }

  /**
    * Permet de redemarrer la simulation
    */
  @Override
  public void restart() {
    try {
      this.donnees = new DonneesSimulation();
      this.donnees = LecteurDonnees.creeDonnees(this.fichier);
      Simulateur simul = new Simulateur();
      this.setSimulateur(simul);
      ChefPompierEvolue totoLePompier = new ChefPompierEvolue(this.simul, this.getDonnees());
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

  /**
    * Creer l'interface graphique
    */
  void draw(){
    gui.reset();	// clear the window

    for (int i = 0; i < this.donnees.getCarte().getNbLignes(); i++) {
      for (int j = 0; j < this.donnees.getCarte().getNbColonnes(); j++) {
        gui.addGraphicalElement(
        new ImageElement(50 + this.donnees.getCarte().getCase(i,j).getColonne()*this.nombrePixels -this.nombrePixels/2,50 +
        this.donnees.getCarte().getCase(i, j).getLigne()*this.nombrePixels -this.nombrePixels/2,
                      this.donnees.getCarte().getCase(i,j).getImage() ,this.nombrePixels, this.nombrePixels, null ) );
      }

    }

    int compteur = 0;
    for (Incendie incend : this.donnees.getIncendies() ) {
      if (incend.getEauNecessaire() != 0){
        gui.addGraphicalElement(
        new ImageElement(50 + incend.getColonne()*this.nombrePixels -this.nombrePixels/2,50 +
        incend.getLigne()*this.nombrePixels -this.nombrePixels/2,
                      "src/image/feu.gif" ,this.nombrePixels, this.nombrePixels, null ) );

         gui.addGraphicalElement(new Text( this.donnees.getCarte().getNbLignes()*this.nombrePixels+200,
         compteur*20 + 40,
          Color.decode("#FFFFFF"),
          incend.toString()));
        compteur ++;
      }

    }

    int compteur_robot = compteur;
    for (Robot robot : this.donnees.getRobots() ) {
      gui.addGraphicalElement(
      new ImageElement(50 + robot.getPosition().getColonne()*this.nombrePixels -this.nombrePixels/2,50 +
      robot.getPosition().getLigne()*this.nombrePixels -this.nombrePixels/2,
      "src/image/" + robot.getType() + ".png" ,(int)(this.nombrePixels), (int)(this.nombrePixels), null ) );

      gui.addGraphicalElement(new Text( this.donnees.getCarte().getNbLignes()*this.nombrePixels+240,
       compteur_robot*20 + 40,
        Color.decode("#FFFFFF"),
        robot.toString()));
      compteur_robot ++;

    }

  }
}
