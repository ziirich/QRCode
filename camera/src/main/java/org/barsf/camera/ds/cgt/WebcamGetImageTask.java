package org.barsf.camera.ds.cgt;

import java.awt.image.BufferedImage;

import org.barsf.camera.webcam.WebcamDriver;
import org.barsf.camera.webcam.WebcamTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.barsf.camera.webcam.WebcamDevice;


public class WebcamGetImageTask extends WebcamTask {

	private static final Logger LOG = LoggerFactory.getLogger(WebcamGetImageTask.class);

	private volatile BufferedImage image = null;

	public WebcamGetImageTask(WebcamDriver driver, WebcamDevice device) {
		super(driver, device);
	}

	public BufferedImage getImage() {

		try {
			process();
		} catch (InterruptedException e) {
			LOG.debug("Interrupted exception", e);
			return null;
		}

		return image;
	}

	@Override
	protected void handle() {

		WebcamDevice device = getDevice();
		if (!device.isOpen()) {
			return;
		}

		image = device.getImage();
	}
}
