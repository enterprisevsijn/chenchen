import utils.JdbsUtils;

import java.sql.*;
import java.util.Scanner;
import utils.JdbsUtils;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestDelete {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection=null;
        PreparedStatement preparedstatement=null;
        ResultSet resultSet=null;
        Statement statement=null;
        System.out.println("请输入删除学生的id");
        System.out.println("id=");
        int newId =scanner.nextInt();
        try {
            connection = JdbsUtils.getConnection();
            String sql1="set foreign_key_checks  =0 ";//关闭外链，否则无法使用
            statement=connection.createStatement();
            statement.executeUpdate(sql1);
            String sql2="DELETE FROM`student` WHERE `id`=? ";
            preparedstatement = connection.prepareStatement(sql2);
            preparedstatement.setInt(1,newId);
            int i = preparedstatement.executeUpdate();
            String sql3="set foreign_key_checks  =1 ";
            statement.executeUpdate(sql3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            JdbsUtils.release(connection,preparedstatement,resultSet);
            statement.close();
        }

    }
}
