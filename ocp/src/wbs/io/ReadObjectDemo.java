package wbs.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

// frage: wird der konstruktor von SerializableObject bei der
// deserialisierung aufgerufen? NEIN

// frage: was passiert, wenn die version der klasse SerializableObject beim
// deserialieren nicht übereinstimmt mit der version der klasse, die beim
// serialisieren verwendet wurde, und kein feld serialVersionUID in der klasse
// SerializableObject definiert wurde? InvalidClassCastException

// frage: was passiert, wenn die version der klasse SerializableObject beim
// deserialieren nicht übereinstimmt mit der version der klasse, die beim
// serialisieren verwendet wurde, und kein feld serialVersionUID in der klasse
// Serializable definiert wurde, das in beiden versionen der klasse 
// übereinstimmt? keine exception. neu hinzugekommene felder werden bei der 
// deserialisierung mit dem default ihres typs initialisiert,

// was passiert beim deserialisieren  eines objektes, basisklasse
// nicht serialisierbar ist, und dessen basisklasse keinen parameterlosen
// konstruktor hat? InvalidClassException (no valid constructor)

public class ReadObjectDemo {

	public static void main(String[] args) throws IOException, 
			ClassNotFoundException {
		String path = "resources/io/stream/object.ser";
		try (ObjectInput ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(path)))) {
			// cast ggf mit instanceof absichern
			Object o = ois.readObject();
			SerializableObject so = (SerializableObject) o;
			System.out.println(o);
			System.out.println(so.feld1);
		}
	}
}
