package CartModal;

import java.util.ArrayList;

public class CartDAO {
    public ArrayList<Cart> cartList = new ArrayList<>();  // Danh sách giỏ hàng
    public ArrayList<Cart> getDs(){
    	return cartList;
    }
    // Thêm sản phẩm vào giỏ hàng
    public void addToCart(int id,String name,float gia,int soluong) {
        // Kiểm tra xem sản phẩm đã có trong giỏ chưa
        for (Cart c : cartList) {
            if (c.getId() == id) {
                // Nếu có rồi thì cập nhật số lượng
                c.setSoluong(c.getSoluong() + soluong);
                return;
            }
        }
        // Nếu chưa có thì thêm mới vào giỏ
        cartList.add(new Cart(id,name,gia,soluong));
    }

    

    // Xóa sản phẩm khỏi giỏ hàng theo id
    public void xoa(int id) {
        cartList.removeIf(cart -> cart.getId() == id);
    }

    // Xóa tất cả sản phẩm trong giỏ hàng
    public void clearCart() {
        cartList.clear();
    }

    // Cập nhật số lượng sản phẩm trong giỏ hàng
    public void updatesoluong(int id, int newsoluong) {
        for (Cart cart : cartList) {
            if (cart.getId() == id) {
                cart.setSoluong(newsoluong);
                break;
            }
        }
    }

    // Tính tổng giá trị giỏ hàng
    public float Tong() {
        float total = 0;
        for (Cart cart : cartList) {
            total += cart.getThanhTien();
        }
        return total;
    }

    // Kiểm tra giỏ hàng có trống không
    public boolean isCartEmpty() {
        return cartList.isEmpty();
    }
}
