package thread;

class MyThread {
	private Object lock = new Object();
	// count表示循环次数
	private int count;
	// flag表示打印次数
	private int flag = 0;
	public MyThread(int count) {
		super();
		this.count = count;
	}
	public void fun() {
		Thread thread1 = new Thread(new Runnable() {		
			@Override
			public void run() {
				for(int i = 0; i < count; i++) {
					synchronized (lock) {
						if (Thread.currentThread().getName().equals("Thread-0")&&
								(flag % 3 == 0)) {
							System.out.print("*Thread-0");
							flag += 1;
							lock.notifyAll();
						}else {
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		});
		Thread thread2 = new Thread(new Runnable() {		
			@Override
			public void run() {
				for(int i = 0; i < count; i++) {
					synchronized (lock) {
						if (Thread.currentThread().getName().equals("Thread-1")&&
								(flag % 3 == 1)) {
							System.out.print("#Thread-1");
							flag += 1;
							lock.notifyAll();
						}else {
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		});
		Thread thread3 = new Thread(new Runnable() {		
			@Override
			public void run() {
				for(int i = 0; i < count; i++) {
					synchronized (lock) {
						if (Thread.currentThread().getName().equals("Thread-2")&&
								(flag % 3 == 2)) {
							System.out.println("@Thread-2");
							flag += 1;
							lock.notifyAll();
						}else {
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		});
		thread1.start();
		thread2.start();
		thread3.start();
	}
}



public class Test {
	public static void main(String[] args) {
		MyThread myThread = new MyThread(1000);
		myThread.fun();
	}
}
