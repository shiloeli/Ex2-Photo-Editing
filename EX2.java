
public class EX2 {
	//1
		public static int[][] rgb2gray(int[][][] im) {
			int[][] gray = new int[im[0].length][im[0][0].length];
			for (int i = 0; i < im.length; i++) {
				for (int j = 0; j < im[0].length; j++) {
					for (int k = 0; k < im[0][0].length; k++) {
						gray[j][k] = (int) ((0.3 * im[0][j][k]) + (0.59 * im[1][j][k]) + (0.11 * im[2][j][k]));
						gray[j][k] *= 255;
					}
				}
			}
			return gray;
		}

	//2
		public static int[][][] rotate90(int[][][] im) {

			int[][][] newim = new int[im.length][im[0][0].length][im[0].length];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < im[0].length; j++) {
					for (int k = 0; k < im[0][0].length; k++) {
						newim[i][k][im[0].length - 1 - j] = im[i][j][k];
					}
				}
			}
			return newim;
		}

		// 3
		public static int newvalue(int[][][] im, int x, int y, int n, int color) {
			int count = 0, sum = 0;
			for (int i = x - n; i < x + n; i++) {
				for (int j = y - n; j < y + n; j++) {
					if (i >= 0 && i < im[0].length && j >= 0 && j < im[0][0].length) {
						sum += im[color][i][j];
						count++;
					}
				}
			}
			return (int) (sum / count);
		}

		public static int[][][] Smooth(int[][][] im, int n) {

			int[][][] newim = new int[im.length][im[0].length][im[0][0].length];

			for (int i = 0; i < im[0].length; i++) {
				for (int j = 0; j < im[0][0].length; j++) {
					newim[0][i][j] = newvalue(im, i, j, n, 0);
					newim[1][i][j] = newvalue(im, i, j, n, 1);
					newim[2][i][j] = newvalue(im, i, j, n, 2);
				}
			}
			return newim;
		}

		// 4
		public static int[][] scaleup(double factor_h, double factor_w, int[][] im) {

			int[][] tmuna = new int[(int) (im.length * factor_h)][(int) (im[0].length * factor_w)];
			for (int i = 0; i < im.length; i++) {
				for (int j = 0; j < im[0].length; j++) {
					for (int fh = 0; fh < factor_h; fh++) {
						for (int fw = 0; fw < factor_w; fw++) {
							tmuna[(int) (i * factor_h + fh)][(int) (j * factor_w + fw)] = im[i][j];
						}
					}
				}
			}
			return tmuna;
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int[][][] im = MyImageIO.readImageFromFile("C:\\Users\\shilo\\OneDrive\\שולחן העבודה\\cat.jpg");
			// 1
			MyImageIO.writeImageToFile("C:\\Users\\shilo\\OneDrive\\שולחן העבודה\\cat1", rgb2gray(im));
			// 2
			MyImageIO.writeImageToFile("C:\\Users\\shilo\\OneDrive\\שולחן העבודה\\cat2", rotate90(im));
			// 3
			MyImageIO.writeImageToFile("C:\\Users\\shilo\\OneDrive\\שולחן העבודה\\cat3", Smooth(im, 2));
			// 4
			MyImageIO.writeImageToFile("C:\\Users\\shilo\\OneDrive\\שולחן העבודה\\cat4", scaleup(7, 3, rgb2gray(im)));
		}

	}
