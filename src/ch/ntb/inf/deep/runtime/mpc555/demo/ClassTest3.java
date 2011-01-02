package ch.ntb.inf.deep.runtime.mpc555.demo;
import ch.ntb.inf.deep.runtime.mpc555.Kernel;
import ch.ntb.inf.deep.runtime.mpc555.driver.SCI2Plain;
import ch.ntb.inf.deep.unsafe.US;

/*changes:
 * 11.11.10	NTB/GRAU	creation
 */

public class ClassTest3 extends ClassTest2 {
	long l1;
	int i3 = 0x332211;
	static ClassTest3 test3;
	
	void send() {
		SCI2Plain.write((byte)'u');
	}
	
	public ClassTest3 () {
		l1 = 0x5555666677778888L;
	}
	
	static {
		SCI2Plain.start(9600, (byte)0, (short)8);
		SCI2Plain.write((byte)'0');
		test2 = new ClassTest2();
		test2.send();
		test3 = new ClassTest3();
		test3.send();
		SCI2Plain.write((byte)'1');
		run();
	}
}
