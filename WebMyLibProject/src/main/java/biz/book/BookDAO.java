package biz.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import biz.common.JDBCUtil;

public class BookDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private static String BOOK_SEARCH = "select * from book";
	
	public List<BookVO> getBookList(BookVO vo){ 
		List<BookVO> bookList = new ArrayList<>();
		BookVO book = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOOK_SEARCH);
			rs = stmt.executeQuery();
			while(rs.next()) {
				book = new BookVO();
				book.setIsbn(rs.getInt("ISBN"));
				book.setName(rs.getString("NAME"));
				book.setWriter(rs.getString("WRITER"));
				book.setPublisher(rs.getString("PUBLISHER"));
				book.setReceive(rs.getDate("RECEIVE"));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return bookList;

	}

}
