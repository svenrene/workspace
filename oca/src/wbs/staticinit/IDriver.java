package wbs.staticinit;

public interface IDriver {

	public IConnection connect(String url);
	public boolean acceptsURL(String url);
	
}
