package edu.ssafy.st2;
//날씨 정보 클래스
public class Weather {
	private String hour;
	private String temp;
	private String wfKor;
	private String reh;

	public Weather() {
		super();
	}
	
	public Weather(String hour, String temp, String wfKor, String reh) {
		super();
		setHour(hour);
		setTemp(temp);
		setWfKor(wfKor);
		setReh(reh);
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getWfKor() {
		return wfKor;
	}

	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}

	public String getReh() {
		return reh;
	}

	public void setReh(String reh) {
		this.reh = reh;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("시간: ");
		builder.append(hour + "시");
		builder.append("     ");
		builder.append("온도: ");
		builder.append(temp + "도");
		builder.append("     ");
		builder.append("구름양: ");
		builder.append(wfKor);
		builder.append("     ");
		builder.append("습도: ");
		builder.append(reh + "%");
		return builder.toString();
	}
}
