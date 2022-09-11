import java.sql.*;

public class School {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","Arjun@123");

            if(connection != null){
                System.out.println("CONNECTED SUCCESSFULLY");

                Statement st = connection.createStatement();
                boolean flag = st.execute("CREATE TABLE student(name varchar(100) ,rollNo int PRIMARY KEY,marks int,grade varchar(10))");
                if(flag){
                    System.out.println("TABLE NOT CREATED");
                }else System.out.println("TABLE CREATED");
                int row[] = new int[10];
                row[1] = st.executeUpdate("INSERT INTO student values('Arjun',10,99,'A')");
                row[2]= st.executeUpdate("INSERT INTO student values('Ram',11,99,'B')");
                row[3] = st.executeUpdate("INSERT INTO student values('Hari',12,99,'C')");
                row[4] = st.executeUpdate("INSERT INTO student values('Sam',13,99,'A')");
                row[5] = st.executeUpdate("INSERT INTO student values('vaibhav',14,99,'A')");
                row[6] = st.executeUpdate("INSERT INTO student values('Sri',15,99,'A')");
                row[7] = st.executeUpdate("INSERT INTO student values('vishnu',16,99,'B')");
                row[8] = st.executeUpdate("INSERT INTO student values('prasadh',17,99,'A')");
                row[0] = st.executeUpdate("INSERT INTO student values('upender',18,99,'B')");
                row[9] = st.executeUpdate("INSERT INTO student values('sai',19,99,'A')");
                for (int i = 0; i < 10; i++) {
                    if(row[i] ==1 ){
                        System.out.println("Row " + (i+1) + " INSERTED");
                    }else System.out.println("Row NOT INSERTED");
                }
                ResultSet resultSet = st.executeQuery("SELECT * FROM student");
                while (resultSet.next()){
                    System.out.println("NAME = " + resultSet.getString(1));
                    System.out.println("ROLL NUMBER = " + resultSet.getInt(2));
                    System.out.println("MARKS = "+resultSet.getInt(3));
                    System.out.println("GRADE = "+resultSet.getString(4));

                }


            }else System.out.println("NOT CONNECTED");



        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }
    }
}
