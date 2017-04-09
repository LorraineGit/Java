package frame;

public class Node {
	final int  maxn=30;
	 int index;       //序号
	 int passRoute[];   //经过的线路号
	 int len;               //经过它的线路数量
	 double x,y;             //坐标
	 String name;
	public Node(){
		index=0;len=0;x=y=0;
		len=0;
		passRoute=new int[maxn];
	}
	//just node[id].addPassRoute
	public void addPassRoute(int x){passRoute[len++]=x;	}
	public int getLen(){return len;	}
	public int [] getPassRoute(){return passRoute;	}
	public int getIndex(){return index;	}
	public void setName(String aname){name=aname;	}
	public void setIndex(int id){index=id;	}
	public String getName(){return name;	}
	public double getX(){return x;}
	public double getY(){return y;}

}
