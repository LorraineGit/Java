package frame;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

class Vertex {

    public int key = 0; //顶点编号
    public String name = null;//顶点相关信息
    public Edge[] adj = new Edge[20]; //和自己的邻接顶点之间的那条边
    Vertex[] childs=new Vertex[20];
    double[] cost= new double[20];
    String[] route=new String[20];
    public int f=0;//边的编号
    
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getnum(){
    	return f;
    }
    public Edge getAdj(int i) {
    	if(i>=0&&i<=f)
        return adj[i];
		return null;
    }
    public Edge[] getAdj() {
        return adj;
    }
    public void setAdj(Edge a) {
    	adj[f]=a;
        f++;
    }
    public Vertex[] getChilds(){
    	for(int p=0;p<f;p++)
        {
    		childs[p]=new Vertex();
    		childs[p]=adj[p].getDest(); 
        }
    	return  childs;
    }
    
    public double[]  getcost(){
    	for(int p=0;p<f;p++)
        {
       	cost[p]=adj[p].getCost(); 
        }
    	return  cost;
    }
    
    
    public double  getcost(int i){
    	for(int p=0;p<f;p++)
        {
       	cost[p]=adj[p].getCost(); 
        }
    	return  cost[i];
    }
    
    public String[]  getroute(){
    	for(int p=0;p<f;p++)
        {
       	route[p]=adj[p].getroute(); 
        }
    	return  route;
    }
    
    public String  getroute(int i){
    	for(int p=0;p<f;p++)
        {
       	route[p]=adj[p].getroute(); 
        }
    	return  route[i];
    }
}

class Edge {

    private Vertex dest ;//邻接顶点
    private double cost ;//权值
    private String route = null;//边信息
    private Edge link = null;//与这个顶点相关的所有边在邻接表中
    //的下一条边
   
    public Vertex getDest() {
        return dest;
    }
    public void setDest(Vertex dest) {
        this.dest = dest;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public String getroute() {
        return route;
    }
    public void setInfoEdge(String route) {
        this.route = route;
    }

}

public class GraphLink {

    public int maxVertices; //图中最大顶点数
    public static int numEdges; //当前边数
    static int numVertices;
    public int MaxEdges;
    public static Vertex[] NodeTable = null;
    public static Edge[] EdgeTable = null;
    static String[] c=  new String[1500];
    static int[] d= new int[1500];
    static double[] aa= new double[10];
    static double[] bb=new double[10];
    static int speed;
    static boolean flag=false;
    static boolean flag1=false;
    static int j;
    static int i;
    static int y;

    public GraphLink(int size,int b) {
        //构造函数：建立一个空的邻接表
        maxVertices = size;
        MaxEdges =b;
        numVertices = 0;
        numEdges = 0;
        EdgeTable = new Edge[MaxEdges];
        NodeTable = new Vertex[maxVertices]; //创建顶点表数组
        if (NodeTable == null||EdgeTable==null) {
            System.out.println("GraphLink is failed to create");
            System.exit(1);
        }
       /* for (int i = 0; i < maxVertices; i++)
            NodeTable[i].setAdj(null);*/

    }
    
    
    public void addVertex(String name){
    	NodeTable[numVertices]=new Vertex();
        NodeTable[numVertices].setKey(numVertices);  
        NodeTable[numVertices].setName(name);
        numVertices++;  
    }  
    /** 
     * 添加边 
     */  
    public void addEdge(Vertex vertex1,Vertex vertex2){ 
    	EdgeTable[numEdges]=new Edge();
    	vertex1.setAdj(EdgeTable[numEdges]);
    	EdgeTable[numEdges].setDest(vertex2);
    	numEdges++;
  
    }  
    /** 
     * 返回节点个数 
     * @return 
     */  
    public int getVertsCount(){  
        return NodeTable.length;  
    }  



    public int getVertexPos(int vertx) {
        //给出顶点vertex在图中的位置
        for (int i = 0; i < numVertices; i++)
            if (NodeTable[i].getKey() == vertx)
                return i;
        return -1;
    }

    public int getValue(int i) { //取顶点 i 的值
        return (i >= 0 && i < numVertices) ? NodeTable[i].getKey() : 0;
    }

