package wbs.patterns.proxy;

public class ServiceProxyDemo {

	public static void main(String[] args) {
		/*
		 * wir rufen den dienst service() über seinen proxy auf
		 */
		IService service = new ServiceImpl();
		ServiceProxy proxy = new ServiceProxy(service);
		proxy.service();		
	}

}
