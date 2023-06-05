package controller;

import java.util.HashMap;
import java.util.Map;

import controller.book.AddBookController;
import controller.book.DeleteBookController;
import controller.book.GetBookListController;
import controller.book.SearchBookController;
import controller.homepage.HomepageController;
import controller.user.InsertUserController;
import controller.user.LoginController;
import controller.user.LogoutController;

public class HandlerMapping {

		private Map<String, Controller> mappings;
		public HandlerMapping() {
			mappings = new HashMap<String, Controller>();
			mappings.put("/homepage.do", new HomepageController());
			mappings.put("/insertUser.do", new InsertUserController());
			mappings.put("/login.do", new LoginController());
			mappings.put("/logout.do", new LogoutController());
			mappings.put("/getBookList.do", new GetBookListController());
			mappings.put("/addBook.do", new AddBookController());
			mappings.put("/deleteBook.do", new DeleteBookController());
			mappings.put("/searchBook.do", new SearchBookController());
		}
		public Controller getController(String path) {
			return mappings.get(path);
		}
		
}
