package essai;
import description.Description;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import menu.MenuAbout;
import menu.MenuJeu;
import menu.MenuPartie;
import menu.MenuSauvegarde;
import partie.VueEquipes;
import partie.VueJoueur;
import strategie.Robot;

import java.util.AbstractMap;
import java.util.Map;

public class LancerMenuFX extends Application {
	private final VBox boxAccueil = new VBox();
	private final MenuBar menuBar = new MenuBar();
	private final VBox boxMenus = new VBox();
	private Label name = new Label();

	private VueJoueur equipes;
	private Description description;
    private MenuJeu mj;
    private MenuPartie mp;
    private MenuSauvegarde ms;
    private MenuAbout ma;
    private Robot robot;
	private int affichageTour;

	public LancerMenuFX() {
		robot = new Robot();
		equipes = new VueEquipes();
		description = new Description();
		mj = new MenuJeu(equipes, description);
		mp = new MenuPartie(equipes, description);
		ms = new MenuSauvegarde(equipes, description, robot.getTirages());
		ma = new MenuAbout();
		affichageTour = 0;
	}

	public void start(Stage stage) {
        stage.setTitle("Menu Sample");
        Scene scene = new Scene(new VBox(), 1000, 600);
        scene.setFill(Color.PINK);

        boxMenus.setAlignment(Pos.CENTER);
        boxMenus.setSpacing(10);
        boxMenus.setPadding(new Insets(20, 0, 20, 0));
		boxMenus.setStyle("-fx-background-color: #fff;-fx-border-color: gray");
        boxMenus.getChildren().addAll(name);

        // --- Menu Edit
        Menu menuEdit = new Menu("Edit");

        // --- Menu View
        Menu menuView = new Menu("View");

        menuBar.getMenus().addAll(menuFile(), menuEdit, menuView);
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar, boxMenus, boxAccueil);
        stage.setScene(scene);
        stage.show();
	}

	private VBox accueil() {
        boxAccueil.setAlignment(Pos.CENTER);
        Label labelTitle = new Label("Bienvenue sur le jeu");
		boxAccueil.getChildren().add(labelTitle);

		return boxAccueil;
	}

	private Menu menuFile() {
        Menu menuFile = new Menu("Fichier");
        MenuItem nouveau = new MenuItem("Nouvelle Partie");
        nouveau.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
               	name.setText("AA");
                boxMenus.setVisible(true);
                boxAccueil.setVisible(false);
            }
        });
        MenuItem partieExistante = new MenuItem("Partie existante");
        partieExistante.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                name.setText("BB");
                boxMenus.setVisible(true);
                boxAccueil.setVisible(false);
            }
        });
        MenuItem retourAccueil = new MenuItem("Retour à l'accueil");
        retourAccueil.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
				name.setText("CC");
                boxMenus.setVisible(true);
                boxAccueil.setVisible(false);
            }
        });
        MenuItem quitter = new MenuItem("Quitter");
        quitter.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
				System.exit(0);
            }
        });

		menuFile.getItems().addAll(nouveau, partieExistante, retourAccueil, quitter);
		return menuFile;
	}

	public static void main(String [] args) {
		Application.launch(args);
	}
}