package thenolja.mypage.model.vo;

import java.io.File;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{
   
   
   @Override
   public File rename(File originFile) {
      
	  String originName = originFile.getName();
      
	  int randomNo = (int)(Math.random() * 90000) + 10000;
	  
	  String ext = "";
	  String changeName = "";
	  
	  if(originName.contains(".")) {
		  ext = originName.substring(originName.lastIndexOf("."));
		  changeName = "profile" + "_" + randomNo + ext;
	  } else {
		  changeName = "nonePoint";
	  }
	  return new File(originFile.getParent(), changeName);
   }
   
      
   
}
