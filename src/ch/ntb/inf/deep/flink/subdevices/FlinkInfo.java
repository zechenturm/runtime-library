package ch.ntb.inf.deep.flink.subdevices;

import ch.ntb.inf.deep.flink.core.FlinkDefinitions;
import ch.ntb.inf.deep.flink.core.FlinkSubDevice;

public class FlinkInfo implements FlinkDefinitions {

	public FlinkSubDevice dev;
	
	public FlinkInfo(FlinkSubDevice dev) {
		this.dev = dev;
	}
	
	public int getMemLength() {
		return dev.read(0);
	}
	
	public char[] getDescription() {
		int len = 28;
		char res[] = new char[len];
		for (int i = 0; i < len; i += 4) {
			int reg = dev.read(4 + i);
			res[i] = (char) (reg & 0xff);
			res[i + 1] = (char) ((reg>>8) & 0xff);
			res[i + 2] = (char) ((reg>>16) & 0xff);
			res[i + 3] = (char) ((reg>>24) & 0xff);
		}
		return res;
	}
}