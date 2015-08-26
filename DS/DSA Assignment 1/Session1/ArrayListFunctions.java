package Session1;

/**
 * @author Deepali
 *
 */
public class ArrayListFunctions {
	
	int i = 0;
	Object array[] = new Object[10];
	Object arrayNew[];
	

	/**
	 * @return the array
	 */
	public Object[] getArray() {
		return array;
	}

	/**
	 * @param array the array to set
	 */
	public void setArray(Object[] array) {
		this.array = array;
	}

	
	/**Add Element function
	 * @param object :pass which type of object to add
	 */
	public void addItem(Object object)
	{
		int length = array.length;
		if(i < length) {
			array[i] = object;
			i++;
		}
		else {
			arrayNew = new Object[length*2+2];
			for(int count = 0; count < array.length; count++)
				arrayNew[count] = array[count];
			array = arrayNew;
			array[i] = object;
		}
	}
	
	/** Adding item at particular index
	 * @param object :pass which type of object to add
	 * @param index :at which index
	 */
	public void addItem(Object object, int index)
	{
		int length = array.length;
		if(index > length||index>i)
		{
			System.out.println("Index value must by less than length of array."
					+ " currently length of array is: "+i);
		}
		else
		{
			if(i == length)
			{
				arrayNew = new Object[length*2+2];
				for(int count = 0; count < array.length; count++)
					arrayNew[count] = array[count];
				array = arrayNew;
				array[i] = object;
			}
			
			for(int count = i; count > index ; count--)
			{
				array[count] = array[count-1];
			}
			array[index] = object;
			i++;
		}
	}
	
	/** To find first occurence of element
	 * @param object :pass which object to find
	 * @param index :after which index
	 * @return :return position
	 */
	public int firstOcccurence(Object object, int index)
	{
		for(int count = index; count < i; count++)
		{
			if((int)object == (int)array[count])
			{
				return count;
			}
		}
		return -1;
	}
	
	/** To find first index of element
	 * @param object :pass which object to find
	 * @return :index of element
	 */
	public int firstIndex(Object object)
	{
		for(int count = 0; count < i; count++)
		{
			if((int)object == (int)array[count])
			{
				return count;
			}
		}
		return -1;
	}
	
	/**To remove Element
	 * @param index :at which index
	 */
	public void remove(int index)
	{
		for(int count = index; count < i; count++)
		{
			array[count] = array[count+1];
		}
		i--;
	}
	
	/**
	 * @param object :which element to be removed 
	 */
	public void remove(Object object)
	{
		int count;
		for(count = 0; count < i; count++)
		{
			if(array[count] == object)
				break;
		}
		for(int counter = count; counter < i; counter++)
		{
			array[counter] = array[counter+1];
		}
		i--;
	}
	
	/**
	 * To clear Array list
	 */
	public void clear()
	{
		arrayNew = new Object[10];
		array = arrayNew;
		i = 0;
	}
	
	/**
	 * To reverse array list
	 */
	public void reverse()
	{
		arrayNew = new Object[i];
		int countArray = i-1;
		for(int count = 0; count < i; count++)
		{
			arrayNew[count] = array[countArray];
			countArray--;
		}
		array = arrayNew;
	}
	
	 /**To Merge To list in First list
	 * @param object :Reference of Second List
	 */
	public void merge(ArrayListFunctions object)
	{ 
		int totalLength = this.i + object.i;
		 
		 
		if(totalLength >= this.i)
		{
		
			this.arrayNew = new Object[totalLength];
			for(int count = 0; count < this.i; count++)
			{
				this.arrayNew[count] = this.array[count];
				 System.out.println(""+this.arrayNew[count]);
			}
			
			int secondArrayCount = 0;
			for(int count = this.i; count<totalLength; count++)
			{
				this.arrayNew[count] = object.array[secondArrayCount];
				secondArrayCount++;
			}
			this.array = this.arrayNew;
			this.i = totalLength;
		}
		
	}
	
	
	/**
	 *To display ArrayList 
	 */
	public void show()
	{
		for(int count = 0; count < i; count++)
		{
			System.out.println(array[count]);
		}
	}
	
	/**
	 *To sort arrayList 
	 */
	public void sort() {
		for (int count = 0; count < i; count++) {
			for (int count1 = count + 1; count1 < i; count1++) {
				int temp;
				if ((int) array[count] > (int) array[count1]) {
					temp = (int) array[count];
					array[count] = array[count1];
					array[count1] = temp;
				}
			}
		}
	}
}
