package frame;

import java.sql.ResultSet;
import java.util.ArrayList;




import edu.fudan.ml.types.Dictionary;
import edu.fudan.nlp.cn.tag.CWSTagger;
import gnu.trove.set.hash.THashSet;




public class test {
	static Dictionary dict = new Dictionary(); 
	public static void main(String[] args) throws Exception {
		
		SQLHelper a=new SQLHelper();
		a.getConnection();
		a.exesql("select * from Stop");
		ResultSet rs=a.rs;
			while (rs.next()) {
				String b=rs.getString(1);
				System.out.println(b);
				dict.add(b, "专有名词");	
			}

		String str="我想去友谊苑小区";
                
        // 添加两个字典文件  
//       dict.add("齐鲁软件学院", "专有名词");
  //     dict.add("齐鲁软件园", "专有名词");

        // seg.m为模型文件名  
        CWSTagger cwst = new CWSTagger("./models/seg.m");  
        cwst.setDictionary(dict);  
        String d= cwst.tag(str);
		System.out.println(d);
	}
}
