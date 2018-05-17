package MyEmp;



public class EmpAction {

	private Emp emp = new Emp();
	public void setValue(String value) throws Exception{
		BeanOperation.setBeanValue(this,value);   //this 是action类的对象
	}
	
	public Emp getEmp() {
		return emp;
	}
}
