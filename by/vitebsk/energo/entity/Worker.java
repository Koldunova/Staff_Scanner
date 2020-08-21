package by.vitebsk.energo.entity;

public class Worker {
    //copy structure from DB
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    
    //query for insert to DB with help of stored procedure
}
