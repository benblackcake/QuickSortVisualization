package Algorithm;

import ViewFrame.QuickSortFrame;
import ViewFrame.QuickSortHelper;

public class AlgorithmVisualize {

	
	private static final int DELAY = 40;
	private Data quickSortDatas;
	private QuickSortFrame quickSortFrame;
	
	public AlgorithmVisualize(int height,int weight,int N) {
		
		quickSortDatas=new Data(N, height);
		quickSortFrame=new QuickSortFrame(weight, height);
//		Thread thread =new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//				
//				run();
//			}
//		});
//		
//		thread.setDaemon(true);
//		thread.start();
		run();
		System.out.println("");
	//	printData();
		
	}
	
	private void run() {
		setData(0,0,0,0,0);
		quickSort(0, quickSortDatas.N()-1);
//		setData(0,0,0,0,0);
	}
	
	
	
	
	private void quickSort(int l,int r) {
		/*Debug*/
		
//		System.out.println(""+quickSortDatas.l);
//        if( l > r )
//            return;
//		
//        if( l == r ){
//            setData(l, r, l, 0, 0);
//            return;
//        }
		
		if(l<r) {
//			System.out.println("DEBUG");
			setData(l, r, 0, 0, 0);
			int pk=partition(l, r);
			quickSort(l, pk-1);
			quickSort(pk+1, r);
		}else 
			setData(l, r,l,0,0);
		
	}
	
	
	
	private int partition(int l,int r) {
		
		int v=quickSortDatas.get(r);//³Ì«á­È·ípivot
		setData(l, r, 0, r, 0);
		//int j=l+1;
		int i=l-1;
		for(int j=l;j<=r;j++) {
			setData(l, r, 0, r, j);
			if(quickSortDatas.get(j)<v) {
				i++;
				quickSortDatas.swap(i, j);
				//setData(l, r, 0, l, j);
			}
			
		}
		quickSortDatas.swap(i+1, r);
		setData(l, r, i+1, 0, 0);
		return i+1;
	}
	
	private void setData(int l,int r ,int fixPivot,int curPivot,int curelement) {
		quickSortDatas.l=l;
		quickSortDatas.r=r;
        if(fixPivot != -1)
            quickSortDatas.fixedPivots[fixPivot] = true;
		quickSortDatas.curPivot=curPivot;
		quickSortDatas.curElement=curelement;
		
		quickSortFrame.render(quickSortDatas);
		QuickSortHelper.pause(DELAY);
	}
	
	private void printData() {
		
		for(int i=0;i<quickSortDatas.N()-1;i++) {
			System.out.print(" "+quickSortDatas.get(i));
		}
	}
	
	
	public static void main(String[] args) {
        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 100;
		// TODO Auto-generated method stub
		AlgorithmVisualize alg=new AlgorithmVisualize(sceneWidth,sceneHeight,N);
//		System.out.println();
//		System.out.println(alg.quickSortDatas.curPivot);
		
		
	}

}
