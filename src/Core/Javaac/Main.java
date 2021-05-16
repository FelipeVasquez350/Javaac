package Core.Javaac;

import javax.swing.JFrame;

public class Main extends JFrame{

	public Main() {
		Window window = new Window();
		add(window);
		pack();
		setTitle("Javaac");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(460, 5);
		setResizable(false);
	}

	public static void main(String[] args) throws Exception {
		JFrame JF = new Main();
		JF.setVisible(true);  
	}
}