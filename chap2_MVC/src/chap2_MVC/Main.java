package chap2_MVC;

public class Main {
	public static void main(String[] args) {
		cafeModel model = new cafeModel();
		cafeView view = new cafeView(model);
		
		//controller
		cafeController controller = new cafeController(model,view);
		controller.run();
		
		//view.addCafeName();
		//view.updateMenu();
		//view.UpdateCafe();
		//view.DeleteCafe();
		//view.Deletemenu();
		
	}

}
