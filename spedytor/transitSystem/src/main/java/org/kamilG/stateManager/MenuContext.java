package org.kamilG.stateManager;

import java.util.Scanner;
import org.kamilG.Facade;

public class MenuContext {

  private MenuState currentState;
  private Scanner scanner;
  private Facade facade;

  public MenuContext(MenuState initialState, Scanner scanner) {
    this.currentState = initialState;
    this.scanner = scanner;
  }

  public void setCurrentState(MenuState newState) {
    this.currentState = newState;
  }

  public MenuState getCurrentState() {
    return currentState;
  }

  public Scanner getScanner() {
    return scanner;
  }

  public void handle() {
    currentState.handle(this);
  }

  public Facade getFacade() {
    return facade;
  }

}
