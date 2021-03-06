package gui;

import dao.DAOException;
import dao.ProductDao;
import java.math.BigDecimal;
import domain.Product;
import gui.helpers.SimpleListModel;
import gui.helpers.ValidationHelper;
import java.util.Collection;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author liji8162
 */
public class ProductDialog extends javax.swing.JDialog {

	/**
	 * this instance of list from dao package is the list holds all the product
	 * objects that typed by users since the collection of Product is static, we
	 * can refer it in the entire system
	 */
	private final ProductDao productDao;
	SimpleListModel mySimpleListModel = new SimpleListModel();
	Product product = new Product();
	ValidationHelper validationHelper = new ValidationHelper();

	/**
	 * Creates new form ProductDialog
	 */
	public ProductDialog(java.awt.Window parent, boolean modal, ProductDao productDao) {
		super(parent);
		super.setModal(modal);
		this.productDao = productDao;
		initComponents();
		/*make combocategory editable so that users ar able to type new 
		category in the combo box*/
		comboCategory.setEditable(true);
		/*create an ArrayList to hold categories which are retrieved from calling 
		getCategories method*/
		Collection<String> myCategories = productDao.getCategories();
		mySimpleListModel.updateItems(myCategories);
		this.comboCategory.setModel(mySimpleListModel);
		//add a formatter to the price id, and quantity
		validationHelper.addTypeFormatter(txtPrice, "#0.00", BigDecimal.class);
		validationHelper.addTypeFormatter(txtID, "#0", Integer.class);
		validationHelper.addTypeFormatter(txtQuantity, "#0", Integer.class);
	}

	public ProductDialog(java.awt.Window parent, boolean modal, Product product, ProductDao productDao) {
		this(parent, modal, productDao);
		this.product = product;

		this.txtID.setValue(this.product.getId());
		this.txtName.setText(this.product.getName());
		this.txtPrice.setValue(this.product.getPrice());
		this.txtQuantity.setValue(this.product.getQuantity());
		this.txtDescription.setText(this.product.getDescription());
		this.comboCategory.setSelectedItem(this.product.getCategory());

		/**
		 * id is the key, can not be changed
		 */
		this.txtID.setEditable(false);
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
      txtName = new javax.swing.JTextField();
      jScrollPane1 = new javax.swing.JScrollPane();
      txtDescription = new javax.swing.JTextArea();
      saveButton = new javax.swing.JButton();
      cancelButton = new javax.swing.JButton();
      comboCategory = new javax.swing.JComboBox<>();
      labelTitle = new javax.swing.JLabel();
      txtID = new javax.swing.JFormattedTextField();
      txtPrice = new javax.swing.JFormattedTextField();
      txtQuantity = new javax.swing.JFormattedTextField();

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

      txtName.setName("txtName"); // NOI18N

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

      txtID.setName("txtID"); // NOI18N
      txtID.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtIDActionPerformed(evt);
         }
      });

      txtPrice.setName("txtPrice"); // NOI18N

      txtQuantity.setName("txtQuantity"); // NOI18N

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(115, 115, 115)
            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(240, 240, 240)
            .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(190, 190, 190))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
            .addGap(115, 115, 115)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(txtPrice)
               .addComponent(txtQuantity)
               .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(91, 91, 91))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(98, 98, 98)
                  .addComponent(jLabel1))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGap(31, 31, 31)
                  .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
            .addGap(6, 6, 6)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel4)
               .addComponent(comboCategory))
            .addGap(30, 30, 30)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel5)
               .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(28, 28, 28)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel6)
               .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(40, 40, 40)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(32, 32, 32))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
		/**
		 * create an instance of product to store all the values held by text
		 * fields.
		 */
		try{
		this.product.setId((Integer) txtID.getValue());
		this.product.setName(txtName.getText());
		this.product.setDescription(txtDescription.getText());
		this.product.setCategory((String) comboCategory.getSelectedItem());
		this.product.setPrice((BigDecimal) txtPrice.getValue());
		this.product.setQuantity((Integer) txtQuantity.getValue());
		/**
		 * store this instance of product into myProductList
		 */
		boolean flag = validationHelper.isObjectValid(this.product);
		if (flag) {
			Product test = productDao.findProduct((Integer) txtID.getValue());
			if (test == null) {
				productDao.addProduct(product);
			} else {
				if (txtID.isEditable()) {
					int result = JOptionPane.showConfirmDialog(this, "The product you are "
							  + "adding has already existed. Are you sure you still want to"
							  + " add the Product?");
					if (result == JOptionPane.YES_OPTION) {
						productDao.addProduct(product);
					}
				} else {
					productDao.addProduct(product);
				}
			}
			dispose();
		}
		}
		catch(DAOException ex){
//			throw new DAOException(ex.getMessage(),ex);
			JOptionPane.showConfirmDialog(this,ex.getMessage());
		}
   }//GEN-LAST:event_saveButtonActionPerformed

   private void comboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoryActionPerformed


   }//GEN-LAST:event_comboCategoryActionPerformed

   private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed

		dispose();
   }//GEN-LAST:event_cancelButtonActionPerformed

   private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_txtIDActionPerformed


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
   private javax.swing.JFormattedTextField txtID;
   private javax.swing.JTextField txtName;
   private javax.swing.JFormattedTextField txtPrice;
   private javax.swing.JFormattedTextField txtQuantity;
   // End of variables declaration//GEN-END:variables
   

}


