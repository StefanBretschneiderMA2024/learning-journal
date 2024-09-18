package mischok.learning_journal;

public class utility {

    public void readTable (String table){}
    public void editObject (String table){}
    public void createObject (String table){}
    public void deleteObject(String table){}
    //basically CRUD methods, supposed to be variable for all classes by writing the class name inside the given parameter
    // unsure if this works, or is even nessecary,  since the system was thought of with jdbc/sql queries in mind

    public void createConnection(){}
    // again, not sure if still needed

    public boolean validInput(String input){
        //typical input validation, switch-case?
        // could be made variable for different types of validation like email, name or what have you

        boolean trueOrFalse = false;
        return trueOrFalse;
    }
    public void login(){}
    public void logout(){}
    public void mainMenuUser(){}
    public void mainMenuAdmin(){}
}
