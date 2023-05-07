package LinuxCommands.Service;

import java.io.File;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceClass {

	public ResponseEntity<Object> createDirectory() {
		{ 
			File file = new File("/home/vvdn/Downloads/123"); 
			if (file.mkdir() == true) { 
				//System.out.println("Directory has been created successfully"); 
				return new ResponseEntity<>("Directory has been created successfully", HttpStatus.CREATED);
			} 
		}
		return new ResponseEntity<>("Directory cannot be created", HttpStatus.BAD_REQUEST);
	}

	public Object moveDirectory() {
		String[] shCommand = {"/bin/sh", "-c", "mv /home/vvdn/Downloads/myFile.csv /home/vvdn/Downloads/123"}; 
		Runtime rt = Runtime.getRuntime();
		try
		{
			rt.exec(shCommand);
		}
		catch (Exception e)
		{
			System.out.println("Execute Command Error:");
			e.printStackTrace();
		}
		return new ResponseEntity<>("File moved successfully", HttpStatus.OK);
	}

	public Object copyDirectory() {
		String[] shCommand = {"/bin/sh", "-c", "cp /home/vvdn/Downloads/123/myFile.csv /home/vvdn/Downloads/1234"}; 
	    Runtime rt = Runtime.getRuntime();
	    try
	    {
	        rt.exec(shCommand);
	    }
	    catch (Exception e)
	    {
	        System.out.println("Execute Command Error:");
	        e.printStackTrace();
	    }
	    return new ResponseEntity<>("File copied successfully", HttpStatus.OK);
	}

	public Object deleteDirectory() {
		String[] b = new String[] {"/bin/sh", "-c", "rm -r /home/vvdn/Downloads/123"};
		try {
			Runtime.getRuntime().exec(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Directry deleted successfully", HttpStatus.OK);	
	}
}
