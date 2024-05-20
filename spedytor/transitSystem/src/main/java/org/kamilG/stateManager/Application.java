package org.kamilG.stateManager;

public class Application {
  private State currentState;

  public Application(State initialState) {
    this.currentState = initialState;
  }

  public void setState(State newState) {
    this.currentState = newState;
  }

  public void handleInput(int choice) {
    currentState.handle(this, choice);
  }
}
