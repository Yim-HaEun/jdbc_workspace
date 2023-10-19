package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel이라는 클래스를 가져오기 위해 멤버변수로 카페 모델 추가함
	public cafeModel model;
	
	//model 매개변수를 받을 수 있는 생성자를 만들어줘야함
	public cafeView(cafeModel model) {
		this.model = model;
	}
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보를 입력하세요");
		
		System.out.println("상호명: ");
		String name = sc.nextLine();
		
		System.out.println("카페 주소: ");
		String address = sc.nextLine();
	
		System.out.println("카페 연락처 : ");
		String phoneNumber = sc.nextLine();
		
		System.out.println("카페 운영 시간 : ");
		String operatingHours = sc.nextLine();
		
		//카페 모딜에서 insertCafe라는 메서드를 가지고 와야함
		model.insertcafe(name, address, phoneNumber, operatingHours);
		System.out.println("카페가 성공적으로 추가되었습니다.");
		
	}

	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 설명을 업데이트하세요");
		
		System.out.println("수정할 메뉴 설명 : ");
		String description = sc.nextLine();
		
		System.out.print("메뉴 ID : ");
		int menuId = sc.nextInt();
		
		System.out.print("카페 ID : ");
		int cafeId = sc.nextInt();
		
		//model에 있는 UpdateMenu를 가지고와서 사용자가 작성한 수정내용 추가하기
		model.updateMenu(description, menuId, cafeId);
		System.out.println("메뉴 설명이 업데이트되었습니다.");
		
	}
	//사용자가 수정할 운영시간 화면 Scanner 이용해서 만들기
	public void UpdateCafe() {
		Scanner sc = new Scanner(System.in);
	
		System.out.println("카페 ID 입력 :");
		int cafeId = sc.nextInt();
	
		System.out.println("수정할 운영시간: ");
		String OP_hours = sc.next();
		
		
		model.updateCafe(cafeId, OP_hours);
		System.out.println("운영시간이 업데이트되었습니다.");
	}

	public void DeleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페를 삭제하겠습니다.");
		System.out.println("삭제할 카페의 아이디를 입력: ");
		int cafeId = Integer.parseInt(sc.nextLine());
		//두가지방법   int cafeId = sc.nextInt();
		
		model.deleteCafe(cafeId);
		System.out.println("카페가 삭제되었습니다.");
	}

	public void Deletemenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 아이디를 입력해 메뉴를 삭제합니다.");
		int cafeID = sc.nextInt();
		model.deleteMenu(cafeID);
		System.out.println("카페의 메뉴가 삭제되었습니다.");
		
	}
}
