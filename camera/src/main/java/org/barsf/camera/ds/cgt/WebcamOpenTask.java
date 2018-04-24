package org.barsf.camera.ds.cgt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.barsf.camera.webcam.WebcamDevice;
import org.barsf.camera.webcam.WebcamDriver;
import org.barsf.camera.webcam.WebcamTask;


public class WebcamOpenTask extends WebcamTask {

	private static final Logger LOG = LoggerFactory.getLogger(WebcamOpenTask.class);

	public WebcamOpenTask(WebcamDriver driver, WebcamDevice device) {
		super(driver, device);
	}

	public void open() throws InterruptedException {
		process();
	}

	@Override
	protected void handle() {

		WebcamDevice device = getDevice();

		if (device.isOpen()) {
			return;
		}

		if (device.getResolution() == null) {
			device.setResolution(device.getResolutions()[0]);
		}

		LOG.info("Opening webcam {}", device.getName());

		device.open();
	}
}
