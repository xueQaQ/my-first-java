//package Abstruct;
//
///*
// * 接口设计模式——工厂设计模式
// * 
// */
//
////传统设计模式
////interface IFruit{
////	public void eat();    //吃水果
////}
////
////class Apple implements IFruit{
////	public void eat() {
////		System.out.println("吃水果前需要洗");
////	}
////}
////
////class Watermelon implements IFruit{
////	public void eat() {
////		System.out.println("吃西瓜前需要切");
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
//		System.out.println("吃苹果前需要洗");
//	}
//}
//
//class Wastermelon implements IFruit{
//	public void eat() {
//		System.out.println("吃西瓜前需要切");
//	}
//}
//
//public class Testabstruct2 {
//	public static void main(String[] args) {
//		if (args.length == 0) {
//			System.out.println("没有传参数");
//			System.exit(1);
//		}
//		IFruit fruit = Factory.getInstance(args[0]);
//		fruit.eat();
//	}
//
//}
//
//
