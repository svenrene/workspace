package wbs.exceptions.bad;

class MyException extends Exception {

}

class BadConstructors {

	BadConstructors() throws Exception {

	}

}

public class BadConstructorsDemo1 extends BadConstructors {

	BadConstructorsDemo1() throws MyException {

	}
}
