
/*
 * Joe Zhang
 * Cs 201 Section 2
 * Lab 9
 * 03/29/2015
 * 
 * Encapsalated array of objects
 */

public class GenericList <T> {
	
	final int MAX_SIZE =  300;				//max size of the array
	final int DEFAULT_GROWTH_AMT = 50;	 	//Amount that list grows when at max size
	private Object[] objArray;				//instance for object array
	private int index;						//next empty slot
	private int iterator;					//used to keep track of positon when going thru list
	private int growthAmt;					//amount array grows
	
	//default constructor
	//instantiates the array with the constant
	public GenericList() {
		objArray = (T[]) new Object [MAX_SIZE];
		index = 0;
		setGrowthAmt(DEFAULT_GROWTH_AMT);
	}
	//nondefault constructor
	//instantiates the array with size
	public GenericList(int size){
		objArray = (T[] )new Object[size];
		index = 0;		
		setGrowthAmt(DEFAULT_GROWTH_AMT);
	}
	//nondefault constructor
	//instantiates the array with size and growth amount
	public GenericList(int size, int amountToGrowBy){
		objArray = (T[] )new Object[size];
		index = 0;		
		setGrowthAmt(amountToGrowBy);
	}
	
	//length	
	public int getLength(){
		return objArray.length;
	}
	//array			
	public T[] getArray(){
		return (T[])objArray;
	}
	
	//assign anArray to this array Note: this assumes that anArray is already 
	//a copy and will be called with setIndex() so that the index agrees with the data
	public void setArray(Object [] anArray){
		for(int i = 0; i < anArray.length; i++){
			objArray[i] = anArray[i];
		}
	}
	
	//index
	public int getIndex(){
		return index;
	}
		
	public void setIndex(int anIndex){
		index = anIndex;	
	}
	
	//element
	public T getElement(int pos){
		return (T) objArray[pos];
	}
	//assigns aObj to array at pos
	public void setElement(T aObj, int pos){
		objArray[pos] = aObj;	
	}

	//GrowthAmt
	public int getGrowthAmt(){
		return growthAmt;
	}
	public void setGrowthAmt(int growthAmt){
		this.growthAmt = growthAmt;
	}
		
	//iterates through the array and concatenates the elements into a string that is returned
	public String toString(){
		String toStrValue = "";
		for(int i = 0; i < getIndex(); i++){
			toStrValue += objArray[i] + " "; 
		}
		return toStrValue;
	}
	
	//returns true if anArray has same elements as this array, same index and is the same length as this array
	public boolean equals(GenericList anArray){
		if(toString().equals(anArray.toString()) && getIndex() == anArray.getIndex() &&
				getLength() == anArray.getLength()){
			return true;
		}
		else {
			return false;
		}
	}

	//store an element in the array
	// stores aStr in the  next empty slot in the array & increments the next empty slot variable
	public void add(T aObj){
		if(!isFull()){
			setElement(aObj, getIndex());
			setIndex(getIndex()+1); //increments index
		}else{
			increaseSize(getGrowthAmt());
			setElement(aObj, getIndex());
			setIndex(getIndex()+1); //increments index
		}
	}

	//deletes an element in the array
	// moves all elements from pos to array end  towards 0, decrements  the next empty slot variable
	public void delete(int pos){
		for(int i = pos; i<getIndex(); i++ ){
			setElement(getElement(i+1), i);
		}
		setIndex(getIndex()-1); //decrements index
	}
	
	//inserts an element in the array
	// moves all elements from pos towards end  
	// of array, inserts aStr & increments the next empty slot variable
	public void insert(T aObj, int pos){
		for(int i = getIndex(); i > pos; i--){ //moves the elements after pos by one slot
			setElement(getElement(i-1), i);
		}
		setElement(aObj, pos); //assigns value to position
		
		//checks if pos is outside current range of values in array and sets index to reflect last value
		if(pos > getIndex() +1){
			setIndex(pos+1);
		}
		else {
			setIndex(getIndex()+1); //increments index
		}
	}

	//finds an element in the array
	// searches the array for aStr and returns pos it is found or -1 if not found
	public int isThere(T aObj){
		int counter = 0;
		while(counter < getIndex() && !aObj.equals(getElement(counter)) ){
			counter++;
		}
		if(counter != index){
			return counter;
		}
		else {
			return -1;
		}
		
	}
	
	// deletes an object and returns prior position
	public int delete(T obj){
		int pos = isThere(obj);
		if(pos == -1){
			return -1;
		}
		else {
			for(int i = pos; i < getIndex(); i++){
				setElement(getElement(i+1), i);				
			}
			setIndex(getIndex()-1);
			return pos;
		}
	}
	
	// returns true is array is full
	public boolean isFull(){
		if(getIndex() == getLength())
			return true;
		else 
			return false;
	}
	
	//returns true if list is empty 
	public boolean isEmpty(){
		boolean empty = true;
		int counter = 0;
		while( counter < getIndex() && empty){
			if(!getElement(counter).equals(null))
				empty = false;
			counter++;
		}
		if( empty)
			return true;
		else 
			return false;
	}
		
	//clears all data from list
	public void clear(){
		for(int i = 0; i < getIndex(); i++){
			setElement(null, i);
		}
		setIndex(0);
	}
	
	//trims off excess storage
	public void trim(){
		Object[] temp = new Object[getIndex()];
		for(int i = 0; i < getIndex(); i++){
			temp[i] = getElement(i);
		}
		objArray = temp;
	}
	
	//allocates n times more memory
	public void increaseSize(int n){
		Object[] temp = new Object[objArray.length*n];
		for(int i = 0; i < getIndex(); i++){
			temp[i] = getElement(i);
		}
		objArray = temp;	 
	}
		
//=================================================	
	//iterator
	public void resetIterator(){
		iterator = 0;
	}
	
	public boolean hasNext(){
		if(iterator < getIndex())
			return true;
		else 
			return false;
	}
	
	public T getNext(){
		iterator++;
		return getElement(iterator-1);
	}

	public T getCurrent(){
		return getElement(iterator);
	}

	public void printContent(){
		resetIterator();
		while(hasNext()){
			System.out.println(iterator + ") " + getNext().toString());
		}
	}
	
}