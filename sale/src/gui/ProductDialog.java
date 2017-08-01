package gui;

import java.math.BigDecimal;
import domain.Product;
import dao.ProductList;
import gui.helpers.SimpleListModel;
import java.util.Collection;

/**
 *
 * @author liji8162
 */
public class ProductDialog extends javax.swing.JDialog {
	/**this instance of list from dao package is the list holds all the product objects that 
	 * typed by users*/
	private ProductList myProductList = new ProductList();
	SimpleListModel mySimpleListModel = new SimpleListModel();
	

	/**
	 * Creates new form ProductDialog
	 */
	public ProductDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		/*make combocategory editable so that users ar able to type new 
		category in the combo box*/
		comboCategory.setEditable(true);
		/*create an ArrayList to hold categories which are retrieved from calling 
		getCategories method*/
		Collection<String> myCategories = myProductList.getCategories();
		mySimpleListModel.updateItems(myCategories);
		this.comboCategory.setModel(mySimpleListModel);
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
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      jLabel5 = new javax.swing.JLabel();
      jLabel6 = new javax.swing.JLabel();
      txtID = new javax.swing.JTextField();
      txtName = new javax.swing.JTextField();
      txtPrice = new javax.swing.JTextField();
      txtQuantity = new javax.swing.JTextField();
      jScrollPane1 = new javax.swing.JScrollPane();
      txtDescription = new javax.swing.JTextArea();
      saveButton = new javax.swing.JButton();
      cancelButton = new javax.swing.JButton();
      comboCategory = new javax.swing.JComboBox<>();
      labelTitle = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      jLabel1.setText("ID:");
      jLabel1.setName("jLabel1"); // NOI18N

      jLabel2.setText("Name:");
      jLabel2.setName("jLabel2"); // NOI18N

      jLabel3.setText("Description:");
      jLabel3.setName("jLabel3"); // NOI18N

      jLabel4.setText("Category:");
      jLabel4.setName("jLabel4"); // NOI18N

      jLabel5.setText("Price:");
      jLabel5.setName("jLabel5"); // NOI18N

      jLabel6.setText("Quantity:");
      jLabel6.setName("jLabel6"); // NOI18N

      txtID.setName("txtID"); // NOI18N

      txtName.setName("txtName"); // NOI18N

      txtPrice.setName("txtPrice"); // NOI18N

      txtQuantity.setName("txtQuantity"); // NOI18N

      jScrollPane1.setName("jScrollPane1"); // NOI18N

      txtDescription.setColumns(20);
      txtDescription.setRows(5);
      txtDescription.setName("txtDescription"); // NOI18N
      jScrollPane1.setViewportView(txtDescription);

      saveButton.setText("Save");
      saveButton.setName("saveButton"); // NOI18N
      saveButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            saveButtonActionPerformed(evt);
         }
      });

      cancelButton.setText("Cancel");
      cancelButton.setName("cancelButton"); // NOI18N
      cancelButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            cancelButtonActionPerformed(evt);
         }
      });

      comboCategory.setName("comboCategory"); // NOI18N
      comboCategory.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            comboCategoryActionPerformed(evt);
         }
      });

      labelTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      labelTitle.setText("Product Editor");
      labelTitle.setName("labelTitle"); // NOI18N

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(38, 38, 38)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(66, 66, 66)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                     .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addGroup(layout.createSequentialGroup()
                  .addGap(85, 85, 85)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                        .addComponent(txtQuantity))))))
         .addGroup(layout.createSequentialGroup()
            .addGap(115, 115, 115)
            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
            .addGap(240, 240, 240)
            .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
            .addGap(327, 327, 327))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
            .addGap(28, 28, 28)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1)
               .addComponent(txtID))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addGroup(layout.createSequentialGroup()
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jLabel2)
                  .addGap(18, 18, 18)
                  .addComponent(jLabel3)
                  .addGap(0, 0, Short.MAX_VALUE))
               .addGroup(layout.createSequentialGroup()
                  .addGap(12, 12, 12)
                  .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
            .addGap(6, 6, 6)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel4)
               .addComponent(comboCategory))
            .addGap(30, 30, 30)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtPrice)
               .addComponent(jLabel5))
            .addGap(28, 28, 28)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtQuantity)
               .addComponent(jLabel6))
            .addGap(40, 40, 40)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(32, 32, 32))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
      	
		/**convert values to right formats*/
		Integer id = new Integer(txtID.getText());
		BigDecimal price = new BigDecimal(txtPrice.getText());
		Integer quantity = new Integer(txtQuantity.getText());
		
		/**create an instance of product to store all the values held 
		 * by text fields.*/
		
		Product product = new Product();
		product.setId(id);
		product.setName(txtName.getText());
		product.setDescription(txtDescription.getText());
		product.setCategory((String)comboCategory.getSelectedItem());
		product.setPrice(price);
		product.setQuantity(quantity);
		/**store this instance of product into myProductList*/
		myProductList.addProduct(product);
		dispose();
		
		
   }//GEN-LAST:event_saveButtonActionPerformed

   private void comboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoryActionPerformed

		
		
		
   }//GEN-LAST:event_comboCategoryActionPerformed

   private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed

		dispose();
   }//GEN-LAST:event_cancelButtonActionPerformed

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
			java.util.logging.Logger.getLogger(ProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				ProductDialog dialog = new ProductDialog(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton cancelButton;
   private javax.swing.JComboBox<String> comboCategory;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JLabel labelTitle;
   private javax.swing.JButton saveButton;
   private javax.swing.JTextArea txtDescription;
   private javax.swing.JTextField txtID;
   private javax.swing.JTextField txtName;
   private javax.swing.JTextField txtPrice;
   private javax.swing.JTextField txtQuantity;
   // End of variables declaration//GEN-END:variables
}
