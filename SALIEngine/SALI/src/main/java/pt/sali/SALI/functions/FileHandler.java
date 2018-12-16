package pt.sali.SALI.functions;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service("Filehandler")
public class FileHandler {

	@Autowired
	FileStorageService FileStorageService;
	
	public Resource getFileByName(String filename) {

		return FileStorageService.loadFileAsResource(filename);
	}

	public UploadFileResponse saveFile(MultipartFile file) {

		String fileName = FileStorageService.storeFile(file);
		// String fileName = rand.replace("-", "");

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("Utilizador/downloadFile/")
				.path(fileName).toUriString();
		System.out.println(fileDownloadUri);

		return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());

	}

	@Service("FileStorageService")
	public class FileStorageService {

		private final Path fileStorageLocation;

		@Autowired
		public FileStorageService(FileStorageProperties fileStorageProperties) {
			this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

			try {
				Files.createDirectories(this.fileStorageLocation);
			} catch (Exception ex) {
				throw new FileStorageException(
						"Could not create the directory where the uploaded files will be stored.", ex);
			}
		}

		public String storeFile(MultipartFile file) {
			// Normalize file name
			String rand = UUID.randomUUID().toString();

			// String extensao = file.getOriginalFilename().toString(); //Apanhar o nome
			// original e á frente meter lo no fim
			String ext = FilenameUtils.getExtension(file.getOriginalFilename());

			String fileName = StringUtils.cleanPath(rand.replace("-", "")) + "." + ext; // Para ter-mos a extensao do
																						// ficheiro (.png.jpec etc)

			try {
				// Check if the file's name contains invalid characters
				if (fileName.contains("..")) {
					throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
				}

				// Copy file to the target location (Replacing existing file with the same name)
				Path targetLocation = this.fileStorageLocation.resolve(fileName);
				Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

				return fileName;
			} catch (IOException ex) {
				throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
			}
		}

		public Resource loadFileAsResource(String fileName) {
			try {
				Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
				Resource resource = new UrlResource(filePath.toUri());
				if (resource.exists()) {
					return resource;
				} else {
					throw new MyFileNotFoundException("File not found " + fileName);
				}
			} catch (MalformedURLException ex) {
				throw new MyFileNotFoundException("File not found " + fileName, ex);
			}
		}
	}

	public class FileStorageException extends RuntimeException {
		public FileStorageException(String message) {
			super(message);
		}

		public FileStorageException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	@ConfigurationProperties(prefix = "file")
	@Service("FileStorageProperties")
	public class FileStorageProperties {
		private String uploadDir;

		public String getUploadDir() {
			return uploadDir;
		}

		public void setUploadDir(String uploadDir) {
			this.uploadDir = uploadDir;
		}
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class MyFileNotFoundException extends RuntimeException {
		public MyFileNotFoundException(String message) {
			super(message);
		}

		public MyFileNotFoundException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	public class UploadFileResponse {
		private String fileName;
		private String fileDownloadUri;
		private String fileType;
		private long size;

		public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size) {
			this.fileName = fileName;
			this.fileDownloadUri = fileDownloadUri;
			this.fileType = fileType;
			this.size = size;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getFileDownloadUri() {
			return fileDownloadUri;
		}

		public void setFileDownloadUri(String fileDownloadUri) {
			this.fileDownloadUri = fileDownloadUri;
		}

		public String getFileType() {
			return fileType;
		}

		public void setFileType(String fileType) {
			this.fileType = fileType;
		}

		public long getSize() {
			return size;
		}

		public void setSize(long size) {
			this.size = size;
		}
	}
	
	public BufferedImage cropImageSquare(byte[] image) throws IOException {
		  // Get a BufferedImage object from a byte array
		  InputStream in = new ByteArrayInputStream(image);
		  BufferedImage originalImage = ImageIO.read(in);
		  
		  // Get image dimensions
		  int height = originalImage.getHeight();
		  int width = originalImage.getWidth();
		  
		  // The image is already a square
		  if (height == width) {
		    return originalImage;
		  }
		  
		  // Compute the size of the square
		  int squareSize = (height > width ? width : height);
		  
		  // Coordinates of the image's middle
		  int xc = width / 2;
		  int yc = height / 2;
		  
		  // Crop
		  BufferedImage croppedImage = originalImage.getSubimage(
		      xc - (squareSize / 2), // x coordinate of the upper-left corner
		      yc - (squareSize / 2), // y coordinate of the upper-left corner
		      squareSize,            // widht
		      squareSize             // height
		  );
		  
		  return croppedImage;
		}
}
