package todolist;
import java.util.Date;
import java.util.Objects;

public class Task  {
	private String stt;
	private String name;
	private Date startDate;
	private Date endDate;
	private String status;
	
	public Task(String stt) {
		this.stt = stt;
	}

	public Task(String stt, String name, Date startDate, Date endDate, String status) {
		this.stt = stt;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	public String getStt() {
		return stt;
	}

	public void setStt(String stt) {
		this.stt = stt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [stt=" + stt + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", status="
				+ status + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}