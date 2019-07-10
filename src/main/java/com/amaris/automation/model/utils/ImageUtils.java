package com.amaris.automation.model.utils;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.rauschig.jarchivelib.IOUtils;

public class ImageUtils {

	/**
	 * Compares two images in a array of bytes and return the similarity percentage
	 *
	 * @param byteArray1
	 * @param byteArray2
	 * @return double
	 */
	public static double compareImages(byte[] byteArray1, byte[] byteArray2) {
		int coincidences = 0;
		int[][] screenshot1 = byteToPixelsWithoutRGB(byteArray1);
		int[][] screenshot2 = byteToPixelsWithoutRGB(byteArray2);

		if(screenshot1.length == screenshot2.length && screenshot1[0].length == screenshot2[0].length) {
			for(int i = 0; i < screenshot2.length; i++) {
				for(int j = 0; j < screenshot2[0].length; j++) {
					if(screenshot1[i][j] == screenshot2[i][j]) {
						coincidences++;
					}
				}
			}
		}

		return coincidences / (double) (screenshot1.length * screenshot1[0].length) * 100;
	}

	/**
	 * Converts a BufferedImage object into a byte array
	 *
	 * @param image
	 * @return byte[]
	 */
	public static byte[] buffImageToByte(BufferedImage image) {
		byte[] result = null;

		try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			ImageIO.write(image, "jpg", baos);

			result = baos.toByteArray();
		} catch(IOException e) {}

		return result;
	}

	/**
	 * Converts a byte array into a BufferedImage object
	 *
	 * @param byteArray
	 * @return BufferedImage
	 */
	public static BufferedImage byteToBuffImage(byte[] byteArray) {
		BufferedImage result = null;

		try(ByteArrayInputStream bais = new ByteArrayInputStream(byteArray)) {
			result = ImageIO.read(bais);
		} catch(IOException e) {}

		return result;
	}

	public static byte[] cropImage(byte[] image, int coordX, int coordY, int width, int height) {
		byte[] result = image;
		ByteArrayOutputStream baos = null;

		try(ByteArrayInputStream bais = new ByteArrayInputStream(image)) {
			if(width > 0 && height > 0) {
				BufferedImage img = ImageIO.read(bais);
				img = img.getSubimage(coordX, coordY, width, height);

				baos = new ByteArrayOutputStream();
				ImageIO.write(img, "jpg", baos);
				baos.flush();
				byte[] finalImage = baos.toByteArray();
				baos.close();

				result = finalImage;
			} else {
				System.out.println("Negative or zero width/height: " + width + "/" + height);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(baos);
		}

		return result;
	}

	/**
	 * Transform an image byte array to a matrix of pixels without using RGB
	 *
	 * @param byteArray
	 * @return pixelMatrix
	 */
	public static int[][] byteToPixels(byte[] byteArray) {
		int[][] result = null;

		try(ByteArrayInputStream bais = new ByteArrayInputStream(byteArray)) {
			BufferedImage img = ImageIO.read(bais);

			int width = img.getWidth();
			int height = img.getHeight();

			result = new int[height][width];

			for(int row = 0; row < height; row++) {
				for(int col = 0; col < width; col++) {
					result[row][col] = img.getRGB(col, row);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Transform an image byte array to a matrix of pixels without using RGB
	 *
	 * @param byteArray
	 * @return pixelMatrix
	 */
	public static int[][] byteToPixelsWithoutRGB(byte[] byteArray) {
		int[][] pixelMatrix = new int[0][0];

		try(ByteArrayInputStream bais = new ByteArrayInputStream(byteArray)) {
			BufferedImage image = ImageIO.read(bais);

			int width = image.getWidth();
			int height = image.getHeight();

			byte[] pixels;

			pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();

			pixelMatrix = new int[height][width];
			if(image.getAlphaRaster() != null) {
				int row = 0;
				int col = 0;
				int pixelLength = 4;

				for(int pixel = 0; pixel < pixels.length - 3; pixel += pixelLength) {
					int argb = 0;

					argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
					argb += ((int) pixels[pixel + 1] & 0xff); // blue
					argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
					argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
					pixelMatrix[row][col] = argb;
					col++;

					if(col == width) {
						col = 0;
						row++;
					}
				}
			} else {
				int row = 0;
				int col = 0;
				int pixelLength = 3;

				for(int pixel = 0; pixel < pixels.length - 2; pixel += pixelLength) {
					int argb = 0;

					argb += -16777216; // 255 alpha
					argb += ((int) pixels[pixel] & 0xff); // blue
					argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
					argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
					pixelMatrix[row][col] = argb;
					col++;

					if(col == width) {
						col = 0;
						row++;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		return pixelMatrix;
	}
	
	private int recalculateWidth(int width, int targetWidth) {
		if(width > targetWidth) {
			width /= 2;
			width = (width < targetWidth) ? targetWidth : width;
		}
		
		return width;
	}
	
	private int recalculateHeight(int height, int targetHeight) {
		if(height > targetHeight) {
			height /= 2;
			height = (height < targetHeight) ? targetHeight : height;
		}
		
		return height;
	}


	public BufferedImage scaleByWidth(BufferedImage image, int targetWidth) {
		return scale(image, targetWidth, targetWidth / image.getWidth() * image.getHeight());
		
	}


	public BufferedImage scaleByHeight(BufferedImage image, int targetHeight) {
		return scale(image, targetHeight / image.getHeight() * image.getWidth(), targetHeight);
	}
	/**
	 * Method to rezise an image to a target width and height
	 *
	 * @param image
	 * @param targetWidth
	 * @param targetHeight
	 */
	public BufferedImage scale(BufferedImage image, int targetWidth, int targetHeight) {
		int type = (image.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
		BufferedImage ret = image;
		BufferedImage scratchImage = null;
		Graphics2D g2 = null;

		int width = image.getWidth();
		int height = image.getHeight();
		int prevWidth = width;
		int prevHeight = height;

		do {
			width = recalculateWidth(width, targetWidth);
			height = recalculateHeight(height, targetHeight);

			if(scratchImage == null) {
				scratchImage = new BufferedImage(width, height, type);
				g2 = scratchImage.createGraphics();
			}

			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2.drawImage(ret, 0, 0, width, height, 0, 0, prevWidth, prevHeight, null);

			prevWidth = width;
			prevHeight = height;
			ret = scratchImage;
		} while(width != targetWidth || height != targetHeight);

		g2.dispose();

		if(targetWidth != ret.getWidth() || targetHeight != ret.getHeight()) {
			scratchImage = new BufferedImage(targetWidth, targetHeight, type);
			g2 = scratchImage.createGraphics();
			g2.drawImage(ret, 0, 0, null);
			g2.dispose();
			ret = scratchImage;
		}

		return ret;
	}

	/**
	 * Method to save an image byte array into the file "filePath"
	 *
	 * @param byteArray
	 * @param filePath
	 */
	public static void writeByteImageToFile(byte[] byteArray, String filePath) {
		filePath = filePath.toLowerCase().endsWith(".jpg") ? filePath : filePath + ".jpg";

		new File(filePath.substring(0, filePath.lastIndexOf('/'))).mkdir();

		try(OutputStream stream = new FileOutputStream(filePath)) {
			stream.write(byteArray);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to save an image byte array into the file "filePath"
	 *
	 * @param filePath
	 * @throws IOException
	 */
	public static BufferedImage readImageFromFile(String filePath) throws IOException {
		filePath = filePath.toLowerCase().endsWith(".jpg") ? filePath : filePath + ".jpg";

		return ImageIO.read(new File(filePath));
	}
}