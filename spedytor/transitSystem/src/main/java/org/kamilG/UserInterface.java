package org.kamilG;

import java.util.Scanner;
import org.kamilG.stateManager.MainMenuState;
import org.kamilG.stateManager.MenuContext;
import org.kamilG.stateManager.MenuState;

public class UserInterface {

  public static void main(String[] args) {
    Facade facade = new Facade();

    MenuState initialState = new MainMenuState();

    MenuContext menuContext = new MenuContext(initialState, new Scanner(System.in), facade);

    while (menuContext.getCurrentState() != null) {
      menuContext.handle();
    }

    menuContext.getScanner().close();
  }
}
