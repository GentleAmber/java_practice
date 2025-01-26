public class ArrayDetails{
	public static void main(String[] args){
		//1. Array is a combination of the same type of data
		//2. Any type of data can be stored in arrays, Primitive types and reference types
		//included, but mixed types of data cannot be stored in one array.
		//3. Upon Creating the array without giving it values, the default values
		//for different data types are:
		//int 0, short 0, byte 0, long 0, float 0.0, double 0.0, char \u0000
		//boolean false, String null
		short[] arrayShort = new short[3];
		System.out.println("Default values for arrayShort: ");
		for (int i = 0; i < arrayShort.length; i++){
			System.out.print(arrayShort[i] + " ");
		}
		System.out.print("\n");
		//4. ... 5. ...
		//6. Have to use the indices with in the length, or will prompt 
		//ArrayIndexOutOfBoundsException error
		//7. The data type of array is reference type. Array is an object.
	}
}