package org.robobinding.viewattribute.event;

import org.robobinding.attribute.Command;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class MockCommand implements Command {
    public Object lastArg;
    public int invocationCount;
    @Override
    public void invoke(Object arg) {
	lastArg = arg;
	invocationCount++;
    }

}
