package hr.fer.zemris.java.gui.prim;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;

/**
 * Program that shows two list's both showing the same values.
 * Values are prim numbers. By clicking button 'next' new prim number
 * is presented.
 * @author Vilim Staroveški
 *
 */
public class PrimDemo extends JFrame {
	
	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = 2552614965736703542L;
	
	/**
	 * Creates new {@link PrimDemo}.
	 */
	public PrimDemo() {
		this.setLocation(150, 150);
		this.setSize(600, 400);
		this.setTitle("PrimDemo");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		initGUI();
	}

	/**
	 * Initialises GUI for this program.
	 */
	private void initGUI() {
		getContentPane().setLayout(new BorderLayout());
		
		PrimListModel model = new PrimListModel();
		
		JList<Integer> rightList = new JList<Integer>(model);
		JList<Integer> leftList = new JList<Integer>(model);
		
		JScrollPane rightListPane = new JScrollPane(rightList);
		JScrollPane leftListPane = new JScrollPane(leftList);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                rightListPane, leftListPane);
		splitPane.setResizeWeight(0.5);
		
		JButton nextButton = new JButton("Next");
		nextButton.addMouseListener(new NextButtonListener(model));
		
		getContentPane().add(splitPane, BorderLayout.CENTER);
		getContentPane().add(nextButton, BorderLayout.SOUTH);
	}

	/**
	 * Method called on program start.
	 * @param args command line arguments. This program do not uses any arguments
	 * so therefore unnecessary
	 */
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater( () -> {
			JFrame primDemo = new PrimDemo();
			primDemo.setVisible(true);
		});
	}
	
	/**
	 * Listener for button 'next'. Sends information to list model to calculate 
	 * new prim number.
	 * @author Vilim Staroveški
	 *
	 */
	private class NextButtonListener implements MouseListener {
		
		/**
		 * List model that is being informed for clicks next button
		 */
		private PrimListModel model;
		
		/**
		 * Creates new {@link NextButtonListener} 
		 * @param model List model that is being informed for clicks next button
		 */
		public NextButtonListener(ListModel<Integer> model) {
			this.model = (PrimListModel) model;
		}

		@Override
		public void mouseClicked(MouseEvent e) {

			model.next();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
		
	}

}
