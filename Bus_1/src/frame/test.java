package frame;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

import javax.swing.JTextArea;

public class test {
	static Dijkstra1 a=new Dijkstra1();
	//static Dijkstra a=new Dijkstra();
	public static void main(String[] args) throws FileNotFoundException {
		
		int []ans1=a.work2(71, 91);
	//	a.work3(1, 42);
		for(int i=0;i<ans1.length;i++)
		System.out.println(ans1[i]);
		show(ans1);
	//	for(int i=0;i<5;i++)
	//	System.out.println(Dijkstra.route1[55][58][i]);
//		a.work2(1, 9);
//		test();
	}
	
	public static void show(int ans[]){
		int i=ans[0];        //经过的站点数
		int k=1;
		int j=i+1;
		
		Node []node=a.getNode();
		
		while(j<i*2){
			System.out.println("No."+Dijkstra1.route[ans[j]].getName()+" :"+node[ans[k++]].getName()+"->");
			j++;
			while(ans[j]==ans[j-1]&&j<i*2){System.out.println(node[ans[k]].getName()+"->");j++;k++;}
			if(j<i*2||k<=i)System.out.println(""+node[ans[k]].getName());
			
			
//			ansText.append(("No."+ans[j]+" :"+ans[k++]+"->"));
//			j++;
//			while(ans[j]==ans[j-1]&&j<i*2){ansText.append(ans[k]+"->");j++;k++;}
//			if(j<i*2||k<=i)ansText.append(""+ans[k]);
//			ansText.append("\n");
		}
		System.out.println("Full time "+new DecimalFormat("#.00").format(a.getAnsTime())+"\n");
/*		double x1[]=new double[ans[0]+2];double y1[]=new double[ans[0]+2];double x2[]=new double[ans[0]+2];double y2[]=new double[ans[0]+2];
		for(int ii=1;ii<=ans[0];ii++){
			x1[ii]=node[ans[ii-1]].getX();y1[ii]=node[ans[ii-1]].getY();x2[ii]=node[ans[ii]].getX();y2[ii]=node[ans[ii]].getY();
		};*/
	}
}
