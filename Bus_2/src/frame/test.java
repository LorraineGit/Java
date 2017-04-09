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
				dict.add(b, "ר������");	
			}

		String str="����ȥ����ԷС��";
                
        // ��������ֵ��ļ�  
//       dict.add("��³���ѧԺ", "ר������");
  //     dict.add("��³���԰", "ר������");

        // seg.mΪģ���ļ���  
        CWSTagger cwst = new CWSTagger("./models/seg.m");  
        cwst.setDictionary(dict);  
        String d= cwst.tag(str);
		System.out.println(d);
	}
}
