package jp.engawa.ondo.calendar;

public class Week {
	private int week_of_year;
	
	private Day[] days;

	public Week(){}
	public Week(int week_of_year) {
		this.week_of_year = week_of_year;
	}
	
	public Day find(String ymd) {
		if(ymd == null) return null;
		if(this.days == null) return null;
		for(Day d:days) {
			if(ymd.equals(d.getYmd())) {
				return d;
			}
		}
		return null;
	}
	protected void add(String ymd) {
		Day d = new Day(ymd);
		this.add(d);
	}
	protected void adjust() {
		Day[] arr = new Day[7];
		for(Day d:days) {
			int yobi = d.getYobi();
			int idx = yobi -1;
			if(idx >= 0 && idx<7) {
				arr[idx] = d;
			}
		}
		for(int ii=0;ii<arr.length;ii++) {
			if(arr[ii] == null) {
				arr[ii] = new Day();
				arr[ii].setCurrent(false);
			}
		}
		this.days = arr;
	}
	public String getText() {
		StringBuilder sb = new StringBuilder();
		sb.append("<tr>");
		Day[] days = this.getDays();
		for(Day d:days) {
			sb.append(d.getHeader());
		}
		sb.append("</tr>\n");
		sb.append("<tr>");
		for(Day d:days) {
			sb.append(d.getText());
		}
		sb.append("</tr>\n");
		return sb.toString();
	}
	public void clear() {
		Day[] days = this.getDays();
		for(Day d:days) {
			d.clear();
		}
	}
	
	protected void add(Day item) {
		if (this.days == null) {
			this.days = new Day[1];
			this.days[0] = item;
		} else {
			int len = this.days.length;
			Day[] arr = new Day[len + 1];
			System.arraycopy(this.days, 0, arr, 0, len);
			arr[len] = item;
			this.days = arr;
		}
	}

	public Day[] getDays() {
		if(this.days == null) return new Day[0];
		return days;
	}

	public void setDays(Day[] days) {
		this.days = days;
	}
	public int getWeek_of_year() {
		return week_of_year;
	}
	public void setWeek_of_year(int week_of_year) {
		this.week_of_year = week_of_year;
	}
}
