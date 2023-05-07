package LinuxCommands.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import LinuxCommands.Service.ServiceClass;

@RestController
public class ControllerClass {
	
	@Autowired
	ServiceClass serviceClass;
	
	@PostMapping("/createDirectory")
	public Object createDirectory() {
		return serviceClass.createDirectory();
	}
	
	@PostMapping("/moveDirectory")
	public Object moveDirectory() {
		return serviceClass.moveDirectory();
	}
	
	@PostMapping("/copyDirectory")
	public Object copyDirectory() {
		return serviceClass.copyDirectory();
	}
	
	@DeleteMapping("/deleteDirectory")
	public Object deleteDirectory() {
		return serviceClass.deleteDirectory();
	}

}
