//package Abstruct;
//
///*
// * �ӿ����ģʽ�����������ģʽ
// * 
// */
//
////��ͳ���ģʽ
////interface IFruit{
////	public void eat();    //��ˮ��
////}
////
////class Apple implements IFruit{
////	public void eat() {
////		System.out.println("��ˮ��ǰ��Ҫϴ");
////	}
////}
////
////class Watermelon implements IFruit{
////	public void eat() {
////		System.out.println("������ǰ��Ҫ��");
////	}
////}
////
////public class Testabstruct2 {
////	public static void main(String[] args) {
////		IFruit fruit1 = new Apple();
////		fruit1.eat();
////		IFruit fruit2 = new Watermelon();
////		fruit2.eat();
////	}
////	
////}
//
//interface IFruit{
//	public void eat();
//}
//
//class Factory{
//	public static IFruit getInstance(String className) {
//		if ("apple".equals(className)) {
//			return new Apple();
//		}
//		if("wastermelon".equals(className)) {
//			return new Wastermelon();
//		}
//		return null;
//	}
//}
//
//class Apple implements IFruit{
//	public void eat() {
//		System.out.println("��ƻ��ǰ��Ҫϴ");
//	}
//}
//
//class Wastermelon implements IFruit{
//	public void eat() {
//		System.out.println("������ǰ��Ҫ��");
//	}
//}
//
//public class Testabstruct2 {
//	public static void main(String[] args) {
//		if (args.length == 0) {
//			System.out.println("û�д�����");
//			System.exit(1);
//		}
//		IFruit fruit = Factory.getInstance(args[0]);
//		fruit.eat();
//	}
//
//}
//
//
