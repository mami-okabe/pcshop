package control;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Operation;
	
/**
 * Servlet implementation class AddProdServlet
 */
@WebServlet("/add-prod-servlet")
public class AddProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletrequest request, HttpServletResponse response
	 * */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		//パラメータ取得
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));


		//セッションオブジェクト取得
		HttpSession session = request.getSession();

		//カートへの商品追加処理
		Operation op = new Operation();
		op.addProd(idx, session);

		//転送先設定
		String url = "cart.jsp";

		//転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}










/*
    public AddProdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
 */



















/*
	/**
 * *商品追加処理
 * @param idx 商品一覧の選択した商品のidx（セッション：store内）
 * @param session セッションオブジェクト
 */
	/*
public void addProd(int idx, HttpSession  session) {

	//店舗情報・カート情報の取得（セッションより）
	Store store = (Store) session.getAttribute("store");
	Cart  cart =(Cart) session.getAttribute("cart");

	if ((store != null) && (cart !=null)) {
		//カートに指定の商品を追加
		cart.add(store.getListProd().get(idx));

		//セッションに再度格納

	}

}
*/

}


