package org.barsf.camera.ds.cgt;

import java.nio.ByteBuffer;

import org.barsf.camera.webcam.WebcamDevice;
import org.barsf.camera.webcam.WebcamDevice.BufferAccess;
import org.barsf.camera.webcam.WebcamDriver;
import org.barsf.camera.webcam.WebcamTask;


public class WebcamReadBufferTask extends WebcamTask {

	private volatile ByteBuffer target = null;

	public WebcamReadBufferTask(WebcamDriver driver, WebcamDevice device, ByteBuffer target) {
		super(driver, device);
		this.target = target;
	}

	public ByteBuffer readBuffer() {
		try {
			process();
		} catch (InterruptedException e) {
			return null;
		}
		return target;
	}

	@Override
	protected void handle() {

		WebcamDevice device = getDevice();
		if (!device.isOpen()) {
			return;
		}

		if (!(device instanceof BufferAccess)) {
			return;
		}

		((BufferAccess) device).getImageBytes(target);
	}
}
