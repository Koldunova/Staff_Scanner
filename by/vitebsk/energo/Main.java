package by.vitebsk.energo;


import by.vitebsk.energo.reader.MyXmlReader;
import by.vitebsk.energo.reader.ReaderFromFirstDB;

public class Main {

    public static void main(String[] args) {

        MyXmlReader.readXmlConfig();
        
        ReaderFromFirstDB.ReadFromDB();
        
        StaticData.closeAllConnections(); // in the end
        StaticData.getLOGGER().closeFiles();// in the end

    }

}