  /*  public Vertex getFirstNeighbor(int v) {
        //给出顶点位置为 v 的第一个邻接顶点的位置,
        //如果找不到, 则函数返回-1
        if (v != -1) {
            //顶点v存在
            Edge p = NodeTable[v].getAdj(); //对应边链表第一个边结点
            if (p != null) {
                //存在, 返回第一个邻接顶点
                return p.getDest();
            }
        }
        return null; //第一个邻接顶点不存在
    }
*/
    

    public void printGraph(){
        for(int i = 0; i < maxVertices; i++){
           
        }
       
    }
    public static void initiate(){
    	GraphLink  a = new GraphLink(700,1500);
    	SQLHelper  b= new SQLHelper();
    	b.getConnection();
    	b.exesql("select * from stop_route order by route,position");
    	ResultSet rs=b.rs;
		try {
			int count=0;
			while (rs.next()) {
				c[count]=rs.getString(2);
				d[count]=rs.getInt(3);
				for(i=0;i<numVertices-1;i++)
				{
					if (c[count].equals(NodeTable[i].getName()))
					{
					flag=true;	
					break;
					}
				}
				for(y=0;y<numVertices-1;y++)
				{
					if (c[count-1].equals(NodeTable[y].getName()))
					{
					flag1=true;	
					break;
					}
				}
				if(flag==false)
				a.addVertex(rs.getString(2));
				String route =rs.getString(1);
				
				if(count!=0&&d[count]-d[count-1]==1)
				{
					if (flag == true&&flag1==false) {
						a.addEdge(NodeTable[numVertices - 2], NodeTable[i]);
						System.out.println(NodeTable[numVertices - 2].getName()+"->"+NodeTable[i].getName());
						SQLHelper SQL = new SQLHelper();
						SQL.getConnection();
						SQL.exesql("select * from Stop where name='"
								+ NodeTable[numVertices - 2].getName() + "'");
						ResultSet os = SQL.rs;
						while (os.next()) {
							aa[0] = os.getDouble(2);
							aa[1] = os.getDouble(3);
						}
						SQLHelper SQL_1 = new SQLHelper();
						SQL_1.getConnection();
						SQL_1.exesql("select * from Stop where name='"
								+NodeTable[i].getName()+ "'");
						ResultSet ss = SQL.rs;
						while (ss.next()) {
							bb[0] = ss.getDouble(2);
							bb[1] = ss.getDouble(3);
						}
						SQLHelper  SQL_2= new SQLHelper();
				    	SQL_2.getConnection();
				    	SQL_2.exesql("select speed  from Route1 where route in (select substring(route,0,charindex('(',route))  from stop_route where route='"+route+"')");
				    	ResultSet is = SQL.rs;
						while (is.next()) {
							speed = is.getInt(1);	
						}
						double w = MapDistance.GetDistance(aa[0], aa[1], bb[0],
								bb[1]);
						
						//EdgeTable[numEdges]=new Edge();
						EdgeTable[numEdges-1].setCost(w/speed);
						EdgeTable[numEdges-1].setInfoEdge(route);
						System.out.println(EdgeTable[numEdges-1].getCost());
					} 
					if (flag == false&&flag1==true) {
						a.addEdge(NodeTable[y], NodeTable[numVertices-1]);
						System.out.println(NodeTable[y].getName()+"->"+NodeTable[numVertices-1].getName());
						SQLHelper SQL = new SQLHelper();
						SQL.getConnection();
						SQL.exesql("select * from Stop where name='"
								+ NodeTable[y].getName() + "'");
						ResultSet os = SQL.rs;
						while (os.next()) {
							aa[0] = os.getDouble(2);
							aa[1] = os.getDouble(3);
						}
						SQLHelper SQL_1 = new SQLHelper();
						SQL_1.getConnection();
						SQL_1.exesql("select * from Stop where name='"
								+ NodeTable[numVertices-1].getName() + "'");
						ResultSet ss = SQL.rs;
						while (ss.next()) {
							bb[0] = ss.getDouble(2);
							bb[1] = ss.getDouble(3);
						}
						SQLHelper  SQL_2= new SQLHelper();
				    	SQL_2.getConnection();
				    	SQL_2.exesql("select speed  from Route1 where route in (select substring(route,0,charindex('(',route))  from stop_route where route='"+route+"')");
				    	ResultSet is = SQL.rs;
						while (is.next()) {
							speed = is.getInt(1);	
						}
						double w = MapDistance.GetDistance(aa[0], aa[1], bb[0],
								bb[1]);
						
						//EdgeTable[numEdges]=new Edge();
						EdgeTable[numEdges-1].setCost(w/speed);
						EdgeTable[numEdges-1].setInfoEdge(route);
						System.out.println(EdgeTable[numEdges-1].getCost());
					} 
					if (flag == true&&flag1==true) {
						a.addEdge(NodeTable[y], NodeTable[i]);
						System.out.println(NodeTable[y].getName()+"->"+NodeTable[i].getName());
						SQLHelper SQL = new SQLHelper();
						SQL.getConnection();
						SQL.exesql("select * from Stop where name='"
								+ NodeTable[y].getName() + "'");
						ResultSet os = SQL.rs;
						while (os.next()) {
							aa[0] = os.getDouble(2);
							aa[1] = os.getDouble(3);
						}
						SQLHelper SQL_1 = new SQLHelper();
						SQL_1.getConnection();
						SQL_1.exesql("select * from Stop where name='"
								+NodeTable[i].getName()+ "'");
						ResultSet ss = SQL.rs;
						while (ss.next()) {
							bb[0] = ss.getDouble(2);
							bb[1] = ss.getDouble(3);
						}
						SQLHelper  SQL_2= new SQLHelper();
				    	SQL_2.getConnection();
				    	SQL_2.exesql("select speed  from Route1 where route in (select substring(route,0,charindex('(',route))  from stop_route where route='"+route+"')");
				    	ResultSet is = SQL.rs;
						while (is.next()) {
							speed = is.getInt(1);	
						}
						double w = MapDistance.GetDistance(aa[0], aa[1], bb[0],
								bb[1]);
						
						//EdgeTable[numEdges]=new Edge();
						EdgeTable[numEdges-1].setCost(w/speed);
						EdgeTable[numEdges-1].setInfoEdge(route);
						System.out.println(EdgeTable[numEdges-1].getCost());
					} 
					if (flag == false&&flag1==false){
					//	System.out.println(numVertices-1);
					
						a.addEdge(NodeTable[numVertices - 2],NodeTable[numVertices-1]);
						System.out.println(NodeTable[numVertices - 2].getName()+"->"+NodeTable[numVertices-1].getName());
						SQLHelper SQL = new SQLHelper();
						SQL.getConnection();
						SQL.exesql("select * from Stop where name='"
						+ NodeTable[numVertices - 2].getName()+ "'");
						ResultSet os = SQL.rs;
						while (os.next()) {
							aa[0] = os.getDouble(2);
							aa[1] = os.getDouble(3);
			    	}
			    	SQLHelper  SQL_1= new SQLHelper();
			    	SQL_1.getConnection();
			    	SQL_1.exesql("select * from Stop where name='"+NodeTable[numVertices-1].getName()+"'");
			    	ResultSet ss=SQL.rs;
			    	while(ss.next()){
			    		bb[0]=ss.getDouble(2);
			    		bb[1]=ss.getDouble(3);
			    	}
			    	SQLHelper  SQL_2= new SQLHelper();
			    	SQL_2.getConnection();
			    	SQL_2.exesql("select speed from Route1 where route in (select substring(route,0,charindex('(',route))  from stop_route where route='"+route+"')");
			    	ResultSet is = SQL.rs;
					while (is.next()) {
						speed = is.getInt(1);	
					}
			    	double w=MapDistance.GetDistance(aa[0],aa[1],bb[0],bb[1]);
					EdgeTable[numEdges-1].setCost(w/speed);
					EdgeTable[numEdges-1].setInfoEdge(route);
					System.out.println(EdgeTable[numEdges-1].getCost());
					}
					
				}
			flag=false;	
			flag1=false;
			count++;		
			}
			System.out.println(numVertices);
			System.out.println(numEdges);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

    }

}


