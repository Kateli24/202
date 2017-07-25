package gui;

/**
 *
 * @author liji8162
 */
public class ProductMainMenu extends javax.swing.JFrame {

	/**
	 * Creates new form ProductMainMenu
	 */
	public ProductMainMenu() {
		initComponents();
	}
	
	

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      addProductButton = new javax.swing.JButton();
      viewProductButton = new javax.swing.JButton();
      exitButton = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      jLabel1.setText("Product Administration");
      jLabel1.setName("jLabel1"); // NOI18N

      addProductButton.setText("Add a New Product");
      addProductButton.setName("addProductButton"); // NOI18N
      addProductButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            addProductButtonActionPerformed(evt);
         }
      });

      viewProductButton.setText("View Product");
      viewProductButton.setName("viewProductButton"); // NOI18N
      viewProductButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            viewProductButtonActionPerformed(evt);
         }
      });

      exitButton.setText("Exit");
      exitButton.setName("exitButton"); // NOI18N
      exitButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            exitButtonActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(105, 105, 105)
                  .addComponent(jLabel1))
               .addGroup(layout.createSequentialGroup()
                  .addGap(137, 137, 137)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(addProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                     .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(116, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(35, 35, 35)
            .addComponent(addProductButton)
            .addGap(39, 39, 39)
            .addComponent(viewProductButton)
            .addGap(44, 44, 44)
            .addComponent(exitButton)
            .addContainerGap(67, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void addProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductButtonActionPerformed
      
		/**a new instance of dialog to add new product will be activated once 
		 * the Add a New Product button is clicked*/
		 
		ProductDialog productDialog1 = new ProductDialog(this,true);
		productDialog1.setLocationRelativeTo(this);
		productDialog1.setVisible(true);
		
   }//GEN-LAST:event_addProductButtonActionPerformed

   private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
      // TODO add your handling code here:
		System.exit(0);
   }//GEN-LAST:event_exitButtonActionPerformed

   private void viewProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProductButtonActionPerformed
      
		
		/**a new instance of dialog to view products will be activated once 
		 * the View Products button is clicked*/
		ViewProductDialog viewProductDialog1 = new ViewProductDialog(this,true);
		viewProductDialog1.setLocationRelativeTo(this);
		viewProductDialog1.setVisible(true);
		
   }//GEN-LAST:event_viewProductButtonActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ProductMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ProductMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ProductMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ProductMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ProductMainMenu().setVisible(true);
			}
		});
	}

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton addProductButton;
   private javax.swing.JButton exitButton;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JButton viewProductButton;
   // End of variables declaration//GEN-END:variables
}
