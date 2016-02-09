package MU.dumy.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class LoginBase {
String username;
String userpassword;
String security_question;
String security_answer;
PreparedStatement ps;
ResultSet rs;
Connection conn;
}
