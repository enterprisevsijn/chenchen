import utils.JdbsUtils;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestInsert {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection=null;
        PreparedStatement preparedstatement=null;
        ResultSet resultSet=null;
        Statement statement=null;
        System.out.println("请按顺序输入新生数据");
        System.out.println("id");
        int newId =scanner.nextInt();
        System.out.println("name");
        String newName=scanner.next();
        System.out.println("sex");
        String newSex=scanner.next();
        System.out.println("age");
        int newAge=scanner.nextInt();
        System.out.println("classid");
        int newstudentclass=scanner.nextInt();
        System.out.println("joinin_class_years");
        String string=scanner.next();
        try {
            connection = JdbsUtils.getConnection();

            String sql5="INSERT INTO `class`(`classid`,`studentids`,`joinyear`) VALUE (?,?,?) ";
            preparedstatement = connection.prepareStatement(sql5);
            preparedstatement.setInt(1,newstudentclass);
            preparedstatement.setInt(2,newId);
            preparedstatement.setString(3,string);
            int i1 = preparedstatement.executeUpdate();//class表中classid是唯一索引

            String sql1="set foreign_key_checks  =0 ";//其中student是从表，classid是外键，关闭外链，否则无法使用
            statement=connection.createStatement();
            statement.executeUpdate(sql1);
            String sql2="INSERT INTO `student`(`id`,`name`,`sex`,`age`,`classid`) VALUE (?,?,?,?,?) ";
            preparedstatement = connection.prepareStatement(sql2);
            preparedstatement.setInt(1,newId);
            preparedstatement.setString(2,newName);
            preparedstatement.setString(3,newSex);
            preparedstatement.setInt(4,newAge);
            preparedstatement.setInt(5,newstudentclass);
            int i = preparedstatement.executeUpdate();
            String sql3="set foreign_key_checks  =1 ";
            statement.executeUpdate(sql3);
            String sql4="set foreign_key_checks  =1 ";
            statement.executeUpdate(sql4);





        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            JdbsUtils.release(connection,preparedstatement,resultSet);
            statement.close();
        }

    }
}
