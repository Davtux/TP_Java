package exo8;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestLongAction extends JFrame {

	private final JButton btnAction;

	public TestLongAction() {
		btnAction = new JButton("Start");
		btnAction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LongAction().traitementLong();
			}

		});
		final Container contentPane = getContentPane();
		contentPane.add(btnAction);
		setTitle("Test de LongAction");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new TestLongAction();
		// Lors du redimensionnement de la fenêtre après un clic sur le bouton Start,
		// l'affichage du bouton n'est pas actualisé, il ne se fait qu'à la fin de
		// la méthode traitementLong()
		
		// Solution 1 : Faire effectuer la méthode traitementLong() par un autre Thread
		// Solution 2 : Utiliser la méthode statique invokeLater() de la classe SwingUtilities en lui
		//	passant en paramètre une classe réalisant Runnable et exécutant la méthode traitementLong()
		//	dans sa méthode run()
	}

}
