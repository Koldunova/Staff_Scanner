package by.vitebsk.energo;

import by.vitebsk.energo.reader.MyXmlReader;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hi world");

        MyXmlReader.readXmlConfig();
        
        
        
        StaticData.closeAllConnections(); // in the end
        StaticData.getLOGGER().closeFiles();// in the end

    }

}
