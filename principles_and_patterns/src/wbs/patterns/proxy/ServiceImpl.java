package wbs.patterns.proxy;

public class ServiceImpl implements IService {

	@Override
	// die methode service() muss in einer transaktion abgewickelt werden
	@TransactionRequired
	public void service() {
		System.out.println("in service() von ServiceImpl");
		
	}

}
