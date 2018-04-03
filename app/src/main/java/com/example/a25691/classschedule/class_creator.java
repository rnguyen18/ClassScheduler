package com.example.a25691.classschedule;

import java.util.ArrayList;

public class class_creator {

    private static ArrayList<class_creator> classes = new ArrayList<>();

    private String classname, professor, location, sM, eM, tv;
    // Sun - Mon
    private boolean[] weekly;

    private int sHour,sMinute, eHour, eMinute;

   static public String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};


    class_creator(String classnameIn, String professorIn, String locationIn, boolean[] weeklyIn, int sHourIn,int  sMinuteIn,int eHourIn,int eMinuteIn) {

        classname = classnameIn;
        professor = professorIn;
        location = locationIn;
        weekly = weeklyIn;
        sHour = sHourIn;
        sMinute = sMinuteIn;
        eHour = eHourIn;
        eMinute = eMinuteIn;

        classes.add(this);

    }

    public String getClassName() {
        return classname;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String in) {
        professor = in;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String in) {
        location = in;
    }

    public boolean[] getDays() {
        return weekly;
    }

    public void setDays(boolean[] in) {
        weekly = in;
    }

    public String getTimePeriod() {
        return Integer.toString(sHour) + ":" + Integer.toString(sMinute) + " - " + Integer.toString(eHour) + ":" + Integer.toString(eMinute);
    }

    public int getSHour() {
        return  sHour;
    }

    public void setSHour(int in) {
        sHour = in;
    }

    public int getSMinute() {
        return sMinute;
    }

    public void setSMinute(int in) {
        sMinute = in;
    }

    public int getEHour() {
        return eHour;
    }

    public void setEHour(int in) {
        eHour = in;
    }

    public int getEMinute() {
        return eMinute;
    }

    public void setEMinutes(int in) {
        eMinute = in;
    }

    static public int getClassAmount() {
        return classes.size();
    }

    static public ArrayList<class_creator> getClasses() {
        return classes;
    }

    static public class_creator getClassFromName(String title) {
        for (class_creator classR: classes) {
            class_creator classReturn = classR;
            if (classReturn.getClassName().equals(title)) {
                return classReturn;
            }
        }

        return null;
    }

    static public void deleteClass(class_creator classHere) {
        /*class_creator[] newclasses = new class_creator[classes.length - 1];
        int newInt = 0;
        for (int i = 0; i < classes.length; i++) {
            class_creator classReturn = classes[i];
            if (!classReturn.getClassName().equals(classHere.getClassName())) {
                newclasses[i] = classReturn;
            } else {
                newInt = i + 1;
                break;
            }
        }

        if (newInt < classes.length) {
            for (int v = newInt; newInt < classes.length; v++) {
                class_creator classReturn = classes[v];
                newclasses[v - 1] = classReturn;
            }
        }
        classes = new class_creator[newclasses.length];
        for (int m=0; m<newclasses.length;m++) {
            classes[m] = newclasses[m];
        }
        classamount = classes.length;
        */
        if (classes.contains(classHere)) {
            int index = classes.indexOf(classHere);
            classes.remove(index);
        }
    }
}
