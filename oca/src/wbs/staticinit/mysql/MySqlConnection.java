package wbs.staticinit.mysql;

import wbs.staticinit.IConnection;
import wbs.staticinit.IStatement;

public class MySqlConnection implements IConnection {

	@Override
	public IStatement createStatement() {
		return new MySqlStatement();
	}

}
