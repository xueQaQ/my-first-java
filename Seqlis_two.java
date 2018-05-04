package Tree;

import javax.xml.transform.Templates;

interface Link{
	void add(Object obj);
	boolean remove(int index);
	boolean contains(Object obj);
	int indexOf(Object obj);
	boolean set(int index,Object obj);
	Object get(int index);
	int length();
	void clear();
	Object[] toArray();
	void printLink();
}
class Factory{
	private Factory(){}
	public static Link getLinkInstance() {
		return new LinkImpl();
	}
}
class LinkImpl implements Link{

	private int size;
	private Node first;    //头结点
	private Node last;	   //尾结点
	public Node getFirst() {
		return first;
	}
	public void setFirst(Node first) {
		this.first = first;
	}
	public Node getLast() {
		return last;
	}
	public void setLast(Node last) {
		this.last = last;
	}
	
	//内部类
	public class Node{
		private Node prev;
		private Object data;
		private Node next;
		private Node(Node prev,Object data,Node next){
			this.prev = prev;
			this.data = data;
			this.next = next;
		}
	}
	
	public void add(Object obj) {   //尾插法
		Node cur = this.last;       //保存尾部节点地址
		Node newNode = new Node(cur, obj, null);
		if(cur == null) {
			this.first = newNode;
		}else {
		newNode.prev = cur;
		cur.next = newNode;
		this.last = newNode;
		}
		++size;
		
		//代码
//		Node cur = this.last;       //保存尾部节点地址
//		Node newNode = new Node(cur, obj, null);
//		this.last = newNode;
//		if(this.first == null) {
//			this.first = newNode;
//		}else {
//			newNode.prev = temp;
//			cur.next = newNode;			
//		}
//		this.size++;
		
	}
	public boolean remove(int index) {
		//按下标删除元素
		if(!((index<0)&&(index>size))) {
			return false;
		}
		else {
			Node node = node(index);
			
			Node temp = node.prev;
			temp.next = node.next;
			node.next.prev = temp;
			
			node.next = null;
			node.prev = null;
			
			return true;
		}
	
	}
	
	//工具方法
	private boolean isElementIndex(int index) {
		return index <= size && index > 0;
	}
	
	private Node node(int index) {
		
		//黑科技
		
		if(!isElementIndex(index)) {
			return null;
		}else {
			if(index<(size>>1)) {
				Node temp = first;
				for(int i =0; i<index-1; i++) {
					temp = temp.next;
				}
				return temp;
			}else {
				Node temp = last;
				for(int i = size;i>index+1;i--) {
					temp = temp.prev;
				}
				return temp;
		}
	}
		
//		if(!((index<0)&&(index>size))) {
//			return null;
//		}
//		
//			Node temp = this.first;
//			int i = 0;
//			while(temp != null) {
//				temp = temp.next;
//				++i;
//				if(i == index) {
//					break;
//				}
//			}
//			return temp;
//		
		
	}
	public boolean contains(Object obj) {
		//判断值是否存在
		Node temp = this.first;
		for(; temp != null; temp = temp.next) {
			if(temp == obj) {
				return true;
			}
		}
		return false;	
		
		//简单代码
		//return indexOf(obj) != -1;
	}
	public int indexOf(Object obj) {
		//按照元素获取下标
		int index = 0;
		if (obj == null) {
			for (Node temp = first ; temp != null ; temp = temp.next) {
					if (temp.data == null) {
						return index;
					}
					index ++;
			}
		} else {
			for (Node temp = first ; temp != null ; temp = temp.next) {
				if (obj.equals(temp.data)) {
					return index;
				}
				index ++;
			}
		}
		return -1;
	}
//		int index = 0;
//		if(obj == null) {
//			
//		}
//		Node temp = this.first;
//		while(obj != temp.data) {
//			temp = temp.next;
//		}
//		return size;
//	}
	public boolean set(int index,Object obj) {
		//按下标替换元素
		if(!((index<0)&&(index>size))) {
			return false;
		}
		Node node = node(index);
		node.data = obj;
		return true;
	}
	public Object get(int index) {
		//按照下标获取值
		if(!isElementIndex(index)) {
			return null;
		}
		return node(index).data;
		
//		int i = 0;
//		Node temp = this.first;
//		for(; temp != null; temp = temp.next) {
//			if(i == index) {
//				return temp.data;
//			}
//			++i;
//		}
//		return false;	
	}
	public int length() {
		//链表长度
		return this.size;
	}
	public void clear() {
		//清除链表
		Node temp = this.first;
	
		while(temp != null) {
			Node cur = temp.next;
			temp.prev = null;
			temp.data = null;
			temp.next = null;
			temp = cur;
			size--;
		}
		this.first = this.last = null;
	}
	
	
	public Object[] toArray() {    
		
		Object[] value = new Object[size];
		int i = 0;
		Node temp = this.first;
		for(; temp != null; temp = temp.next) {
			value[i++] = temp.data;
		}
		return value;
	}
	
	
	public void printLink() {
		Object[] result = this.toArray();
		for (Object object : result) {
			System.out.println(object);
		}	
	}
}





public class Test06 {
	public static void main(String[] args) {
	Link link = Factory.getLinkInstance();
	link.add("火车头");
	link.add("车厢1");
	link.add("车厢2");
	link.add("火车尾");
	link.printLink();
	System.out.println(link.length());
	System.out.println(link.contains("车厢3"));
	//System.out.println(link.indexOf("车厢2"));
	System.out.println(link.get(3));
	System.out.println(link.set(3, "车厢3"));
	System.out.println(link.get(3));
	link.clear();
	System.out.println(link.length());
	}
}
