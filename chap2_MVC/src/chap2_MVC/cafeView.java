package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel�̶�� Ŭ������ �������� ���� ��������� ī�� �� �߰���
	public cafeModel model;
	
	//model �Ű������� ���� �� �ִ� �����ڸ� ����������
	public cafeView(cafeModel model) {
		this.model = model;
	}
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ������ �Է��ϼ���");
		
		System.out.println("��ȣ��: ");
		String name = sc.nextLine();
		
		System.out.println("ī�� �ּ�: ");
		String address = sc.nextLine();
	
		System.out.println("ī�� ����ó : ");
		String phoneNumber = sc.nextLine();
		
		System.out.println("ī�� � �ð� : ");
		String operatingHours = sc.nextLine();
		
		//ī�� ������� insertCafe��� �޼��带 ������ �;���
		model.insertcafe(name, address, phoneNumber, operatingHours);
		System.out.println("ī�䰡 ���������� �߰��Ǿ����ϴ�.");
		
	}

	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ������ ������Ʈ�ϼ���");
		
		System.out.println("������ �޴� ���� : ");
		String description = sc.nextLine();
		
		System.out.print("�޴� ID : ");
		int menuId = sc.nextInt();
		
		System.out.print("ī�� ID : ");
		int cafeId = sc.nextInt();
		
		//model�� �ִ� UpdateMenu�� ������ͼ� ����ڰ� �ۼ��� �������� �߰��ϱ�
		model.updateMenu(description, menuId, cafeId);
		System.out.println("�޴� ������ ������Ʈ�Ǿ����ϴ�.");
		
	}
	//����ڰ� ������ ��ð� ȭ�� Scanner �̿��ؼ� �����
	public void UpdateCafe() {
		Scanner sc = new Scanner(System.in);
	
		System.out.println("ī�� ID �Է� :");
		int cafeId = sc.nextInt();
	
		System.out.println("������ ��ð�: ");
		String OP_hours = sc.next();
		
		
		model.updateCafe(cafeId, OP_hours);
		System.out.println("��ð��� ������Ʈ�Ǿ����ϴ�.");
	}

	public void DeleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�並 �����ϰڽ��ϴ�.");
		System.out.println("������ ī���� ���̵� �Է�: ");
		int cafeId = Integer.parseInt(sc.nextLine());
		//�ΰ������   int cafeId = sc.nextInt();
		
		model.deleteCafe(cafeId);
		System.out.println("ī�䰡 �����Ǿ����ϴ�.");
	}

	public void Deletemenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ���̵� �Է��� �޴��� �����մϴ�.");
		int cafeID = sc.nextInt();
		model.deleteMenu(cafeID);
		System.out.println("ī���� �޴��� �����Ǿ����ϴ�.");
		
	}
}
