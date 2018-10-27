/*
 * Copyright 2011 - 2013 NTB University of Applied Sciences in Technology
 * Buchs, Switzerland, http://www.ntb.ch/inf
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package ch.ntb.inf.deep.runtime.zynq7000.demo;

import ch.ntb.inf.deep.runtime.arm32.Task;
import ch.ntb.inf.deep.runtime.zynq7000.Izybo7000;
import ch.ntb.inf.deep.unsafe.arm.US;

/* changes:
 * 19.10.18	NTB/Urs Graf	creation
 */

public class Blinker extends Task implements Izybo7000{
	static int count;	// class variable
	int times;	// instance variable

	public static int getNofBlinkers () { 	// class method
		return count;
	}

	public void changePeriod (int period) {	// instance method 
		this.period = period;
	}

	public void action () {	// instance method, overwritten
		US.PUT4(GPIO_DATA0, US.GET4(GPIO_DATA0) ^ 0x80);
		if (this.nofActivations == this.times) Task.remove(this);
	}
	
	public Blinker (int pin, int period, int times) {	// base constructor
		this.times = times;
		US.PUT4(SLCR_UNLOCK, 0xdf0d);
		US.PUT4(SLCR_MIO_PIN_07, 0x600);
		US.PUT4(GPIO_DIR0, 0x80);
		this.period = period;	
		Task.install(this);
		count++;
	}
	
	public Blinker (int pin, int period) {	// second constructor
		this(pin, period, 0);	// call to base constructor
	}

	static {	// class constructor
		count = 0;
	}
}