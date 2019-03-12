package ViewFrame;

//import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Algorithm.Data;

public class QuickSortFrame extends JFrame {

	
    private int canvasWidth;
    private int canvasHeight;
	private Data quickSortDatas;
	
	public QuickSortFrame(int canvasWidth,int cavasHeight) {
		this.canvasWidth=canvasWidth;
		this.canvasHeight=cavasHeight;
		
		QuickSortPanel panel =new QuickSortPanel();
		setContentPane(panel);
		
		Dimension dimension= new Dimension(canvasWidth, cavasHeight);
		panel.setPreferredSize(dimension);
		pack();
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
		
	}
	
	public void render(Data quickSoData) {
		this.quickSortDatas=quickSoData;
		repaint();
	}
	

	private class QuickSortPanel extends JPanel{
		
		/*
		 * public QuickSortPanel() { super(true); }
		 */

//		@Override
//		public void setPreferredSize(Dimension preferredSize) {
//			// TODO Auto-generated method stub
//			super.setPreferredSize(preferredSize);
//		}

		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			
			Graphics2D graphics2d =(Graphics2D)arg0;
			
			
            int w = canvasWidth/quickSortDatas.N();
            
            for(int i = 0 ; i < quickSortDatas.N() ; i ++ ) {
                if ( i >= quickSortDatas.l && i <= quickSortDatas.r)
                    QuickSortHelper.setColor(graphics2d, QuickSortHelper.Green);
                else
                	QuickSortHelper.setColor(graphics2d, QuickSortHelper.Grey);

                if( i == quickSortDatas.curPivot )
                	QuickSortHelper.setColor(graphics2d, QuickSortHelper.Red);
                if( i == quickSortDatas.curElement)
                	QuickSortHelper.setColor(graphics2d, QuickSortHelper.Purple);
                if( quickSortDatas.fixedPivots[i] )
                	QuickSortHelper.setColor(graphics2d, QuickSortHelper.Yellow);
                
                System.out.println("x: "+i*w+"y:"+ (canvasHeight - quickSortDatas.get(i)));
                QuickSortHelper.fillRectangle(graphics2d, i * w, canvasHeight - quickSortDatas.get(i), w -2, quickSortDatas.get(i));
            }
		}

//		@Override
//		public Dimension getPreferredSize() {
//			// TODO Auto-generated method stub
//			return new Dimension(canvasWidth,canvasHeight);
//		}
		
		//
		
		
	}
	
	
}


