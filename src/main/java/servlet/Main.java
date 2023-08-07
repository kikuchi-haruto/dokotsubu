
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.User;

/**
 *　Mainコントローラー
 */
//@アノテーション（/URLパターン）
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * Getリクエスト用
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//呟きリストをアプリケーションスコープから取得
		ServletContext application= this.getServletContext();
		List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
		
		//呟きリストの有無を判定
		if(mutterList == null) {//呟きリストがアプリケーションスコープにない場合
			
			//新しい呟きリストを生成
			mutterList = new ArrayList<>();
			
			//アプリケーションスコープに呟きリストを格納
			application.setAttribute("mutterList", mutterList);
		}
		
		//ログインしているか確認する為
		//セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();	
		User loginUser = (User)session.getAttribute("loginUser");
		
		//ユーザー情報の有無を判定
		if (loginUser == null) {//ログインしていない場合
			
			//TOP画面にリダイレクト
			response.sendRedirect("index.jsp");
			
		}else {//ログイン済の場合
			
			//メイン画面にフォワード
			RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
			
		}
	}

	/**
	 * POSTリクエスト用
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
