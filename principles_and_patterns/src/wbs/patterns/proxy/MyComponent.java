package wbs.patterns.proxy;


// könnte z.b. der quotenrechner im lottoprojekt sein
// hat allerlei abhängigkeiten
// lässt diese abhängigkeiten vom execution environment auflösen
public class MyComponent {
	
	// das execution environment wird ein referenz auf einem von ihm generierten proxy
	// einspritzen
	
	@Dependency
	private IService service;
	
	// bietet irgendeinen dienst an
	public void myService() {
		// wir machen was ...
		// wir machen was ...
		// wir rufen service von IService auf
		service.service();
		// wir machen weiter ...
		// wir machen weiter ...
	}
	
}
