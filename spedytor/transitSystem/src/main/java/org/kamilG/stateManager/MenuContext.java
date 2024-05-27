package org.kamilG.stateManager;

import java.util.Scanner;
import org.kamilG.Facade;

public class MenuContext {
  private MenuState currentState;
  private Scanner scanner;
  private Facade facade;

  public MenuContext(
      MenuState initialState,
      Scanner scanner,
      Facade facade) { // Adjust the constructor to accept a facade
    this.currentState = initialState;
    this.scanner = scanner;
    this.facade = facade;
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

  public Facade getFacade() {
    return facade;
  }

  public void handle() {
    currentState.handle(this);
  }
}
