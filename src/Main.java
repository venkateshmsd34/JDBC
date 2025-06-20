import java.sql.*;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {



                String url = "jdbc:mysql://localhost:3306/demo";
                String dbUser = "root";           // MySQL username
                String dbPwd = "raju";
                // MySQL password

                while(true) {
                    System.out.println("Heyyy buddy can you please choose the options:");
                    System.out.println("1.View the data");
                    System.out.println("2.Create the data");
                    System.out.println("3.Update the data");
                    System.out.println("4.Delete the data");
                    System.out.println("5.Exit");

                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter the options");
                    int options = sc.nextInt();

                    switch (options) {
                        case 1:
                            try {
                                String select = "select * from users";
                                Connection con = DriverManager.getConnection(url, dbUser, dbPwd);
                                PreparedStatement st = con.prepareStatement(select);
                                ResultSet rs = st.executeQuery();
                                System.out.println("ID "+" NAME "+" USERNAME "+" PASSWORD ");
                                while (rs.next()) {
                                    System.out.println(rs.getInt(1) + "   " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
                                }

                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case 2:
                            try {
                                System.out.println("Enter the ID");
                                int id = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Enter the Name");
                                String name = sc.nextLine();
                                System.out.println("Enter the Username");
                                String uname = sc.nextLine();
                                System.out.println("Enter the Password");
                                String pwd = sc.nextLine();
                                String insert = "insert into users values(?,?,?,?)";
                                Connection con = DriverManager.getConnection(url, dbUser, dbPwd);
                                PreparedStatement st = con.prepareStatement(insert);
                                st.setInt(1, id);
                                st.setString(2, name);
                                st.setString(3, uname);
                                st.setString(4, pwd);
                                int rows = st.executeUpdate();
                                if (rows > 0) {
                                    System.out.println("Row Inserted to the table");
                                } else {
                                    System.out.println("Not Inserted");
                                }

                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            break;

                        case 3:
                                System.out.println("Do you want to update");
                                System.out.println("1.Update the name");
                                System.out.println("2.Update the Username");
                                System.out.println("3.Update the Password");
                                System.out.println("4.Exit");
                                int uoptions = sc.nextInt();
                                switch (uoptions){
                                    //updating the name
                                    case 1:
                                        try {
                                            System.out.println("Enter the Id");
                                            int id = sc.nextInt();
                                            sc.nextLine();
                                            System.out.println("Enter the Name");
                                            String name = sc.nextLine();
                                                String updateName = "Update users set name=? where id=?";
                                                Connection con = DriverManager.getConnection(url, dbUser, dbPwd);
                                                PreparedStatement st = con.prepareStatement(updateName);
                                                st.setString(1,name);
                                                st.setInt(2,id);

                                                int rows = st.executeUpdate();
                                                if(rows>0){
                                                    System.out.println("Updated the name");
                                                }
                                                else{
                                                    System.out.println("Not updated");
                                                }
                                            } catch (Exception e) {
                                                throw new RuntimeException(e);
                                            }
                                            break;

                                    //updating the username
                                    case 2:
                                        try {
                                        System.out.println("Enter the Id");
                                        int id = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Enter the userName");
                                        String uname = sc.nextLine();
                                        String updateUserName = "Update users set username=? where id=?";
                                        Connection con = DriverManager.getConnection(url, dbUser, dbPwd);
                                        PreparedStatement st = con.prepareStatement(updateUserName);
                                        st.setString(1,uname);
                                        st.setInt(2,id);

                                        int rows = st.executeUpdate();
                                        if(rows>0){
                                            System.out.println("Updated the username");
                                        }
                                        else{
                                            System.out.println("Not updated");
                                        }
                                    } catch (Exception e) {
                                            throw new RuntimeException(e);
                                        }
                                    break;

                                        //updating the password
                                    case 3:
                                        try {
                                            System.out.println("Enter the Id");
                                            int id = sc.nextInt();
                                            sc.nextLine();
                                            System.out.println("Enter the Password");
                                            String pwd = sc.nextLine();
                                            String updatePassword = "Update users set password=? where id=?";
                                            Connection con = DriverManager.getConnection(url, dbUser, dbPwd);
                                            PreparedStatement st = con.prepareStatement(updatePassword);
                                            st.setString(1,pwd);
                                            st.setInt(2,id);

                                            int rows = st.executeUpdate();
                                            if(rows>0){
                                                System.out.println("Updated the password");
                                            }
                                            else{
                                                System.out.println("Not updated");
                                            }
                                        } catch (Exception e) {
                                            throw new RuntimeException(e);
                                        }
                                        break;
                                    case 4:exit(0);
                                    break;
                                }

                        case 4:
                            try{
                                System.out.println("Enter the Id");
                                int id = sc.nextInt();
                                sc.nextLine();
                                String delete = "delete from users where id=?";
                                Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
                                PreparedStatement st = con.prepareStatement(delete);
                                st.setInt(1,id);
                                int rows = st.executeUpdate();
                                if(rows>0){
                                    System.out.println("Deleted the row");
                                }
                                else {
                                    System.out.println("Not deleted");
                                }
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 5:
                            System.out.println("Thanks for using the app!");
                            exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice! Try again.");
                    }
                }



    }
        }

