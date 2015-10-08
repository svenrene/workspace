package wbs.staticinit.derby;

import wbs.staticinit.IConnection;
import wbs.staticinit.IStatement;

public class DerbyConnection implements IConnection {

	@Override
	public IStatement createStatement() {
		return new DerbyStatement();
	}

}
