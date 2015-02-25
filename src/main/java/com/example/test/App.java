package com.example.test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.List;

public class App 
{
    List<String> names;

    public App(List<String> names){
        this.names = names;
    }

    public ArrayList<String> createGroup(String targetName) throws Exception {
        ArrayList<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
        ArrayList<String> tmpGroup = new ArrayList<String>();
        for (String name: this.names) {
            tmpGroup.add(name);
            if (tmpGroup.size() == 3) {
                groups.add(tmpGroup);
                tmpGroup = new ArrayList<String>();
            }
        }

        for (ArrayList<String> group : groups) {
            if (group.contains(targetName)) {
                return group;
            }
        }

        throw new Exception("target name not found");
    }

    public static void main( String[] args ) throws Exception {
        String targetName = "mbichay@csumb.edu";
        long assignmentNumber = Long.valueOf(args[1]);

        List<String> names = new ArrayList<String>();
        names.add("mbichay@csumb.edu");
        names.add("mariangarcia@csumb.edu");
        names.add("lgarciajimenez@csumb.edu");
        names.add("savillavicencio@csumb.edu");
        names.add("mhernandezbucio@csumb.edu");
        names.add("asorto@csumb.edu");
        names.add("chmartinez@csumb.edu");
        names.add("sathya");
        names.add("katie");

        Collections.shuffle(names, new Random(assignmentNumber));

        App app = new App(names);

        System.out.print(app.createGroup(targetName));
    }
}


