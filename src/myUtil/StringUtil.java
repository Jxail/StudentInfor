package myUtil;

public class StringUtil {
	/**
	 * 用于判断字符串是空的，是则返回true
	 * @param addStuID
	 * @return
	 */
   public static boolean isEmpty(String  s){
	   if("".equals(s)||s==null)   return true;
		 else return false;  
   }
   /**
    * 用于判断字符串是不是空的，如果成立则返回true
    * @param s
    * @return
    */
   public static boolean isNotEmpty(String s){
	   if(!"".equals(s)&&s!=null) return true;
	   else return false;
   }
}
