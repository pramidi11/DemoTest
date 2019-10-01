package autoapp.automation.utility;

public class ProductDetails {
	   private static String productName;
	    private static String productColor;

	    public static String getProductName(){
	        return productName;
	    }

	    public static String getProductColor() {
	        return productColor;
	    }

	    public static void setProductName(String value){
	        productName = value;
	    }

	    public static void setProductColor(String value) {
	        productColor = value;
	    }
}
