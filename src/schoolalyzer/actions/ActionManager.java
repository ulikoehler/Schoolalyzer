/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolalyzer.actions;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author uli
 */
public class ActionManager {

    private static ActionManager instance = null;
    private HashMap<String, Class<? extends AbstractCellAction>> actions = new HashMap<String, Class<? extends AbstractCellAction>>();

    public static ActionManager getInstance() {
        if (instance == null) {
            instance = new ActionManager();
        }
        return instance;
    }

    public ActionManager() {
        //Register the default actions
        actions.put("Summieren", SumCellAction.class);
        actions.put("Mittelwert (arithmetisch)", AverageCellAction.class);
    }

    public AbstractCellAction getActionInstance(String name, int row, int column) {
        try {
            return actions.get(name).getConstructor(int.class, int.class).newInstance(row, column);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void addAction(String name, Class<? extends AbstractCellAction> action) {
        actions.put(name, action);
    }

    /**
     * @return A set of all action names
     */
    public Set<String> getActionNames() {
        return actions.keySet();
    }
}
