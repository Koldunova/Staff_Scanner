package by.vitebsk.energo.reader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.vitebsk.energo.StaticData;
import by.vitebsk.energo.entity.Worker;

public class ReaderFromFirstDB {
    public static void ReadFromDB() {
        if (!StaticData.isExceptionExist()) {
            try {
                Statement statement = StaticData.getCONNECTION_SENDER().getConnection().createStatement();
                final String SQL = "Select * From office";

                ResultSet resultSet = statement.executeQuery(SQL);

                while (resultSet.next()) {

                    Worker worker = new Worker();

                    worker.setId(resultSet.getInt(1));
                    worker.setOtdId(resultSet.getInt(2));
                    worker.setUchId(resultSet.getInt(3));
                    worker.setTabnum(resultSet.getInt(4));
                    worker.setSurname(resultSet.getString(5));
                    worker.setWName(resultSet.getString(6));
                    worker.setPatronymic(resultSet.getString(7));
                    worker.setPost(resultSet.getString(8));
                    worker.setIdPost(resultSet.getInt(9));
                    worker.setBirth(resultSet.getDate(10));
                    worker.setPhone(resultSet.getString(11));
                    worker.setRegistration(resultSet.getString(12));
                    worker.setStatus(resultSet.getInt(13));
                    worker.setEditDate(resultSet.getDate(14));
                    worker.setPhoto(resultSet.getBytes(15));

                    worker.writeToDb();
                }

                StaticData.getLOGGER().writeLine(false, "Reading and writing end");

            } catch (SQLException e) {
                StaticData.setExceptionExist(true);
                StaticData.getLOGGER().writeLine(true, "Exception while read  -- " + e.getMessage());
                e.printStackTrace();
            }
        }else {
            StaticData.getLOGGER().writeLine(false, "R/W - error exist");
        }
    }
}
