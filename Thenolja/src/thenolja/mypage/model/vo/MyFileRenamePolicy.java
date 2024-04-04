package thenolja.mypage.model.vo;

import java.io.File;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{
   
   
   @Override
   public File rename(File originFile) {
      
      // 원본 파일명!!
      
	  String originName = originFile.getName();
      
	  int randomNo = (int)(Math.random() * 90000) + 10000;
	  
	  String ext = originName.substring(originName.lastIndexOf("."));
		  
	  String changeName = "profile" + "_" + randomNo + ext;
	  
	  return new File(originFile.getParent(), changeName);
         
   }
   
      
   
}
