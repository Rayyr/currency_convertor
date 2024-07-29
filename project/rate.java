package currency_changer;

class rate {

     currency one,two;
	 double ratevalue;
	
	rate(currency one,currency two,double ratevalue){
		
		this.one=one;
		this.two=two;
		this.ratevalue=ratevalue;
	} 
	
	rate(rate x,double value){
		
		this.one=x.one;
		this.two=x.two;
		this.ratevalue = value; 
		 
		
	}
	

	rate(rate x ){
		
		this.one=x.one;
		this.two=x.two;
		this.ratevalue = x.ratevalue; 
		 
		
	}
	
    
	
	@Override
	public String toString() {
		
		return String.format("1 "+this.one+" = "+this.ratevalue+" "+this.two);
		
	}
}
