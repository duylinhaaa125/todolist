package todolist;
import java.nio.charset.IllegalCharsetNameException;
import java.sql.ResultSetMetaData;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class Test {
	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		QuanLy ql = new QuanLy();
		int luaChon = 0;

		do {
			System.out.println("Linh ngao nhu c ho");
			System.out.println("MENU ---------- ");
			System.out.println("Vui lòng chọn chức năng: ");
			System.out.println("1.	Task list.\n" + "2.	Input Task.\n" + "3.	Edit Task.\n" + "4.	Delete Task.\n");

			luaChon = sc.nextInt();
			sc.nextLine();

			if (luaChon == 1) {
				ql.taskList();
			} else if (luaChon == 2) {
				System.out.println("STT: ");
				String stt = sc.nextLine();
				System.out.println("Task name: ");
				String name = sc.nextLine();
				System.out.println("Input start Date: "); // 17/11/2022
				sc.nextLine();
				System.out.println("Day: ");
				String sday = sc.nextLine();
				System.out.println("Month: ");
				String smonth = sc.nextLine();
				System.out.println("Year: ");
				String syear = sc.nextLine();
				String sDate = sday + "/" + smonth + "/" + syear;
				Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
				// d = 17
				// m = 11
				// y = 2022

				// String sDay = d + '/' + m '/' + y; -->17/11/2022

				// Date day1 = 16/11/2022;
				// Date day2 = 17/11/2022'

				// day1.before(day2) --> true;
				// day1.after(day2) --> fasle
				// Date now = new Date();

				Date now = new Date();

				System.out.println("Input End Date: ");
				System.out.println("Day: ");
				String eday = sc.nextLine();
				System.out.println("Month: ");
				String emonth = sc.nextLine();
				System.out.println("Year: ");
				String eyear = sc.nextLine();

				String eDate = eday + "/" + emonth + "/" + eyear;
				Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(eDate);

				String status = null;

				if (now.before(startDate)) {
					status = "not start";
				} else if (now.before(endDate) && now.after(startDate)) {
					status = "In Progress";
				} else if (now.after(endDate)) {
					status = "Done";
				}

				Task tk = new Task(stt, name, startDate, endDate, status);
				ql.inputTask(tk);
				sc.nextLine();

			} else if (luaChon == 3) {
				ArrayList<Task> danhsach = ql.getDanhSach();
				ql.taskList();
				System.out.println("Input STT task: ");
				String userInputSTT = sc.nextLine();

				// task id = 1
				// muc can sua = 1
				// --> sua ten

				System.out.println("Muc can sua ");
				System.out.println("1.	Edit name.\n" + "2.	Edit start date.\n" + "3.	Edit end date.\n");

				int userInputMucCanSua = sc.nextInt();
				sc.nextLine();
				if (userInputMucCanSua == 1) {
					System.out.println("New name : ");
					String newName = sc.nextLine();
					for (Task task : danhsach) {
						if (task.getStt().equalsIgnoreCase(userInputSTT)) {
							task.setName(newName);
						}
					}

				} else if (userInputMucCanSua == 2) {
					System.out.println("Day: ");
					String sday = sc.nextLine();
					System.out.println("Month: ");
					String smonth = sc.nextLine();
					System.out.println("Year: ");
					String syear = sc.nextLine();
					String sDate = sday + "/" + smonth + "/" + syear;
					Date newStartDate = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
					for (Task task : danhsach) {
						if (task.getStt().equalsIgnoreCase(userInputSTT)) {
							task.setStartDate(newStartDate);
							Date now = new Date();
							Date endDate = task.getEndDate();
							String newStatus = null;
							if (now.before(newStartDate)) {
								newStatus = "not start";
							} else if (now.before(endDate) && now.after(newStartDate)) {
								newStatus = "In Progress";
							} else if (now.after(endDate)) {
								newStatus = "Done";
							}
							task.setStatus(newStatus);
						}

					}
				} else if (userInputMucCanSua == 3) {
					System.out.println("Day: ");
					String eday = sc.nextLine();
					System.out.println("Month: ");
					String emonth = sc.nextLine();
					System.out.println("Year: ");
					String eyear = sc.nextLine();

					String eDate = eday + "/" + emonth + "/" + eyear;
					Date newEndDate = new SimpleDateFormat("dd/MM/yyyy").parse(eDate);

					for (Task task : danhsach) {
						if (task.getStt().equalsIgnoreCase(userInputSTT)) {
							task.setEndDate(newEndDate);
							Date now = new Date();
							Date startDate = task.getStartDate();
							String newStatus = null;
							if (now.before(startDate)) {
								newStatus = "not start";
							} else if (now.before(newEndDate) && now.after(startDate)) {
								newStatus = "In Progress";
							} else if (now.after(newEndDate)) {
								newStatus = "Done";
							}
							task.setStatus(newStatus);

						}
					}

				}

//				
//				for (Task task : danhsach) {
//					if(userInput.equalsIgnoreCase(stt)) {
//						System.out.println("Muc can sua ");
//						System.out.println(
//								  "1.	Edit name.\n"
//								+ "2.	Edit start date.\n"
//								+ "3.	Edit end date.\n");
//						num = sc.nextInt();
//						if(num == 1) {
//							System.out.println("New name : " );
//							newName = sc.nextLine();
//						}else if(num == 2) {
//							System.out.println("Day: " );
//							String sday = sc.nextLine();
//							System.out.println("Month: ");
//							String smonth = sc.nextLine();
//							System.out.println("Year: ");
//							String syear = sc.nextLine();
//							String sDate = sday + "/" + smonth + "/" + syear;
//					        Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);	
//						}else if(num == 3) {
//							System.out.println("Input End Date: ");
//							System.out.println("Day: " );
//							String eday = sc.nextLine();
//							System.out.println("Month: ");
//							String emonth = sc.nextLine();
//							System.out.println("Year: ");
//							String eyear = sc.nextLine();
//							
//							String eDate = eday + "/" + emonth + "/" + eyear;
//					        Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(eDate);		
//						}
//						
//					}
//				}

			} else if (luaChon == 4) {
				ArrayList<Task> danhsach = ql.getDanhSach(); 
				System.out.println("STT: ");
				String userInputSTT = sc.nextLine();
				for (Iterator<Task> taskArrayList = danhsach.iterator(); taskArrayList.hasNext();) {
					Task task = taskArrayList.next();
					if (task.getStt().equalsIgnoreCase(userInputSTT)) {
						taskArrayList.remove();
					}

				}
			}

		} while (luaChon != 0);
	}

}
