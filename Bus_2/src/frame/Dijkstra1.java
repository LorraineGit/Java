package frame;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Dijkstra1 {
	boolean flag=false;
	int e;
	int q=1;
	double tmp2;
	final static int maxn=100;
	final static int maxnode=200;
	final double INFDOUBLE=0x3f3f3f3f;
	/**true:i toj have a path*/
	boolean gra[][]=new boolean[maxnode][maxnode];;
	public int routelen;
	public static int nodelen;
	public static Route[] route=new Route[maxn];
	public static Node[] node=new Node[maxnode];
	/**the distance between two nodes*/
	double distanceTwoNodes[][];
	/**to mark the route  route1: the index you need to take when you want the shortest time from i to j*/
	static int route1[][][]=new int[maxnode][maxnode][5];
	/**the miniest time between two nodes*/
	double time1[][];
	/**the least time by this way*/
	int leastTimeTrack[][];
	/**the shortest time to return home*/
	double ansTime;
	public Dijkstra1() {
		for(int i=0;i<maxnode;i++)node[i]=new Node();
		routelen=1;nodelen=1;
		for(int i=0;i<maxn;i++)route[i]=new Route();
		time1=new double[maxnode][maxnode];
		distanceTwoNodes=new double[maxnode][maxnode];
		leastTimeTrack=new int[maxnode][maxnode];
		/*for(int i=0;i<nodelen;i++){
		for(int j=0;j<nodelen;j++){
			for(int s=0;s<5;s++){
				while(route1[i][j][s]==0){
					route1[i][j][s]=x.index;
					route1[j][i][s]=x.index;
				}
			}
		}
	}*/
		for(int i=0;i<maxnode;i++)
			for(int j=0;j<maxnode;j++){
				gra[i][j]=false;
				time1[i][j]=INFDOUBLE;
				if(i!=j)
					distanceTwoNodes[i][j]=INFDOUBLE;
				else distanceTwoNodes[i][j]=0;
			}
		 run();
		
	}
	/** It's in the input process*/
	void addRoute(Route x){
		
		int b;
		route[routelen++]=x;
		//a nodes this route owning
		int a=x.getPassNodelen();
		int []temppass=x.getPassNode();
		int startx=temppass[0];
		for(int i=1;i<a;i++){
			b=temppass[i];
			//calc the distance between two nodes 
//			if(distanceTwoNodes[startx][b])//0 means that it didn'y be worked before
		//	double w=MapDistance.GetDistance(aa[0],aa[1],bb[0],bb[1]);
			distanceTwoNodes[startx][b]=MapDistance.GetDistance(node[startx].x,node[startx].y,node[b].x,node[b].y);
			if(time1[startx][b]>distanceTwoNodes[startx][b]/x.getSpeed()){
				time1[startx][b]=distanceTwoNodes[startx][b]/x.getSpeed();
				time1[b][startx]=time1[startx][b];
			// if there's shorter time ,x is the better answer
		}
			
			route1[startx][b][q]=x.index;
			route1[b][startx][q]=x.index;
		gra[startx][temppass[i]]=true;
		gra[temppass[i]][startx]=true;
		startx=temppass[i];
		
		}
		q++;
	}
	
	void addNode(Node x){
		node[nodelen++]=x;

	}
	public Node[] getNode(){
		return node;
	}
	/**This method is to calc the most saving time route that we needn't wait*/

	public int[] work1(int v,int destnation){
		//this is the shortest time answer
		double []timedist=new double[nodelen];
		boolean[] used=new boolean[nodelen];
		int [] routeindex=new int [nodelen];
		//the no of the bus you need to take on this site
		
		int[] pre=new int[nodelen];
		//copy the information
		for(int i=1;i<nodelen;i++){
			timedist[i]=time1[v][i];
			used[i]=false;
			pre[i]=0;
//			System.out.println("time :"+timedist[i]);
		}
		pre[v]=v;
		timedist[v]=0;
		used[v]=true;
		for(int i=1;i<=nodelen;i++)if(gra[v][i])pre[i]=v;
		for(int i=1;i<nodelen;i++){
			if(i==v)continue;
			double tmp=INFDOUBLE;
			int u=v;
			//find the nearest point u
			for(int j=1;j<nodelen;j++){
				if(!used[j] && timedist[j]<tmp){
					u=j;
					tmp=timedist[j];
				}
			}
			used[u]=true;
			int w=1;
			while(route1[pre[u]][u][w]==0&&w<4)
				w++;
					routeindex[u]=route1[pre[u]][u][w];
			for(int j=1;j<nodelen;j++){
				if(!used[j]&& time1[u][j]<1000000){
					for(int x=1;x<5;x++){
						//for(int y=0;y<5;y++){
							if(route1[u][j][x]==route1[pre[u]][u][routeindex[u]]&&
									route1[u][j][x]!=0){
								tmp2=timedist[u]+time1[u][j];
								flag=true;
								routeindex[j]=x;
							//}
						}
					}
					
					if(flag==false){
					//	System.out.println("aaa");
						int p=0;
						while(route1[u][j][p]==0)
							p++;
						int min=route[route1[u][j][p]].gettime();
						for (int s=0;u<5;u++)
							if(min>route[route1[u][j][u]].gettime()&&route1[u][j][u]!=0){
								min=route[route1[u][j][u]].gettime();
								u=e;
							}
						routeindex[j]=e;
						tmp2=timedist[u]+time1[u][j];
					}
				///	double tmp2=timedist[u]+time1[u][j];
					if(tmp2<timedist[j]){
						timedist[j]=tmp2;pre[j]=u;
						
					}
					flag=false;
				}
			}
		}
//		for(int i=1;i<nodelen;i++)System.out.println("pre"+pre[i]+"time"+timedist[i]);
		//follow is to recover the way
		int []theSite=new int[nodelen];
		int [] passRoute=new int[nodelen];
		int i=1;
		theSite[i]=destnation;
		ansTime=timedist[destnation];
		passRoute[i++]=routeindex[destnation]; 
		destnation=pre[destnation];//两站点之间的线路
		int ans[]=new int[nodelen*3];
		while(pre[destnation]!=destnation){
			theSite[i]=pre[destnation];
			destnation=pre[destnation];
			passRoute[i]=routeindex[destnation];
			i++;
		}
		i--;
		theSite[0]=i;//the number of the point
		//ans[0]is the num of sites
		ans[0]=theSite[0];
		//ans[1..i]is the sites
		//ans[i+1..i*2-1]the No.bus
		//ans[i*2] the shortest time
		for(int j=1;j<=i;j++)ans[j]=theSite[i-j+1];
		for(int j=i+1;j<i+1+i;j++)ans[j]=passRoute[i+i-j];
		return ans;
		
	} 
	
	
	public int[] work2(int v,int destnation){
		
		double [] cost=new double[nodelen];
		double []timedist=new double[nodelen];
		boolean[] used=new boolean[nodelen];
		int [] routeindex=new int [nodelen];
	
		
		int[] pre=new int[nodelen];
		//复制信息
		for(int i=1;i<nodelen;i++){
			timedist[i]=time1[v][i];
			cost[i]=time1[v][i];
			used[i]=false;
			pre[i]=0;
//			System.out.println("time :"+timedist[i]);
		}
		pre[v]=v;
		timedist[v]=0;
		cost[v]=0;
		used[v]=true;
		for(int i=1;i<=nodelen;i++)if(gra[v][i])pre[i]=v;
		for(int i=1;i<nodelen;i++){
			if(i==v)continue;
			double tmp=INFDOUBLE;
			int u=v;
			//找到最近的一个顶点
			for(int j=1;j<nodelen;j++){
				if(!used[j] && timedist[j]<tmp){
					u=j;
					tmp=timedist[j];
				}
			}
			used[u]=true;
			int w=1;
			while(route1[pre[u]][u][w]==0&&w<4)
				w++;
					routeindex[u]=route1[pre[u]][u][w];
			for(int j=1;j<nodelen;j++){
				if(!used[j]&& time1[u][j]<1000000){
					for(int x=1;x<5;x++){
						//for(int y=0;y<5;y++){
							if(route1[u][j][x]==route1[pre[u]][u][routeindex[u]]&&
									route1[u][j][x]!=0){
								tmp2=timedist[u]+time1[u][j];
								flag=true;
								routeindex[j]=x;
							//}
						}
					}
					
					if(flag==false){
					//	System.out.println("aaa");
						int p=0;
						while(route1[u][j][p]==0)
							p++;
						int min=route[route1[u][j][p]].gettime();
						for (int s=0;u<5;u++)
							if(min>route[route1[u][j][u]].gettime()&&route1[u][j][u]!=0){
								min=route[route1[u][j][u]].gettime();
								u=e;
							}
						routeindex[j]=e;
						tmp2=timedist[u]+time1[u][j]+min;
					}
				///	double tmp2=timedist[u]+time1[u][j];
					if(tmp2<timedist[j]){
						timedist[j]=tmp2;pre[j]=u;
						
					}
					flag=false;
				}
			}
		}
//		for(int i=1;i<nodelen;i++)System.out.println("pre"+pre[i]+"time"+timedist[i]);
		//follow is to recover the way
		int []theSite=new int[nodelen];
		int [] passRoute=new int[nodelen];
		int i=1;
		theSite[i]=destnation;
		ansTime=timedist[destnation];
		passRoute[i++]=routeindex[destnation]; 
		destnation=pre[destnation];//两站点之间的线路
		int ans[]=new int[nodelen*3];
		while(pre[destnation]!=destnation){
			theSite[i]=pre[destnation];
			destnation=pre[destnation];
			passRoute[i]=routeindex[destnation];
			i++;
		}
		i--;
		theSite[0]=i;//the number of the point
		//ans[0]总站点数
		ans[0]=theSite[0];
		//ans[1..i]站点
		//ans[i+1..i*2-1]线路
		//ans[i*2] 最短时间
		for(int j=1;j<=i;j++)ans[j]=theSite[i-j+1];
		for(int j=i+1;j<i+1+i;j++)ans[j]=passRoute[i+i-j];
		return ans;
		
	} 
	
	public int[] work3(int v,int destnation){
		//this is the shortest time answer
		double [] cost=new double[nodelen];
		double []timedist=new double[nodelen];
		boolean[] used=new boolean[nodelen];
		int [] routeindex=new int [nodelen];
		//the no of the bus you need to take on this site
		
		int[] pre=new int[nodelen];
		//copy the information
		for(int i=1;i<nodelen;i++){
			timedist[i]=time1[v][i];
			cost[i]=time1[v][i];
			used[i]=false;
			pre[i]=0;
//			System.out.println("time :"+timedist[i]);
		}
		pre[v]=v;
		timedist[v]=0;
		cost[v]=0;
		used[v]=true;
		for(int i=1;i<=nodelen;i++)if(gra[v][i])pre[i]=v;
		for(int i=1;i<nodelen;i++){
			if(i==v)continue;
			double tmp=INFDOUBLE;
			int u=v;
			//find the nearest point u
			for(int j=1;j<nodelen;j++){
				if(!used[j] && timedist[j]<tmp){
					u=j;
					tmp=timedist[j];
				}
			}
			used[u]=true;
			int w=1;
			while(route1[pre[u]][u][w]==0&&w<4)
				w++;
					routeindex[u]=route1[pre[u]][u][w];
			for(int j=1;j<nodelen;j++){
				if(!used[j]&& time1[u][j]<1000000){
					for(int x=1;x<5;x++){
						//for(int y=0;y<5;y++){
							if(route1[u][j][x]==route1[pre[u]][u][routeindex[u]]&&
									route1[u][j][x]!=0){
								tmp2=timedist[u]+time1[u][j];
								flag=true;
								routeindex[j]=x;
							//}
						}
					}
					
					if(flag==false){
					//	System.out.println("aaa");
						int p=0;
						while(route1[u][j][p]==0)
							p++;
						int min=route[route1[u][j][p]].getPrice();
						
						for (int s=0;u<5;u++)
							if(min>route[route1[u][j][u]].getPrice()&&route1[u][j][u]!=0){
								min=route[route1[u][j][u]].getPrice();
								u=e;
							}
						routeindex[j]=e;
						tmp2=timedist[u]+time1[u][j]+min*100;
					}
				///	double tmp2=timedist[u]+time1[u][j];
					if(tmp2<timedist[j]){
						timedist[j]=tmp2;pre[j]=u;
						
					}
					flag=false;
				}
			}
		}
//		for(int i=1;i<nodelen;i++)System.out.println("pre"+pre[i]+"time"+timedist[i]);
		//follow is to recover the way
		int []theSite=new int[nodelen];
		int [] passRoute=new int[nodelen];
		int i=1;
		theSite[i]=destnation;
		ansTime=timedist[destnation];
		passRoute[i++]=routeindex[destnation]; 
		destnation=pre[destnation];//两站点之间的线路
		int ans[]=new int[nodelen*3];
		while(pre[destnation]!=destnation){
			theSite[i]=pre[destnation];
			destnation=pre[destnation];
			passRoute[i]=routeindex[destnation];
			i++;
		}
		i--;
		theSite[0]=i;//the number of the point
		//ans[0]is the num of sites
		ans[0]=theSite[0];
		//ans[1..i]is the sites
		//ans[i+1..i*2-1]the No.bus
		//ans[i*2] the shortest time
		for(int j=1;j<=i;j++)ans[j]=theSite[i-j+1];
		for(int j=i+1;j<i+1+i;j++)ans[j]=passRoute[i+i-j];
		return ans;
		
	} 
	
	public double getAnsTime(){
		return ansTime;
	}
	
	/**This is the thread to read the inputdata*/
		public void run() {
				int n,tmppassnode;
				SQLHelper SQL =new SQLHelper();
				SQL.getConnection();
				SQL.exesql("select * from stop1 order by index1");
				ResultSet rs=SQL.rs;
				try {
					while (rs.next()) {
						Node a=new Node();//here !!!!Attention:must be new every time
						a.index=rs.getInt(4);
						a.setName(rs.getString(1));
						a.x=rs.getDouble(2);
						a.y=rs.getDouble(3);
						addNode(a);
					}
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
	
				SQL.exesql("select * from route1 order by ID");
				ResultSet os=SQL.rs;
					try {
						while (os.next()){
							Route b=new Route();
							b.index=os.getInt(1);
							b.setName(os.getString(2));
							b.price=os.getInt(3);
							b.time=os.getInt(14);
							b.speed=os.getInt(13);
							SQLHelper SQL_1 =new SQLHelper();
							SQL_1.getConnection();
							SQL_1.exesql("select * from stop_route1 , stop1 where route= '"+os.getString(2)+"' and stop_route1.stop = stop1.name order by position");
							ResultSet is=SQL.rs;
								while (is.next()) {
									tmppassnode=is.getInt(7);
									b.addPassNode(tmppassnode);
									node[tmppassnode].addPassRoute(b.index);
									b.len=is.getInt(3);
								}
							n=b.len;
							addRoute(b);
						}
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
		
				for(int i=0;i<nodelen;i++){
					for(int j=0;j<nodelen;j++){
						if(i==j)time1[i][j]=0;
//						System.out.print(new DecimalFormat("000.00").format(time1[i][j])+" ");
					}
//					System.out.println();
				}
				
				
			}
		}
		









