package aula8.ex2;

import java.io.*;

class Bitmap {
	BitmapFileHeader fileHeader;
	BitmapInfoHeader infoHeader;
	byte[] data;

	public Bitmap(File f) throws IOException {
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);

        fileHeader = new BitmapFileHeader(dis.readShort(), dis.readInt(), dis.readShort(), dis.readShort(), dis.readInt());
        infoHeader = new BitmapInfoHeader(
                dis.readInt(),dis.readInt(),dis.readInt(), dis.readShort(), dis.readShort(), dis.readInt(),dis.readInt(),dis.readInt(), dis.readInt(),dis.readInt(),dis.readInt());

        data = new byte[dis.available()];
        dis.read(data);

        dis.close();
        fis.close();
    }

    public Bitmap(BitmapFileHeader fileHeader, BitmapInfoHeader infoHeader, byte[] data){
        this.fileHeader = fileHeader;
        this.infoHeader = infoHeader;
        this.data = data;
    }

    public void exportAsBMP(String path) throws  IOException {
        FileOutputStream fos = new FileOutputStream(path);
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeShort(fileHeader.type);
        dos.writeInt(fileHeader.size);
        dos.writeShort(fileHeader.reserved1);
        dos.writeShort(fileHeader.reserved2);
        dos.writeInt(fileHeader.offBits);

        dos.writeInt(infoHeader.size);
        dos.writeInt(infoHeader.width);
        dos.writeInt(infoHeader.height);
        dos.writeShort(infoHeader.planes);
        dos.writeShort(infoHeader.bitCount);
        dos.writeInt(infoHeader.compression);
        dos.writeInt(infoHeader.sizeImage);
        dos.writeInt(infoHeader.xPelsPerMeter);
        dos.writeInt(infoHeader.yPelsPerMeter);
        dos.writeInt(infoHeader.clrUsed);
        dos.writeInt(infoHeader.clrImportant);

        dos.write(data);

        dos.close();
        fos.close();
    }

    public Bitmap shrink() {
	    int height = Math.abs(infoHeader.height);
	    int width = Math.abs(infoHeader.width) * 3;
	    byte[] new_data = new byte[data.length / 4];

	    int x = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j+=6) {
                if(i % 2 == 0) {
                    new_data[x] = data[j + (width * i)];
                    new_data[x+1] = data[j + (width * i) + 1];
                    new_data[x+2] = data[j + (width * i) + 2];
                    x+=3;
                }
            }
        }

        BitmapFileHeader bfh = new BitmapFileHeader(fileHeader.type, fileHeader.size - new_data.length * 3, fileHeader.reserved1, fileHeader.reserved2, fileHeader.offBits);
        BitmapInfoHeader bih = new BitmapInfoHeader(infoHeader.size, infoHeader.width / 2, infoHeader.height / 2, infoHeader.planes, infoHeader.bitCount, infoHeader.compression, new_data.length, infoHeader.xPelsPerMeter / 2, infoHeader.yPelsPerMeter / 2, infoHeader.clrUsed, infoHeader.clrImportant);
        return new Bitmap(bfh, bih, new_data);
	}

	public Bitmap flipHorizontal() {
        int height = Math.abs(infoHeader.height);
        int width = Math.abs(infoHeader.width) * 3;
        byte[] new_data = new byte[data.length];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j+=3) {
                new_data[(((i+1)*width) - j) - 1]     = data[j + (width * i) + 2];
                new_data[(((i+1)*width) - (j+1)) - 1] = data[j + (width * i) + 1];
                new_data[(((i+1)*width) - (j+2)) - 1] = data[j + (width * i)];
            }
        }
        return new Bitmap(fileHeader, infoHeader, new_data);
    }

    public Bitmap flipVertical() {
        int height = Math.abs(infoHeader.height);
        int width = Math.abs(infoHeader.width) * 3;
        byte[] new_data = new byte[data.length];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j+=3) {
                new_data[(((height-i-1)*width) + j)]     = data[j + (width * i)];
                new_data[(((height-i-1)*width) + (j+1))] = data[j + (width * i) + 1];
                new_data[(((height-i-1)*width) + (j+2))] = data[j + (width * i) + 2];
            }
        }
        return new Bitmap(fileHeader, infoHeader, new_data);
    }

    public Bitmap reverseBytes() {
	    BitmapFileHeader bfh = new BitmapFileHeader(Short.reverseBytes(fileHeader.type),Integer.reverseBytes(fileHeader.size),Short.reverseBytes(fileHeader.reserved1),Short.reverseBytes(fileHeader.reserved2),Integer.reverseBytes(fileHeader.offBits));
	    BitmapInfoHeader bih = new BitmapInfoHeader(Integer.reverseBytes(infoHeader.size), Integer.reverseBytes(infoHeader.width), Integer.reverseBytes(infoHeader.height), Short.reverseBytes(infoHeader.planes), Short.reverseBytes(infoHeader.bitCount), Integer.reverseBytes(infoHeader.compression),Integer.reverseBytes(infoHeader.sizeImage), Integer.reverseBytes(infoHeader.xPelsPerMeter), Integer.reverseBytes(infoHeader.yPelsPerMeter), Integer.reverseBytes(infoHeader.clrUsed), Integer.reverseBytes(infoHeader.clrImportant));
        return new Bitmap(bfh, bih, data);
	}
}
