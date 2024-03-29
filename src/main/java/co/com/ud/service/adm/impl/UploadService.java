package co.com.ud.service.adm.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Base64;

import org.springframework.stereotype.Service;

import co.com.ud.adm.dto.UploadArticuloDto;
import co.com.ud.service.adm.IUploadService;


@Service
public class UploadService implements IUploadService {
	
	private static String REPO_PDF = "c:\\repoFiles\\";

	@Override
	public Boolean saveFileRepository(String base64, Long idArt) {
		//Elimino parte del Base 64
		base64 = base64.replace("data:application/pdf;base64,", "");
		System.out.println(base64);
		
		//
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decodedByteArray = decoder.decode(base64);
		File file = new File( REPO_PDF + idArt + ".pdf" );
		try {
            OutputStream os = new FileOutputStream(file);
            os.write(decodedByteArray);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
		return Boolean.TRUE;
	}
	@Override
	public UploadArticuloDto pdfToBase64(Long idArt) {
		UploadArticuloDto articulo = new UploadArticuloDto();
		try {
			articulo.setIdArticulo(idArt);
			
			File file = new File(REPO_PDF + idArt + ".pdf"  );
			byte[] fileContent = Files.readAllBytes(file.toPath());
		
			byte[] decodedBytes = Base64.getEncoder().encode(fileContent);
			String decodedString = new String(decodedBytes);
			articulo.setBase64(decodedString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return articulo;
	}

}
