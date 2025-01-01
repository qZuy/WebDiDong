package Controller;

import java.io.IOException;
import java.util.Date;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CartModal.Cart;
import CartModal.CartDAO;
import ChiTietHoaDonModal.CthdBO;
import HoaDonModal.HoaDonBO;
import UsersModal.Users;

/**
 * Servlet implementation class ControllerCart
 */
@WebServlet("/ControllerCart")
public class ControllerCart extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ControllerCart() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            CartDAO cart = (CartDAO) session.getAttribute("cart");
            if (cart != null) {
                request.setAttribute("cartList", cart.cartList);
                request.setAttribute("tong", cart.Tong());
            }
            request.getRequestDispatcher("Cart.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
           
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            CartDAO cart = (CartDAO) session.getAttribute("cart");
            if (cart == null) {
                cart = new CartDAO();
                session.setAttribute("cart", cart);
            }

            String action = request.getParameter("action");

            if ("add".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                float gia = Float.parseFloat(request.getParameter("gia"));
                int soluong = Integer.parseInt(request.getParameter("soluong"));
                cart.addToCart(id, name, gia, soluong);
                session.setAttribute("cart", cart);
                response.sendRedirect("ControllerCart");
            } else if ("update".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                int newsoluong = Integer.parseInt(request.getParameter("newsoluong"));
                cart.updatesoluong(id, newsoluong);
                session.setAttribute("cart", cart);
                response.sendRedirect("ControllerCart");
            } else if ("remove".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                cart.xoa(id);
                session.setAttribute("cart", cart);
                response.sendRedirect("ControllerCart");
            } else if ("removeall".equals(action)) {
                if (cart != null) {
                    cart.clearCart();
                    session.setAttribute("cart", cart);
                }
                response.sendRedirect("ControllerCart");
            } else if ("muahang".equals(action)) {
                if (session.getAttribute("dn") == null) {
                    response.sendRedirect("ControllerLogin");
                } else {
                    Users us = (Users) session.getAttribute("dn");
                    if (cart != null) {
                        HoaDonBO hoaDonBO = new HoaDonBO();
                        Date NgayMua = new Date();
                        hoaDonBO.Them(us.getId(), NgayMua);
                        int Mahd = hoaDonBO.mahd();
                        CthdBO ctbo = new CthdBO();
                        for (Cart c : cart.cartList) {
                            ctbo.Them(Mahd, c.getId(), c.getSoluong());
                        }
                        session.removeAttribute("cart");
                        response.sendRedirect("ControllerHistorykh");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
