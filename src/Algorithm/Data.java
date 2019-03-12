package Algorithm;

public class Data {
	
    private int numbers[];
    public int l, r;
    public boolean fixedPivots[];
    public int curPivot;
    public int curElement;

	public Data(int N,int radomBounded) {
		// TODO Auto-generated constructor stub
		numbers=new int[N];
		fixedPivots=new boolean[N];

        for( int i = 0 ; i < N ; i ++) {
            numbers[i] = (int)(Math.random()*radomBounded);
            fixedPivots[i] = false;
//            System.out.print("DEBUG");
            System.out.print(" "+numbers[i]);
        }
        System.out.println();
	}
	
	
	public int get(int index) {
        if( index < 0 || index >= numbers.length)
            throw new IllegalArgumentException("Invalid index to access Sort Data.");
		return numbers[index];
	}
	
	
    public int N(){
        return numbers.length;
    }
	//Swap¤èªk
    public void swap(int i, int j) {
    	
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}
