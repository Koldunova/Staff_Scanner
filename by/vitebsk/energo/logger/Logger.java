package by.vitebsk.energo.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import by.vitebsk.energo.StaticData;

public class Logger {
    private final String tailError = "_Log_Error.txt";
    private final String tailSimple = "_Log_Simple.txt";

    private java.io.FileWriter errorFile;
    private java.io.FileWriter simpleFile;

    // need files

    private static String dateLog;
    static {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
        dateLog = formatForDateNow.format(new Date()).toString();
    }

    public Logger() {
        String errorNameFile = StaticData.getPATH_LOG() + "/" + dateLog.concat(tailError);
        String simpleNameFile = StaticData.getPATH_LOG() + "/" + dateLog.concat(tailSimple);
        try {
            errorFile = new FileWriter(errorNameFile);
            simpleFile = new FileWriter(simpleNameFile);
        } catch (IOException e) {
            StaticData.setExceptionExist(true);
            e.printStackTrace();
        }
    }

    public void writeLine(boolean isError, String mes) {
        if (!StaticData.isExceptionExist()) {
            if (isError)
                writeError(mes);
            else
                writeMes(mes);
        }else {
            System.out.println("Exception exist");
        }
    }

    private void writeError(String mes) {
        try {
            errorFile.write(mes+"\n");
        } catch (IOException e) {
            StaticData.setExceptionExist(true);
            e.printStackTrace();
        }
        StaticData.setExceptionExist(true);
    }

    private void writeMes(String mes) {
        try {
            simpleFile.write(mes+"\n");
        } catch (IOException e) {
            StaticData.setExceptionExist(true);
            e.printStackTrace();
        }
    }

    public void closeFiles() {
        try {
            errorFile.close();
            simpleFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
