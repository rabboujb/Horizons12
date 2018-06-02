package essai;
import partie.VueEquipes;
import partie.VueJoueur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EssaiSauvegarde {
    public static void main(String [] args)
    {
		try {
			FileInputStream fis = new FileInputStream("src/Sauvegarde");
			ObjectInputStream ois = new ObjectInputStream(fis);

			while(fis.available() != 0) {
				System.out.println(ois.readObject());
			}

			fis.close();
			ois.close();
		}
		catch(FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		catch(IOException ioe) {
			System.out.println(ioe);
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
    }
}