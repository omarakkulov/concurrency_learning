package com.akkulov.javarush1.java_core.packet5.ex1_factory_method_param;

import com.akkulov.javarush1.java_core.packet5.ex1_factory_method_param.readers.BmpReader;
import com.akkulov.javarush1.java_core.packet5.ex1_factory_method_param.readers.JpgReader;
import com.akkulov.javarush1.java_core.packet5.ex1_factory_method_param.readers.PngReader;

public final class ImageReaderFactory {

  private ImageReaderFactory() {
  }

  public static ImageReader getImageReader(ImageType imageType) {
    if (imageType == null) {
      throw new IllegalArgumentException("Unsupported image type: " + imageType);
    }

    ImageReader imageReader;

    switch (imageType) {
      case BMP:
        imageReader = new BmpReader();
        break;
      case JPG:
        imageReader = new JpgReader();
        break;
      case PNG:
        imageReader = new PngReader();
        break;
      default:
        throw new IllegalArgumentException("Unsupported image type: " + imageType);
    }

    return imageReader;
  }
}

