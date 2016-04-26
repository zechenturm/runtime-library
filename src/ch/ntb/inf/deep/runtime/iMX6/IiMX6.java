package ch.ntb.inf.deep.runtime.iMX6;

import ch.ntb.inf.deep.runtime.arm32.Iarm32;

// Auto generated file (2016-04-11 11:48:00)

public interface IiMX6 extends Iarm32 {

	// System constants of CPU iMX6
	public static final int SRR1init = 0x3802;
	public static final int stackSize = 0x10000;
	public static final int SRAMB_Size = 0x4000;
	public static final int SRAMB_BaseAddr = 0x2800;
	public static final int SRAMA_Size = 0x2800;
	public static final int SRAMA_BaseAddr = 0x0;
	public static final int IMB = 0x0;

	// Specific registers of CPU iMX6
	public static final int SPR80 = 0x50;
	public static final int EIE = 0x50;
	public static final int GTCR_L = 0xa00200;
	public static final int GTCR_U = 0xa00204;
	public static final int GTCR = 0xa00208;
	public static final int GPIO2_DR = 0x20a0000;
	public static final int GPIO2_GDIR = 0x20a0004;
	public static final int GPIO2_PSR = 0x20a0008;
	public static final int IOMUXC_NAND_DATA02 = 0x20e028c;
}