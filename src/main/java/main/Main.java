package main;

import entity.Project;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Project> projects = new HashMap<>();
        for(String arg : args){
            switch(arg){
                case "--help":
                case "HELP":
                    //todo
                    //Вывести набор команд CRUD
                    System.out.println("Набор команд CRUD");
                    break;
                case "--CREATE":
                    break;
                case "--DELETE":
                    break;
                case "--EXIT":
                    break;
                default:
                    break;
            }
        }
    }
}
