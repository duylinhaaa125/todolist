package todolist;
import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class QuanLy {
	private ArrayList<Task> danhSach;

	public QuanLy() {
		this.danhSach = new ArrayList<Task>();
	}

	public QuanLy(ArrayList<Task> danhSach) {
		this.danhSach = danhSach;
	}

	public void setDanhSach(ArrayList<Task> danhSach) {
		this.danhSach = danhSach;
	}
	
	
	public ArrayList<Task> getDanhSach() {
		return danhSach;
	}

	public void taskList() {
		for (Task task : danhSach) {
			System.out.println(task);
		}
	}

	public void inputTask(Task tk) {
		this.danhSach.add(tk);
	}

	public boolean deleteTask(Task tk) {
		return this.danhSach.remove(tk);
	}

	

}
