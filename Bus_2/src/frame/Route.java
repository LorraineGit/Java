package frame;

public class Route {
		String name;
	  	double speed;
		 int index;
		 int price;
		 int time;
		 int len=0;       //�����Ľڵ� ��
		 int i=0;
		 int passNode[]=new int[100];        //�����Ľڵ��
		public void addPassNode(int x){
			passNode[i++]=x;
		}
		public int getPassNodelen(){
			return len;
		}
		/**Nodes passed*/
		public int [] getPassNode(){
			return passNode;
		}
		public double getSpeed(){
			return speed;
		}
		public int getPrice(){
			return price;
		}
		public int gettime(){
			return time;
		}
		public void setName(String aname){name=aname;	}
		public String getName(){return name;	}

}
