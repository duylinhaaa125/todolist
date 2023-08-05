package todolist;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	private static String url = "jdbc:mySQL://localhost:3306/to_do_list";
	private static String user = "root";
	private static String password = "@Linh2169";
	public static void main(String[] args) {
		
		try {
			//B1: Tao connection (URL, Username, Password)
			Connection con = DriverManager.getConnection(url, user, password);
			
			//B2: Tao cau truy van
			
			String sql = "insert into to_do_list.todolist(TaskName, StartDate, EndDate, TaskStatus) value (\"An va choi\", \"2022-12-01\", \"2022-12-20\", \"In progress\")";
			
			//B3: Thuc thi cau truy van
			Statement statement = con.createStatement();
			int soHangThayDoi = statement.executeUpdate(sql);
			
			//B4: Xu ly du lieu
			if (soHangThayDoi > 0) {
				System.out.println("insert thanh cong");
			}else {
				System.out.println("insert that bai ");
			}
			
			//B5: Dong connection
			
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Co loi xay ra");
			e.printStackTrace();
		}
		
		
		
	}
}
