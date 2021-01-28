package FileIO;

import java.io.File;

public class JavaFileIO {
	     public static void main(String[] args) {
		         File dir = new File("E:\\OLD\\");
		          //File dir=new File("F:\\");
		        //如果使用上述的盘符的根目录，会出现java.lang.NullPointerException
		         //为什么？
		         getAllFiles(dir, 0);//0表示最顶层
		     }
		 
		     /**
		16      * 获取层级的方法
		17      *
		18      * @param level
		19      * @return
		20      */
		     public static String getLevel(int level) {
		 
		         StringBuilder stringBuilder = new StringBuilder();
		         for (int l = 0; l < level; l++) {
		             stringBuilder.append("|--");
		         }
		         return stringBuilder.toString();
		     }
		 
		     public static void getAllFiles(File dir, int level) {
		 
		         System.out.println(getLevel(level) + dir.getName());
		         level++;
		         File[] files = dir.listFiles();
		         for (int i = 0; i < files.length; i++) {
		             if (files[i].isDirectory()) {
		                 // 这里面用了递归的算法
		                 getAllFiles(files[i], level);
		             } else {
		                 System.out.println(getLevel(level) + files[i]);
		             }
		         }
		     }
}
