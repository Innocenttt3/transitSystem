package org.kamilG;

import java.util.Scanner;
import org.kamilG.stateManager.MainMenuState;
import org.kamilG.stateManager.MenuContext;

public class UserInterface {

  public static void main(String[] args) {
    MenuContext context = new MenuContext(new MainMenuState(), new Scanner(System.in));

    while (context.getCurrentState() != null) {
      context.handle();
    }
  }
}
