package currency_changer;
 

class currency {

	private  String name;
	private Character sympol;
	
	 
	public currency(String name,Character sympol){
		
	  this.name=name;
	  this.sympol=sympol;
	  
	}
	
	@Override
	public String toString() {
		return String.format(this.name+" ( "+this.sympol+" )");
	}
}
