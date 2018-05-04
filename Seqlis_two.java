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
	private Node first;    //ͷ���
	private Node last;	   //β���
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
	
	//�ڲ���
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
	
	public void add(Object obj) {   //β�巨
		Node cur = this.last;       //����β���ڵ��ַ
		Node newNode = new Node(cur, obj, null);
		if(cur == null) {
			this.first = newNode;
		}else {
		newNode.prev = cur;
		cur.next = newNode;
		this.last = newNode;
		}
		++size;
		
		//����
//		Node cur = this.last;       //����β���ڵ��ַ
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
		//���±�ɾ��Ԫ��
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
	
	//���߷���
	private boolean isElementIndex(int index) {
		return index <= size && index > 0;
	}
	
	private Node node(int index) {
		
		//�ڿƼ�
		
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
		//�ж�ֵ�Ƿ����
		Node temp = this.first;
		for(; temp != null; temp = temp.next) {
			if(temp == obj) {
				return true;
			}
		}
		return false;	
		
		//�򵥴���
		//return indexOf(obj) != -1;
	}
	public int indexOf(Object obj) {
		//����Ԫ�ػ�ȡ�±�
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
		//���±��滻Ԫ��
		if(!((index<0)&&(index>size))) {
			return false;
		}
		Node node = node(index);
		node.data = obj;
		return true;
	}
	public Object get(int index) {
		//�����±��ȡֵ
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
		//������
		return this.size;
	}
	public void clear() {
		//�������
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
	link.add("��ͷ");
	link.add("����1");
	link.add("����2");
	link.add("��β");
	link.printLink();
	System.out.println(link.length());
	System.out.println(link.contains("����3"));
	//System.out.println(link.indexOf("����2"));
	System.out.println(link.get(3));
	System.out.println(link.set(3, "����3"));
	System.out.println(link.get(3));
	link.clear();
	System.out.println(link.length());
	}
}
