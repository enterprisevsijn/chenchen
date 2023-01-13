import utils.JdbsUtils;

import javax.naming.Name;
import java.sql.*;
import java.util.Scanner;
public class TestSelect {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection=null;
        PreparedStatement preparedstatement=null;
        ResultSet resultSet=null;
        Statement statement=null;
        System.out.println("请按顺序输入待查的学生id");
        System.out.println("id");
        int newId =scanner.nextInt();
        try {
            connection = JdbsUtils.getConnection();
            String sql2="SELECT*FROM `student`WHERE `id`=? ";
            preparedstatement = connection.prepareStatement(sql2);
            preparedstatement.setInt(1,newId);
            resultSet = preparedstatement.executeQuery();
            if(resultSet.next()){
                System.out.println("name="+resultSet.getString("name"));
                System.out.println("sex="+resultSet.getString("sex"));
                System.out.println("age="+resultSet.getString("age"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            JdbsUtils.release(connection,preparedstatement,resultSet);
            statement.close();
        }

    }
}
