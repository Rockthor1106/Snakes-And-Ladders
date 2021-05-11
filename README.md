# Snakes and Ladders 

## About 

* This is a little modified version of the clasical game Snakes and Ladders. It allows the players to play through the console, 
it has a maximum of 9 players and they can arrange the game board as they please.
* Project status: working

## Table of contents


> * [Title](#Snakes-and-Ladders)
>   * [About](#about)
>   * [Table of contents](#table-of-contents)
>   * [How to play](#how-to-play)
>     * [Game commands](#game-commands)
>     * [Winner](#how-to-win)
>     * [Screenshots](#screenshots)
>   * [Code](#code)
>     * [Description](#description)
>   * [Resources (Documentation and other links)](#resources-documentation-and-other-links)
>   * [Contributors](#contributors)

## How to play?

The game is controlled by the console, it starts with a menu with 3 options:
* Play
* Show best players
* Exit

When the Play option is selected, the game starts and it asks for the neccessary data to start, which is:
* Number of rows (for the game board)
* Number of columns (for the game board, as well)
* Number of snakes
* Number of ladders 
* Number of players / Symbols for each player (one of: * ! O X % $ # + &) 

All of this setups have to be inputted in one line, e.g. 5 4 3 3 %&# or 5 4 3 3 3

As it can be seen, there are two examples, one for selecting the symbol that identifies each player manually, 
and the second when it is going to be assigned by the system. If the entry is correct and possible to create (ladders and snakes fit the board), the game begins!

### Game commands

Once the game has started, the game board will be shown. In each turn, the board will be shown with the position of each player and the snakes and ladders. 
It can be controlled with these commands:

* line break: it's used by each user to throw the dice, the system will give the result and it will move the player according to the result obtained. 
If the new position is the begginning of a ladder or a snake, then the player will be carried untill the other side!
* num + line break: the system will show the players the initial game board, and it will wait another line break to show the current state of the game
* simul+ line break: this will turn the simulation mode on, which consists in showing each movement that has been made by the players in the board, 
showing each state of the board with a pause of 2 seconds.
* menu + line break: the game ends immediately, without a winner and the main menu is shown. 

Each time that the system needs a line break, it will send a message notifying it. 

### How to win

The first player to achieve the last cell of the game board (number of rows x number of columns) is the winner! The system will ask for the nickname of the player and will calculate
their score. After this, the main menu will be shown.

### Screenshots

## Code

[![Build Status](https://qa.nuxeo.org/jenkins/buildStatus/icon?job=/nuxeo/addons_nuxeo-sample-project-master)](https://github.com/Rockthor1106/Snakes-And-Ladders/tree/master/)

### Description

* Language: Java 
* IDE: Eclipse 
* Language version: 8

## Resources (Documentation and other links)

* Class diagram: (https://github.com/Rockthor1106/Snakes-And-Ladders/blob/master/docs/Snakes_And_Ladders_Class_Diagram.jpg)
* Requirements elicitation (Spanish): (https://github.com/Rockthor1106/Snakes-And-Ladders/blob/master/docs/Snakes_And_Ladders_RequirementsElicitation.docx)

## Contributors

* Jhan Carlos Carvajal 
* Danilo Erazo Meza https://github.com/DaniloErazo

