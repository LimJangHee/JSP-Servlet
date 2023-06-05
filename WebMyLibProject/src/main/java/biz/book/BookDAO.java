package biz.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import biz.common.JDBCUtil;
import biz.user.UserVO;

public class BookDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private static String BOOK_LIST = "select * from book";
	
	private static String BOOK_ADD = "insert into book(isbn, name, writer, publisher)" +
            "values(?, ?, ?, ?)";
	
	private static String BOOK_SEARCH = "select instr((isbn || name || writer || publisher || receive || rentable), ?)as bookh" +
			" , isbn, name, writer, publisher, receive, rentable" +
			" from book" +
			" where instr((isbn || name || writer || publisher || receive || rentable), ?) != 0" +
			" order by isbn";
	
	private static String BOOK_DELETE = "DELETE FROM book WHERE name = ?";
			
			
	
	public List<BookVO> getBookList(BookVO vo){ 
		List<BookVO> bookList = new ArrayList<>();
		BookVO book = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOOK_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				book = new BookVO();
				book.setIsbn(rs.getInt("ISBN"));
				book.setName(rs.getString("NAME"));
				book.setWriter(rs.getString("WRITER"));
				book.setPublisher(rs.getString("PUBLISHER"));
				book.setReceive(rs.getDate("RECEIVE"));
				book.setRentable(rs.getBoolean("RENTABLE"));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return bookList;

	}
	
	public void addBook(BookVO vo) {

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOOK_ADD);
            stmt.setInt(1, vo.getIsbn());
            stmt.setString(2, vo.getName());
            stmt.setString(3, vo.getWriter());
            stmt.setString(4, vo.getPublisher());

//            java.util.Date receiveDate = vo.getReceive();
//            java.sql.Date sqlReceiveDate = new java.sql.Date(receiveDate.getTime());
//            stmt.setDate(5, sqlReceiveDate);
            
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }
	
	public List<BookVO> selectByAll(String bookinfo) {
		List<BookVO> bookList = new ArrayList<>();
	       
	      try {
	    	  conn = JDBCUtil.getConnection();
	    	  stmt = conn.prepareStatement(BOOK_SEARCH);
	    	  stmt.setString(1 , bookinfo);
	    	  stmt.setString(2 , bookinfo);
	         
	    	  ResultSet rs = stmt.executeQuery();
	    	  
	         if(rs.next()) {
	            BookVO book = new BookVO();
	            book.setIsbn(rs.getInt("ISBN"));
				book.setName(rs.getString("NAME"));
				book.setWriter(rs.getString("WRITER"));
				book.setPublisher(rs.getString("PUBLISHER"));
				book.setReceive(rs.getDate("RECEIVE"));
				book.setRentable(rs.getBoolean("RENTABLE"));
				
				bookList.add(book);
	         }
	         
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	    	  JDBCUtil.close(rs,  stmt, conn);
	      }
	      return bookList;
	   }
	
	public void deleteBook(String name) {
	    try {
	        conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement(BOOK_DELETE);
	        stmt.setString(1, name);
	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        JDBCUtil.close(stmt, conn);
	    }
	}

}
