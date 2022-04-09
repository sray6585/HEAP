package HEAP;
import java.util.*;
public class Heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Heaps h=new Heaps();
		System.out.println("enter the length");
		int n=sc.nextInt();
		h.insert(5);h.insert(6);h.insert(2);h.insert(1);
		System.out.println(h.remove());System.out.println(h.remove());System.out.println(h.getMin());System.out.println(h.remove());
		System.out.println(h.remove());System.out.println(h.remove());System.out.println(h.remove());
	}

}
class Heaps
{
	ArrayList<Integer> a;
	Heaps()
	{
		a=new ArrayList<>();
	}
	int getMin()
	{
		if(a.size()==0)
			return -1;
		return a.get(0);
	}
	void insert(int val)
	{
		a.add(val);
		int child=a.size()-1;
		int parent=(child-1)/2;
		while(child!=0)
		{
			if(a.get(child)<a.get(parent))
			{
				int temp=a.get(child);
				a.set(child, a.get(parent));
				a.set(parent,temp);
				child=parent;
				parent=(child-1)/2;
			}
			else
				return;
		}
	}
	int remove()
	{
		if(a.size()==0)
			return -1;
		int val=a.get(0);
		a.set(0, a.get(a.size()-1));
		a.remove(a.size()-1);
		int parent=0;
		int child1=2*parent+1;
		int child2=2*parent+2;
		while(child1<a.size())
		{
			int min=parent;
			if(a.get(child1)<a.get(min))
				min=child1;
			if(child2<a.size() && a.get(child2)<a.get(min))
				min=child2;
			if(min==parent)
				return val;
			int temp=a.get(parent);
			a.set(parent, a.get(min));
			a.set(min,temp);
			parent=min;
			child1=2*parent+1;
			child2=2*parent+2;
		}
		
		return val;
	}
}