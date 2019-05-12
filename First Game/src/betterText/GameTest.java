package betterText;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTest {

	ChoiceHandler cHandler = new ChoiceHandler();
	UI ui = new UI();
	VisibilityManager vm = new VisibilityManager(ui);
	StartUp startUp = new StartUp(this, ui, vm);
	
	String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
	
	public static void main(String[] args) {
		
		new GameTest();
		
	}
	
	public GameTest() {
		
		ui.createUI(cHandler);
		startUp.defaultSetup();
		vm.showTitleScreen();
		
	}
	
	public class ChoiceHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand();
			
			switch(yourChoice) {
			case "start": vm.characterCreation(); startUp.charCreate(); break;
			case "c1": startUp.selectPosition(nextPosition1); break;
			case "c2": startUp.selectPosition(nextPosition2); break;
			case "c3": startUp.selectPosition(nextPosition3); break;
			case "c4": startUp.selectPosition(nextPosition4); break;
			} 
			
		}
		
	}
}
