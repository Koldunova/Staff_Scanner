package by.vitebsk.energo.entity;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.vitebsk.energo.StaticData;
import by.vitebsk.energo.dataBase.DbDao;

public class Worker implements DbDao {
    private String WName;
    private int id;
    private int otdId;
    private int uchId;
    private int tabnum;
    private String surname;
    private String patronymic;
    private String post;
    private int idPost;
    private String phone;
    private String registration;
    private int status;
    private Date birth;
    private Date editDate;
    private byte[] photo;

    public Worker() {
        super();
        //default value
        this.WName = "";
        this.id = 0;
        this.otdId = 0;
        this.uchId = 0;
        this.tabnum = 0;
        this.surname = "";
        this.patronymic = "";
        this.post = "";
        this.idPost = 0;
        this.phone = "";
        this.registration = "";
        this.status = 0;
        this.birth = new Date(Long.MIN_VALUE);
        this.editDate = new Date(Long.MIN_VALUE);
        this.photo = new byte[0];
    }

    @Override
    public void writeToDb() {
        try {
            
            final String SQL = "EXEC    @return_value = [dbo].[InsertNewWorker]\r\n" + 
                    "@tabNum = ?, " + 
                    "@surname = ?, " + 
                    "@name = ?, " + 
                    "@patronymic = ?, " + 
                    "@post = ?, " + 
                    "@phone = ?, " + 
                    "@dateOfBirth = ?, " + 
                    "@registration = ?, " + 
                    "@postCode = ?, " + 
                    "@workerID = ?, " + 
                    "@uchId = ?, " + 
                    "@otdid = ?, " + 
                    "@status = ?, " + 
                    "@editDate = ?, " + 
                    "@photo = ?";
            
            PreparedStatement  statement = StaticData.getCONNECTION_RESIPIENT().getConnection().prepareStatement(SQL);
            
            statement.setInt(1, tabnum);
            statement.setString(2, surname);
            statement.setString(3, WName);
            statement.setString(4, patronymic);
            statement.setString(5, post);
            statement.setString(6, phone);
            statement.setDate(7, birth);
            statement.setString(8, registration);
            statement.setInt(9, idPost);
            statement.setInt(10, id);
            statement.setInt(11, uchId);
            statement.setInt(12, otdId);
            statement.setInt(13, status);
            statement.setDate(14, editDate);
            statement.setBytes(15, photo);
            
            statement.execute();

            
        } catch (SQLException e) {
            StaticData.setExceptionExist(true);
            StaticData.getLOGGER().writeLine(true, "Exception while write  -- " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getWName() {
        return WName;
    }

    public void setWName(String wName) {
        WName = wName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOtdId() {
        return otdId;
    }

    public void setOtdId(int otdId) {
        this.otdId = otdId;
    }

    public int getUchId() {
        return uchId;
    }

    public void setUchId(int uchId) {
        this.uchId = uchId;
    }

    public int getTabnum() {
        return tabnum;
    }

    public void setTabnum(int tabnum) {
        this.tabnum = tabnum;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

}
