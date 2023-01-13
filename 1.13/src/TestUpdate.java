import utils.JdbsUtils;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestUpdate {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection=null;
        PreparedStatement preparedstatement=null;
        ResultSet resultSet=null;
        Statement statement=null;
        System.out.println("请按顺序输入更新数据");
        System.out.println("打算更改的id");
        int id =scanner.nextInt();
        System.out.println("name");
        String newName=scanner.next();
        System.out.println("sex");
        String newSex=scanner.next();
        System.out.println("age");
        int newAge=scanner.nextInt();
        System.out.println("classid");
        int newstudentclass=scanner.nextInt();
        try {
            connection = JdbsUtils.getConnection();
            String sql1="set foreign_key_checks  =0 ";//关闭外链，否则无法使用
            statement=connection.createStatement();
            statement.executeUpdate(sql1);
            String sql2="UPDATE `student`SET `name`=?,`sex`=?,`age`=?,`classid`=? WHERE id=? ";
            preparedstatement = connection.prepareStatement(sql2);
            preparedstatement.setString(1,newName);
            preparedstatement.setString(2,newSex);
            preparedstatement.setInt(3,newAge);
            preparedstatement.setInt(4,newstudentclass);
            preparedstatement.setInt(5,id);
            int i = preparedstatement.executeUpdate();
            String sql3="set foreign_key_checks  =1 ";
            statement.executeUpdate(sql3);
            String sql4="set foreign_key_checks  =1 ";
            statement.executeUpdate(sql4);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbsUtils.release(connection,preparedstatement,resultSet);
            statement.close();
        }

    }
}
