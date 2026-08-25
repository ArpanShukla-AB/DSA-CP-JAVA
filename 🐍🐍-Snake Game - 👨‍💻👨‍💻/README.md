# Snake Game

A desktop Snake Game built with Java Swing, Java AWT, and object-oriented design.

The current version uses a bright light theme with a responsive board, polished menu controls, and optional gameplay modifiers.

## Project Structure

```text
SnakeGame/
├── src/
│   ├── Main.java
│   ├── GameFrame.java
│   ├── GamePanel.java
│   ├── Snake.java
│   ├── Food.java
│   └── ScoreManager.java
├── assets/
│   ├── sounds/
│   └── images/
└── README.md
```

## Setup Instructions

Compile and run from the `SnakeGame` folder:

```bash
javac -d out src/*.java
java -cp out Main
```

## Controls

- Arrow Keys or WASD: move the snake
- P: pause or resume
- M: mute or unmute sound effects
- Space: restart after game over
- Escape: return to main menu
- Restart Game: starts a new run after game over
- Main Menu: returns to the menu after game over

## Features

- Light theme main menu with difficulty selection
- Optional Wrap Walls mode
- Optional Obstacles mode
- Optional Sound mode
- Easy, Medium, and Hard speed presets
- Random food generation
- Temporary bonus food every 7 normal foods
- Score, high score, level, and food tracking
- Wall, obstacle, and self collision detection
- Runtime high score system
- Speed increases every 5 foods eaten
- Pause and resume support
- Game-over flash effect
- Generated food and game-over sound effects

## Class-By-Class Explanation

### Main.java

Launches the application on the Swing Event Dispatch Thread and creates the game window.

### GameFrame.java

Creates the `JFrame`, main menu, instructions screen, difficulty selector, and screen navigation.

### GamePanel.java

Handles active gameplay, rendering, keyboard controls, Swing timers, collision checks, pause state, game-over state, sound effects, and restart/menu actions.

It also manages optional wall wrapping, obstacles, bonus food, mute state, and the light board UI.

### Snake.java

Stores the snake body as grid points, handles movement, direction changes, growth, and self-collision checks.

### Food.java

Generates food at random unoccupied grid positions.

### ScoreManager.java

Tracks score, foods eaten, current level, and runtime high score.

## Game Flow Diagram

```text
Application Start
      |
      v
Main Menu -----> Instructions
   |                 |
   | Start Game      | Back
   v                 v
Difficulty Selected -> Gameplay
                         |
                         v
                  Move Snake Each Tick
                         |
             +-----------+-----------+
             |                       |
             v                       v
        Eat Food?                Collision?
             |                       |
        Grow + Score + Level         v
             |                  Game Over
             |                       |
             +----------< Restart / Main Menu
```

## Final Testing

The project compiles with:

```bash
javac -d out src/*.java
```

Run the game with:

```bash
java -cp out Main
```

## Future Enhancement Ideas

- Persistent high score saved to a local file
- User-selectable snake skins
- Obstacles and bonus food
- Background music using bundled audio files
- Local multiplayer race mode
- Animated particles when food is eaten
