#!/bin/bash
javac -d out src/main/*.java src/main/menus/*.java
java -cp out main.menus.MainMenu 