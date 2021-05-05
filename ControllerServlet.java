package com.example.demo;



import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControllerServlet {
	
	@Autowired
	StockService stockService;
	
	@RequestMapping("/")
	public ModelAndView Index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("/login")
	public ModelAndView login(ModelAndView mav) {
		mav.setViewName("login");
		return mav;
	}
	

//	@RequestMapping("/other")
//	public String other() {
//		return "redirect:/";
//	}
//	
//	@RequestMapping("/forward")
//	public String forward() {
//		return "forward:/";
//	}
//	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView home(ModelAndView mav) throws Exception{
		mav.setViewName("home");
		mav.addObject("msg", "please write your name");
		
	    // データの取得
	    List<Stock> StockDataList = stockService.findAllStockData();
		//DataObject object = new DataObject(1, 2, "name", 3, 4);
		mav.addObject("object",StockDataList);
		
		return mav	;
	}
	
    //ポイント1
    @GetMapping("insert")
    //ポイント2
    String create(@ModelAttribute CustomerForm customerForm) {
        return "insert";
    }

    //ポイント1
    @PostMapping("insert")
    String regist(@ModelAttribute CustomerForm customerForm) {
        Stock stock = new Stock();
        //ポイント2
        BeanUtils.copyProperties(customerForm, stock);

        //ポイント3
        stockService.insert(stock);

        //ポイント4
        return "redirect:/";
    }
    
	@RequestMapping(path = "/send", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView send(@RequestParam("text1")String str, ModelAndView mav){
		mav.setViewName("home");
		mav.addObject("msg","Hello, "+str+"!!");
		mav.addObject("value",StringTest(str));
		return mav	;
	}
	
	
	public String StringTest(String str) {
		String a = "**********************";
		System.out.print("***"+a+str);
		return a+str;
	}
	
	
//	public  void PostgreTest(DataObject obj) throws Exception {
//        java.sql.Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//
//        try {
//        	System.out.print(",PostgreTest START !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//            //-----------------
//            // 接続
//            //-----------------
//
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", // "jdbc:postgresql://[場所(Domain)]:[ポート番号]/[DB名]"
//                    "pgadmin", // ログインロール
//                    "XXXXXX"); // パスワード
//            statement = connection.createStatement();
//
//            //-----------------
//            // SQLの発行
//            //-----------------
//            //ユーザー情報のテーブル
//            resultSet = statement.executeQuery("SELECT * FROM weather");
//
//            //-----------------
//            // 値の取得
//            //-----------------
//            // フィールド一覧を取得
//            List<String> fields = new ArrayList<String>();
//            ResultSetMetaData rsmd = resultSet.getMetaData();
//            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//                fields.add(rsmd.getColumnName(i));
//            }
//            
//            //結果の出力
//            int rowCount = 0;
//            while (resultSet.next()) {
//                rowCount++;
//
//                System.out.println("---------------------------------------------------");
//                System.out.println("--- Rows:" + rowCount);
//                System.out.println("---------------------------------------------------");
//                
//                new DataObject(
//                resultSet.getInt("id"),
//                resultSet.getInt("location_id"),
//                resultSet.getString("name"),
//                resultSet.getInt("temperature"),
//                resultSet.getInt("humidity")
//                );
//                
//                //値は、「resultSet.getString(<フィールド名>)」で取得する。
//                for (String field : fields) {
//                    System.out.println(field + ":" + resultSet.getString(field));
//                }
//            }
//
//
//        } finally {
//            //接続を切断する
//            if (resultSet != null) {
//                resultSet.close();
//            }
//            if (statement != null) {
//                statement.close();
//            }
//            if (connection != null) {
//                connection.close();
//            }
//        }
//
//        return obj;
//	}
	
//	@RestController
//	@RequestMapping("/delete")
//	public class RestTest {
//
//		public ModelAndView delete(ModelAndView mav) throws Exception{
//			mav.setViewName("delete");
//			mav.addObject("msg", "delete");
//			
//		    // データの取得
//		    List<Stock> StockDataList = stockService.findAllStockData();
//			//DataObject object = new DataObject(1, 2, "name", 3, 4);
//			mav.addObject("object",StockDataList);
//			
//			return mav	;
//		}
//
//	}
}

