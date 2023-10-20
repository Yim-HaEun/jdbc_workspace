package com.kh.dtoExam;

public class sanrioDTO {
	//필드 멤버 변수 작성
	private int sId;
	private String sName;
	private String sCharacter;
	private String sColor;
	private String sKind;
	
	//기본 생성자 
		public sanrioDTO() {
			
		}
	//파라미터 값을 받을 생성자
	public sanrioDTO(int sId, String sName, String sCharacter, String sColor, String sKind) {
		this.sId = sId;
		this.sName = sName;
		this.sCharacter = sCharacter;
		this.sColor =sColor;
		this.sKind = sKind;
	}
	
	
	
	
	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsCharacter() {
		return sCharacter;
	}

	public void setsCharacter(String sCharacter) {
		this.sCharacter = sCharacter;
	}

	public String getsColor() {
		return sColor;
	}

	public void setsColor(String sColor) {
		this.sColor = sColor;
	}

	public String getsKind() {
		return sKind;
	}

	public void setsKind(String sKind) {
		this.sKind = sKind;
	}

	//@Override를 활용한 toString 메서드 추가
	@Override
	public String toString() {
		return "sanrioDTO" + sName;
	}
}
