package by.vitebsk.energo;
import by.vitebsk.energo.dataBase.ConnectionDB;
import by.vitebsk.energo.logger.Logger;

public final class StaticData {
    private static ConnectionDB CONNECTION_SENDER;
    private static ConnectionDB CONNECTION_RESIPIENT;
    
    private static String PATH_LOG;
    
    private static Logger LOGGER;
    
    private static boolean isExceptionExist = false;

    public static boolean isExceptionExist() {
        return isExceptionExist;
    }

    public static void setExceptionExist(boolean isExceptionExist) {
        StaticData.isExceptionExist = isExceptionExist;
    }

    public static ConnectionDB getCONNECTION_SENDER() {
        return CONNECTION_SENDER;
    }

    public static void setCONNECTION_SENDER(ConnectionDB cONNECTION_SENDER) {
        CONNECTION_SENDER = cONNECTION_SENDER;
    }

    public static ConnectionDB getCONNECTION_RESIPIENT() {
        return CONNECTION_RESIPIENT;
    }

    public static void setCONNECTION_RESIPIENT(ConnectionDB cONNECTION_RESIPIENT) {
        CONNECTION_RESIPIENT = cONNECTION_RESIPIENT;
    }

    public static String getPATH_LOG() {
        return PATH_LOG;
    }

    public static void setPATH_LOG(String pATH_LOG) {
        PATH_LOG = pATH_LOG;
        LOGGER = new Logger();
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }

    public static void setLOGGER(Logger lOGGER) {
        LOGGER = lOGGER;
    }
    
    public static void closeAllConnections() {
        CONNECTION_RESIPIENT.closeConnection();
        CONNECTION_SENDER.closeConnection();
    }
    
}
