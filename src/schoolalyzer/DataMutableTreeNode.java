/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Provides a mutable tree node being able to save two additional objects ("data" and "type")
 * @author uli
 */
public class DataMutableTreeNode extends DefaultMutableTreeNode {

    private Object data = null;
    private Object type = null;

    DataMutableTreeNode(String string) {
        super(string);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }
}
