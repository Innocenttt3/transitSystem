package org.kamilG.stateManager;

public abstract class State {
  public abstract void handle(Application app, int choice);
}
